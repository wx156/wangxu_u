package com.kfm.mybatis02.service;

import com.kfm.mybatis02.exception.ServiceException;
import com.kfm.mybatis02.model.GoodsModel;

import java.util.List;

public interface IGoodService {
    List<GoodsModel> listUpGoods(int page, int pageSize,GoodsModel goodsModel);
    List<GoodsModel> listDownGoods(int page, int pageSize,GoodsModel goodsModel);
    Integer deleteById(int id) throws ServiceException;
    Integer putAwayById(int id) throws ServiceException;
    Integer downById(int id) throws ServiceException;
    GoodsModel findById(Integer id) throws ServiceException;
    Integer update(GoodsModel goodsModel) throws ServiceException;
}
