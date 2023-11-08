package com.kfm.mybatis02.dao;

import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.kfm.mybatis02.model.UserModel;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有用户信息
     */
    List<UserModel> selectAll(UserModel userModel);

    /**
     * 根据用户模型查询用户信息
     *
     * @param userModel 用户模型对象
     */
    List<UserModel> selectByUserModel(UserModel userModel);

    /**
     * 插入用户模型信息
     *
     * @param userModel 用户模型对象
     * @return 插入的用户数量
     */
    Integer insertUserModel(UserModel userModel);

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户模型对象
     */
    UserModel selectUserByUsername(String username);

    /**
     * 根据用户id查询用户信息
     *
     * @param id 用户id
     * @return 用户模型对象
     */
    UserModel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserModel record);


    void deleteByPrimaryKey(String id);
}
