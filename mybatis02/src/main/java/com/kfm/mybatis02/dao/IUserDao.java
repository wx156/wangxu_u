package com.kfm.mybatis02.dao;

import com.kfm.mybatis02.model.UserModel;

import java.util.List;

public interface IUserDao {
    List<UserModel> selectAll();
    List<UserModel> selectByUserModel(UserModel userModel);
    UserModel insertUserModel(UserModel userModel);
}
