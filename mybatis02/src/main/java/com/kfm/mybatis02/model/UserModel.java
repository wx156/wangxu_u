package com.kfm.mybatis02.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UserModel implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String avatar;
    private int state;
    private Date createTime;
    private Date updateTime;
}
