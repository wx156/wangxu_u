package com.kfm.mybatis02.service.impl;

import com.github.pagehelper.PageHelper;
import com.kfm.mybatis02.dao.IGoodDao;
import com.kfm.mybatis02.exception.ServiceException;
import com.kfm.mybatis02.model.GoodsModel;
import com.kfm.mybatis02.model.UserModel;
import com.kfm.mybatis02.service.IGoodService;
import com.kfm.mybatis02.util.IdUtil;
import com.kfm.mybatis02.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
public class GoodServiceImpl implements IGoodService {
    @Autowired
    private IGoodDao goodDao;
    @Override
    public List<GoodsModel> listUpGoods(int page, int pageSize,GoodsModel goodsModel) {
        PageHelper.startPage(page,pageSize);
        List<GoodsModel> goodsModels = goodDao.listUpGoods(goodsModel);
        return goodsModels;
    }

    @Override
    public List<GoodsModel> listDownGoods(int page, int pageSize,GoodsModel goodsModel) {
        PageHelper.startPage(page,pageSize);
        List<GoodsModel> goodsModels = goodDao.listDownGoods(goodsModel);
        return goodsModels;
    }

    @Override
    public Integer deleteById(int id) throws ServiceException {

        if (goodDao.deleteById(id) == 0){
            throw new ServiceException("删除失败");
        }else {
            return id;
        }
    }

    public Integer putAwayById(int id) throws ServiceException {
        if (goodDao.putAwayById(id) == 0){
            throw new ServiceException("上架失败");
        }else {
            return id;
        }
    }

    public Integer downById(int id) throws ServiceException {
        if (goodDao.downById(id) == 0){
            throw new ServiceException("下架失败");
        }else {
            return id;
        }
    }
    public GoodsModel findById(Integer id) {
        return goodDao.selectByPrimaryKey(id);
    }
    @Override
    public Integer update(GoodsModel goodsModel) throws ServiceException {
        if (ObjectUtils.isEmpty(goodsModel)){
            throw new ServiceException("商品不能为空");
        }

        int row = 0;
        if (ObjectUtils.isEmpty(goodsModel.getId())){

            row = goodDao.insertGoodmodel(goodsModel);
        }else {
            row = goodDao.updateByPrimaryKeySelective(goodsModel);
        }
        if (row != 1){
            throw new ServiceException("更新失败");
        }
        return row;
    }
}
