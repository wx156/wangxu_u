package com.kfm.mybatis02.dao;

import com.kfm.mybatis02.model.GoodsModel;

import java.util.List;

public interface IGoodDao {
    List<GoodsModel> listUpGoods();
    List<GoodsModel> listDownGoods();
}
