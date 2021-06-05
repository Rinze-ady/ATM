package com.project.bean;

/**
 * @author liuyulai
 * Created with IntelliJ IDEA.
 * Date: 21.5.25
 * Time: 20:46
 * Description: 用户
 */
public class UserBean {
    /**
     * 用户主键id
     */
    private int id;
    /**
     * 账户名
     */
    private String username;
    /**
     * 账户密码
     */
    private String password;
    /**
     * 账户余额
     */
    private int money;

    public UserBean() {
    }

    public UserBean(String username, String password, int money) {
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}' + "\n";
    }
}
