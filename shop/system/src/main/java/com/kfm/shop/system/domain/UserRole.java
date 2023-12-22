package com.kfm.shop.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName sys_user_role
 */
@TableName(value ="sys_user_role")
@Data
@ToString(callSuper = true)
@Accessors(chain = true)
public class UserRole implements Serializable {
    /**
     * 用户id
     */
    @TableId
    private Integer userId;

    /**
     * 角色id
     */
    @TableField
    private Integer roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}