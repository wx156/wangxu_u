package com.kfm.mybatis.dao;

import com.kfm.mybatis.model.UserinfoModel;

import java.util.List;

public interface IUserinfoDao {
    /**
     * 查询所有用户
     */
    List<UserinfoModel> findAll();
}
