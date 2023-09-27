package com.kfm.base.jdbc.jdbcbase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {
    private String url;
    private String user;
    private String pass;
    private Connection conn;

    private boolean autoCommit = true;
    private PreparedStatement ps;

    private ResultSet rs;

    /*
        每次初始化类时都确保driver 加载
     */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public DBHelper(){

    }
    public DBHelper(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    /**
     * 获取连接，没有的话创建，
     * @return 返回一个connection 对象
     */
    private Connection getConnect() throws SQLException {
        if (conn == null && conn.isClosed()){
            try {
                conn = DriverManager.getConnection(url ,user,pass);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    public void startTransaction(){
        try {
            getConnect();
            if (conn != null && !conn.isClosed() && autoCommit){
                conn.setAutoCommit(false);
                autoCommit = false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void commit(){
        try {
            getConnect();
            if (conn != null && !conn.isClosed() && !autoCommit){
                conn.commit();
                autoCommit = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void rollback(){
        try {
            getConnect();
            if (conn != null && !conn.isClosed() && !autoCommit){
                conn.rollback();
                autoCommit = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 数据库操作 包括增删改
     * @param sql 要执行的sql 语句
     * @param params 要替换sql 中占位符位置的语句
     * @return int 值，表示影响行数
     * @throws SQLException
     */
    public int update (String sql,Object...params) throws SQLException {
        // 获取连接
        getConnect();
        // 将sql 语句传入prepareStatement 进行预编译
        ps = conn.prepareStatement(sql);
        // 将传入的值设置入sql 语句
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i +1,params[i]);
            }
        }
        // 执行 executeUpdate
        return ps.executeUpdate();
    }

    /**
     * 插入数据，如果有自增长键，则返回，没有则返回-1
     * @param sql 要执行的sql 语句
     * @param params 占位符要替换的值
     * @return int 值 大于0表示返回主键，返回-1表示没有自增长主键
     * @throws SQLException
     */
    public int insert (String sql,Object...params) throws SQLException {
        // 获取连接
        getConnect();
        // 传入sql 语句并且传入RETURN_GENERATED_KEYS 表示需要返回自增长键
        ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        // 将占位符换为传入的值
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i +1,params[i]);
            }
        }
        // 执行操作
        ps.executeUpdate();
        //取自增长值
        rs = ps.getGeneratedKeys();
        // 取到自增长值并返回，若没有则返回-1
        if (rs.next()){
            int a = rs.getInt(1);
            return a;
        }
        return -1;
    }

    /**
     * 查找 一个符合条件的 数据，并返回一个对象
     * @param sql 要执行的sql 语句
     * @param resultMapper 将集合转换为对象的方法
     * @param params 要替换sql 语句中占位符的语句
     * @return 返回一个对象
     * @param <T>
     * @throws SQLException
     */

    public <T> T selectOne (String sql,IResultMapper<T> resultMapper,Object...params) throws SQLException {
        // 获取连接
        getConnect();
        // 将sql 语句传入prepareStatement 进行预编译
        ps = conn.prepareStatement(sql);
        // 将传入的值设置入sql 语句
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i +1,params[i]);
            }
        }
        // 执行操作
        rs = ps.executeQuery();
        if (rs.next()){
            // 用mapper 将结果返回为一个对象
            return resultMapper.mapper(rs);
        }
        return null;
    }

    /**
     * 查询多个符合条件的数据，并将其转换为对象放到集合中
     * @param sql
     * @param resultMapper
     * @param params
     * @return
     * @param <T>
     * @throws SQLException
     */
    public <T> List<T> selectlist (String sql, IResultMapper<T> resultMapper, Object...params) throws SQLException {
        // 获取连接
        getConnect();
        // 将sql 语句传入prepareStatement 进行预编译
        ps = conn.prepareStatement(sql);
        // 将传入的值设置入sql 语句
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i +1,params[i]);
            }
        }
        // 新建一个集合，用于储存多个对象
        List <T> list = new ArrayList<>();
        // 执行操作
        rs = ps.executeQuery();
        while (rs.next()){
            // 用mapper 将结果返回为一个对象
            T t = resultMapper.mapper(rs);
            // 将返回的对象添加到集合中
            list.add(t);
        }
        return list;
    }

    /**
     * 释放资源
     */
    public void close(){
        // 关闭结果集并置为null
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        rs = null;
        // 关闭PreparedStatement 并置为null
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        ps = null;
        // 关闭连接并置为null
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        conn = null;
    }
}

/**
 * 将传入的集合中的数据转换为一个对象
 * @param <T>
 */
interface IResultMapper<T>{
    T mapper (ResultSet set);
}