package com.project.dao.impl;


import com.project.bean.DealBean;
import com.project.dao.BaseDao;
import com.project.dao.IInfoDao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyulai
 * Created with IntelliJ IDEA.
 * Date: 21.5.25
 * Time: 21:27
 * Description: 交易信息持久层实现类
 */
public class InfoDaoImpl extends BaseDao implements IInfoDao {


    @Override
    public List<DealBean> findByCode(int userId) {
        List<DealBean> list = new ArrayList<>();
        this.setConnection();

        try {
            ps = con.prepareStatement("select*from t_info where pk_infoId = ?");
            ps.setObject(1, userId);

            rs = ps.executeQuery();
            if(rs.next()){
                DealBean deal = new DealBean();
                deal.setContent(rs.getString("tr_content"));
                deal.setDate(LocalDate.parse(rs.getString("tr_time")));
                deal.setMoney(rs.getInt("tr_money"));

                list.add(deal);
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeConnect();
        }

        return null;
    }

    @Override
    public void addInfo(DealBean info) {
        this.setConnection();

        try {
            ps = con.prepareStatement("insert into t_info" +
                    "(i_content, i_money, i_date, fk_userId)values(?,?,?,?)");

            ps.setObject(1,info.getContent());
            ps.setObject(2,info.getMoney());
            ps.setObject(3,info.getDate());
            //注意此处是如何添加外键的
            ps.setObject(4,info.getUserBean().getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            this.closeConnect();
        }

    }

    public static void main(String[] args) {
        IInfoDao dao = new InfoDaoImpl();
        System.out.println(dao.findByCode(2));
    }
}
