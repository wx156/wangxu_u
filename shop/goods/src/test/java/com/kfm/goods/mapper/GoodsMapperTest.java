package com.kfm.goods.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kfm.goods.domain.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GoodsMapperTest {
    @Autowired
    private GoodsMapper goodsMapper;
    @Test
    void test() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",1);
        goodsMapper.selectList(queryWrapper);

    }
    @Test
    void selectById() {
        goodsMapper.selectById(1);
    }
    @Test
    void updateById() {
        Goods good = new Goods();
        good.setId(1);
        goodsMapper.updateById(good);
    }


    @Test
    void insert() {
        Goods good = new Goods();
        good.setName("测试商品");
        good.setPrice(100L);
        good.setNum(20);

        goodsMapper.insert(good);
    }
    @Test
    void deleteById() {
        goodsMapper.deleteById(1);
    }
}