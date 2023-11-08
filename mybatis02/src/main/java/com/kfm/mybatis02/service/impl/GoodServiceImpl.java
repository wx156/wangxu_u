package com.kfm.mybatis02.service.impl;

import com.github.pagehelper.PageHelper;
import com.kfm.mybatis02.dao.IGoodDao;
import com.kfm.mybatis02.exception.ServiceException;
import com.kfm.mybatis02.model.GoodsModel;
import com.kfm.mybatis02.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodServiceImpl implements IGoodService {
    @Autowired
    private IGoodDao goodDao;
    @Override
    public List<GoodsModel> listUpGoods(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return goodDao.listUpGoods();
    }

    @Override
    public List<GoodsModel> listDownGoods(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return goodDao.listDownGoods();
    }
}
