package com.project.dao;


import com.project.bean.DealBean;

import java.util.List;

/**
 * @author liuyulai
 * Created with IntelliJ IDEA.
 * Date: 21.5.25
 * Time: 21:04
 * Description: 交易信息持久层接口
 */
public interface IInfoDao {

    /**
     * 按用户ID查询交易日志
     * @param userId 用户id
     * @return 日志集合
     */
    public List<DealBean> findByCode(int userId);


    /**
     * 添加日志
     * @param info 日志对象
     */
    public void addInfo(DealBean info);






}
