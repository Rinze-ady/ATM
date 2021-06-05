package com.project.dao;


import java.sql.*;

/**
 * @author liuyulai
 * Created with IntelliJ IDEA.
 * Date: 21.5.25
 * Time: 21:28
 * Description: 持久层数据库初始化连接
 */
public class BaseDao {

    protected Connection con;

    protected PreparedStatement ps;

    protected ResultSet rs;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:6789/mydb；?characterEncoding=utf-8", "root", "lovo");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConnect() {

        try {
            if (rs != null) {
                rs.close();
            }
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void main(String[] args) {
        BaseDao bd = new BaseDao();
        bd.setConnection();
        System.out.println(bd.con);
    }

}
