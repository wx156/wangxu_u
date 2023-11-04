package com.kfm.mybatis02.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GoodsModel implements Serializable {
    private Integer id;
    private String goodsName;
    private Integer cost;
    private Integer price;
    private Integer nums;
    private Integer stock;
    private Date createTime;
    private Date updateTime;
}
