package com.kfm.shop.goods.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.kfm.shop.common.model.BaseModel;
import lombok.Data;
import lombok.ToString;

/**
 * 
 * @TableName goods
 */
@TableName(value ="goods")
@Data
@ToString(callSuper = true)
public class Goods extends BaseModel implements Serializable {
    /**
     * 商品id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格,单位:分
     */
    private Long price;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 商品状态 1:在售 2:下架
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}