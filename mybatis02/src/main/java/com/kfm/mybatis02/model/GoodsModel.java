package com.kfm.mybatis02.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GoodsModel implements Serializable {
    /**
     * 商品ID
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String goodName;
    /**
     * 成本价
     */
    private Integer cost;
    /**
     * 销售价
     */
    private Integer price;
    /**
     * 数量
     */
    private Integer nums;
    /**
     * 库存
     */
    private Integer state;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新时间
     */
    private Date updateDate;
}

