package com.kfm.web.dao;

import com.kfm.web.entity.User;
import com.kfm.web.util.DBHelper;

import java.sql.SQLException;

/**
 * UserDao 用于处理用户表(user)数据
 */
public class UserDao {
    private DBHelper db = new DBHelper();

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 查询到的用户. 如果没有查询到, 返回 null
     * @throws SQLException
     */
    public User selectByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "select id, username, name from user where username = ? and password = ?";
        return db.selectOne(sql, User.class, username, password);
    }
}
