package com.kfm.shop.system.domain;

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
 * @TableName sys_role
 */
@TableName(value ="sys_role")
@Data
@ToString(callSuper = true)
public class Role extends BaseModel implements Serializable {
    /**
     * 角色id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String roleCode;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}