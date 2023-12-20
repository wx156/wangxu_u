package com.kfm.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.goods.domain.Goods;
import com.kfm.goods.service.GoodsService;
import com.kfm.goods.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

/**
* @author wangxu
* @description 针对表【goods】的数据库操作Service实现
* @createDate 2023-12-18 20:19:35
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{

}




