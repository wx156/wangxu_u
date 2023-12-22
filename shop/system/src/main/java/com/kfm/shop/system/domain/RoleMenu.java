package com.kfm.shop.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @TableName sys_role_menu
 */
@TableName(value ="sys_role_menu")
@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenu implements Serializable {
    /**
     * 角色id
     */
    @TableId
    private Integer roleId;

    /**
     * 菜单id
     */
    @TableField
    private Integer menuId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}