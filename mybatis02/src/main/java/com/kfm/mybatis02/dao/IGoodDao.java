package com.kfm.mybatis02.dao;

import com.kfm.mybatis02.model.GoodsModel;

import java.util.List;

public interface IGoodDao {
    List<GoodsModel> listUpGoods(GoodsModel goodsModel);
    List<GoodsModel> listDownGoods(GoodsModel goodsModel);

    Integer deleteById(int id);

    int putAwayById(int id);

    int downById(int id);
    GoodsModel selectByPrimaryKey (Integer id);
    Integer updateByPrimaryKeySelective(GoodsModel goodsModel);
    Integer insertGoodmodel(GoodsModel goodsModel);
}
