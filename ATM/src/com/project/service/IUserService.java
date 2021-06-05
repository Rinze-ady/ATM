package com.project.service;

import com.project.bean.DealBean;
import com.project.bean.UserBean;

import java.util.List;

/**
 * @author liuyulai
 * Created with IntelliJ IDEA.
 * Date: 21.5.25
 * Time: 22:11
 * Description: No Description
 */
public interface IUserService {
    /**
     * 根据传入的用户名与密码查找用户对象
     * 应该可以同时用于登录界面的判断以及后期根据用户名查找账户
     * 需要在UI判断是否password是否允许为null值或""值传入
     * 登录时需要password不能为null,转账查询用户时允许password为null
     *
     * @param name     用户名
     * @param password 用户密码
     * @return com.project.bean.UserBean
     * @date 21.5.25 22:00
     */
    public UserBean findUserByNamePwd(String name, String password);

    /**
     * 用户存款,同时记录交易日志
     *
     * @param id
     * @param money
     * @return boolean 返回布尔值判断是否存款成功
     * @date 21.5.25 22:14
     */
    public void addUserMoney(int id, Integer money);

    /**
     * 用户取款,同时记录交易日志，需要进行判断
     *
     * @param id
     * @param money
     * @return boolean 返回布尔值判断是否取款成功
     * @date 21.5.25 22:15
     */
    public boolean reduceUserMoney(int id, Integer money);

    /**
     * 用户转账操作
     *1、查询目标账号。如果不存在，返回“目标账号不存在”
     * 2、按ID查询目标账号的余额，判断余额是否充足，如果余额不足，返回“余额不足”
     * 3、源账号减去金额，目标账号加上金额
     * 4、添加源账号转出金额的日志
     * 5、添加目标账号转入金额的日志
     * @param id  转账账户
     * @param transfer  接收账户
     * @param money 转账金额
     * @return String 返回转账失败的信息，如果转账成功，返回null
     * @date 21.5.25 22:21
     */
    public String tranceUserMoney(int id , String transfer, Integer money);


    /**
     * 根据用户当前id查询用户余额
     * 用于展示信息以及判断转账操作是否能够成立
     *
     * @param id
     * @return int
     * @date 21.5.25 22:07
     */
    public UserBean findUserMoneyById(int id);



}
