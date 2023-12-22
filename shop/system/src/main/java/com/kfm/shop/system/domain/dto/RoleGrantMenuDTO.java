package com.kfm.shop.system.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleGrantMenuDTO implements Serializable {

    private Integer roleId;

    private Integer[] menuIds;
}
