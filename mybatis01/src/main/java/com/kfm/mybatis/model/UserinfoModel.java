package com.kfm.mybatis.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UserinfoModel implements Serializable {
    private String id;

    private String username;

    private String password;

    private String name;

    private Integer gender;

    private Date birthday;

    private String phone;

    private String email;

    private String qq;

    private String img;

    private Date createDate;

    private Date updateDate;

    private Integer state;

    private Boolean del;
}
