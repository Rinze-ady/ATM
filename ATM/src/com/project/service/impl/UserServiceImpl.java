package com.project.service.impl;


import com.project.bean.DealBean;
import com.project.bean.UserBean;
import com.project.dao.IInfoDao;
import com.project.dao.IUserDao;
import com.project.service.IUserService;


/**
 * @author liuyulai
 * Created with IntelliJ IDEA.
 * Date: 21.5.25
 * Time: 22:12
 * Description: 用户业务层实现类
 */
public class UserServiceImpl implements IUserService {

    /**用户持久组件对象*/
    private IUserDao userDao;
    /**查询持久组件对象*/
    private IInfoDao infoDao;

    @Override
    public UserBean findUserByNamePwd(String name, String password) {
        return userDao.findUserByNamePwd(name, password);
    }

    @Override
    public void addUserMoney(int id, Integer money) {
        //根据账号修改金额
        userDao.updateMoney(id, money);
        //添加日志
        infoDao.addInfo(new DealBean("存入金额", money, id));

    }

    @Override
    public boolean reduceUserMoney(int id, Integer money) {
        //按账户查询余额并返回用户实例对象
        UserBean user = userDao.findUserMoneyById(id);
        if(user.getMoney() < money){
            return false;
        }
        //按账户修改金额，无返回对象
        userDao.updateMoney(id, -money);

        //添加日志，无返回对象
        infoDao.addInfo(new DealBean("取走金额",money,id));

        return false;
    }

    /**
     *  1、按目标账互查询账户是否存在。（持久层用户业务）
     *  2、如果不存在，返回“目标账号不存在”（if条件判断）
     *  3、按ID查询目标账号的余额。（持久层用户业务）
     *  3、判断余额是否充足，如果余额不足，返回“余额不足”（if条件判断）
     *  4、源账号减去金额，目标账号加上金额（持久层用户业务）
     *  5、添加源账号转出金额的日志（持久层查询业务）
     *  6、添加目标账号转入金额的日志（持久层查询业务）
     * @param id
     * @param transfer
     * @param money
     * @return
     */
    @Override
    public String tranceUserMoney(int id, String transfer, Integer money) {
        //查询目标账号
        UserBean targetCode = userDao.checkByCode(transfer);
        if(targetCode == null){
            return "目标账户不存在";
        }
        //查找源账号
        UserBean sourceCode = userDao.findUserMoneyById(id);
        if(sourceCode.getMoney() < money){
            return "余额不足";
        }
        //源账号减金额，目标账号加金额
        userDao.updateMoney(id, -money);
        userDao.updateMoney(targetCode.getId(), money);

        //源账号转出金额日志
        infoDao.addInfo(new DealBean("对"+transfer+"转出金额", money, id));

        //目标账号转入金额日志
        infoDao.addInfo(new DealBean(sourceCode.getUsername()+"转入金额", money, targetCode.getId()));

        return null;
    }

    @Override
    public UserBean findUserMoneyById(int id) {
        //根据id查询余额，返回用户实例对象
        return userDao.findUserMoneyById(id);
    }
}
