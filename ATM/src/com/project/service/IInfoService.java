package com.project.service;

import com.project.bean.DealBean;
import com.project.dao.IInfoDao;

import java.util.List;

public interface IInfoService {


    /**
     * 按用户ID查询交易日志
     * @param userId 用户id
     * @return 日志集合
     */
    public List<DealBean> findByCode(int userId);
}
