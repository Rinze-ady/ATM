package com.project.dao.impl;


import com.project.bean.UserBean;
import com.project.dao.BaseDao;
import com.project.dao.IUserDao;

import java.sql.SQLException;

/**
 * @author liuyulai
 * Created with IntelliJ IDEA.
 * Date: 21.5.25
 * Time: 20:58
 * Description: 用户持久层实现类
 */
public class UserDaoImpl extends BaseDao implements IUserDao {


    /**
     * 根据传入的用户名与密码查找用户对象
     * 应该可以同时用于登录界面的判断以及后期根据用户名查找账户
     * 需要在UI判断是否password是否允许为null值或""值传入
     * 登录时需要password不能为null,转账查询用户时允许password为null
     * @param name 姓名
     * @param password 密码
     * @return
     */
    @Override
    public UserBean findUserByNamePwd(String name, String password) {
        this.setConnection();
        UserBean user = new UserBean();

        String sql = "select*from t_user where u_name = ? ";
        if(password !=null && password.length() != 0){
            sql += " and u_pwd = ?";
        }

        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1,name);
            ps.setObject(2,password);

            rs = ps.executeQuery();
            if(rs.next()){
                user = fullUser();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeConnect();
        }

        return user;
    }

    @Override
    public void updateMoney(int id, Integer money) {
        this.setConnection();

        try {
            ps = con.prepareStatement("update t_user set u_money = u_money + ? where pk_userId = ?");
            ps.setObject(1, money);
            ps.setObject(2, id);

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeConnect();
        }
    }

    @Override
    public UserBean findUserMoneyById(int id) {
        UserBean user = new UserBean();
        this.setConnection();

        try {
            ps = con.prepareStatement("select*from t_user where pk_userId = ?");
            ps.setObject(1,id);

            rs = ps.executeQuery();
            if (rs.next()){
                user = fullUser();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeConnect();
        }


        return user;
    }

    @Override
    public UserBean checkByCode(String code) {
        UserBean us = new UserBean();
        this.setConnection();

        try {
            ps = con.prepareStatement("select*from t_user where u_name = ?");
            ps.setObject(1, code);


            rs = ps.executeQuery();
            if(rs.next()){
                us = fullUser();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeConnect();
        }

        return us;
    }

    /**
     *从结果集中得到数据，封装实体对象
     * @return
     */
    private UserBean fullUser(){
        UserBean us = new UserBean();

        try {
            us.setId(rs.getInt("pk_userId"));
            us.setUsername(rs.getString("u_name"));
            us.setPassword(rs.getString("u_pwd"));
            us.setMoney(rs.getInt("u_money"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return us;
    }

    public static void main(String[] args) {
        IUserDao dao = new UserDaoImpl();
//        System.out.println(dao.findUserByNamePwd("张三", "123"));
//        dao.updateMoney(2,5000);
//        System.out.println(dao.findUserMoneyById(2));
        System.out.println(dao.checkByCode("陆九"));
    }

}
