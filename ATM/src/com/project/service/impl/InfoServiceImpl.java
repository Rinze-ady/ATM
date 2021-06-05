package com.project.service.impl;

import com.project.bean.DealBean;
import com.project.dao.IInfoDao;
import com.project.service.IInfoService;

import java.util.List;

public class InfoServiceImpl implements IInfoService {
    /**持久组件*/
    private IInfoDao dao;

    @Override
    public List<DealBean> findByCode(int userId) {
        return dao.findByCode(userId);
    }
}
