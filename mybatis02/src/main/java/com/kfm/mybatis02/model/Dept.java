package com.kfm.mybatis02.model;


import lombok.Data;

import java.io.Serializable;

/**
 * @TableName dept
 */
@Data
public class Dept implements Serializable {
    private Integer id;

    private String name;

    private String desc;

    private static final long serialVersionUID = 1L;
}