package com.kfm.boot.dao;

import com.kfm.boot.entity.User;
import com.kfm.boot.util.DBHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


    public User selectByUsername(String username) throws SQLException {
        String sql = "select id, username, name from user where username = ?";
        return db.selectOne(sql, User.class, username);
    }

    /**
     * 插入用户数据，返回影响行数
     * @param user
     * @return
     * @throws SQLException
     */
    public int insert(User user) throws SQLException {
        String sql = "insert into user(username, password, name) values(?, ?, ?)";
        return db.update(sql, user.getUsername(), user.getPassword(), user.getName());
    }

    /**
     * 插入用户数据，返回自增主键
     * @param user
     * @return
     * @throws SQLException
     */
    public int insertByGeneralKey(User user) throws SQLException {
        String sql = "insert into user(username, password, name) values(?, ?, ?)";
        return db.insert(sql, user.getUsername(), user.getPassword(), user.getName());
    }

    public List<User> selectAll() throws SQLException {
        String sql = "select id, username, name from user";
        return db.selectList(sql, User.class);
    }

    public User selectById(Integer id) throws SQLException {
        String sql = "select id, username, name from user where id = ?";
        return db.selectOne(sql, User.class, id);
    }

    public int updateById(User user) throws SQLException {
        StringBuilder sql = new StringBuilder("update user set ");
        List params = new ArrayList();
        if (user.getUsername() != null){
            sql.append("username = ?, ");
            params.add(user.getUsername());
        }
        if (user.getName() != null){
            sql.append("name = ?, ");
            params.add(user.getName());
        }
        // 其他字段同理

        // 最后会多一个 , 需要去掉
        sql.deleteCharAt(sql.length() - 1);

        sql.append(" where id = ?");
        params.add(user.getId());

        return db.update(sql.toString(), params.toArray());
    }

    public int deleteById(Integer id) throws SQLException {
        String sql = "delete from user where id = ?";
        return db.update(sql, id);
    }
}
