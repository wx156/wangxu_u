package com.kfm.mybatis02.service;

import com.kfm.mybatis02.model.GoodsModel;

import java.util.List;

public interface IGoodService {
    List<GoodsModel> listUpGoods(int page, int pageSize);
    List<GoodsModel> listDownGoods(int page, int pageSize);
}
