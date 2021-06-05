package com.project.bean;

import java.time.LocalDate;

/**
 * @author liuyulai
 * Created with IntelliJ IDEA.
 * Date: 21.5.25
 * Time: 20:51
 * Description: 交易
 */
public class DealBean {
    /**
     * 主键id
     */
    private int id;
    /**
     * 添加记录的时间
     */
    private LocalDate date = LocalDate.now();
    /**
     * 交易内容
     */
    private String content;
    /**
     * 交易额
     */
    private int money;
    /**
     * 交易用户(id被包含在其中)
     * 对象模型，一对多关系
     */
    private UserBean userBean;

    public DealBean() {
    }

    /*    public DealBean(String content, int money, UserBean userBean) {
            this.content = content;
            this.money = money;
            this.userBean = userBean;
            看下面这个地方的另一种写法
        }*/
    public DealBean(String content, int money, int userId) {
        this.content = content;
        this.money = money;
        this.userBean = new UserBean();
        this.userBean.setId(userId);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    @Override
    public String toString() {
        return "DealBean{" +
                "id=" + id +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", money=" + money +
                ", userBean=" + userBean +
                '}' + "\n";
    }
}
