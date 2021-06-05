package com.project.dao;

import com.project.bean.UserBean;

/**
 * @author liuyulai
 * Created with IntelliJ IDEA.
 * Date: 21.5.25
 * Time: 20:57
 * Description: 用户持久层接口
 */
public interface IUserDao {
    /**
     * 根据传入的用户名与密码查找用户对象
     * 应该可以同时用于登录界面的判断以及后期根据用户名查找账户
     * 需要在UI判断是否password是否允许为null值或""值传入
     * 登录时需要password不能为null,转账查询用户时允许password为null
     *
     * @param name     用户名
     * @param password 用户密码
     * @return com.project.bean.UserBean
     * @date 21.5.25 21:00
     */
    public UserBean findUserByNamePwd(String name, String password);

    /**
     * 根据当前用户id修改用户账户金额
     *
     * @param id    用户id
     * @param money 用户所增删的金额(增加金额为正数,减少金额为负数)
     * @return void
     * @date 21.5.25 21:02
     */
    public void updateMoney(int id, Integer money);


    /**
     * 根据用户当前id查询用户余额
     * 用于展示信息以及判断转账操作是否能够成立
     * @param id
     * @return 用户实例对象
     */
    public UserBean findUserMoneyById(int id);

    /**
     * 验证账号是否存在
     * @param code 账号名
     * @return 账号对象，如果没有找到，返回null
     */
    public UserBean checkByCode(String code);

}
