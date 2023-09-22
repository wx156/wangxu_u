package com.kfm.base.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public Connection getConnection(String url,String user,String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            // 这个连接不能放在try-with-resources 中，连接会关闭。
            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
