package com.kfm.base.jdbc;

import java.sql.*;

public class Exer02 {
    public static void main(String[] args) {

        try (Connection connection =  getConnection();
             Statement statement = connection.createStatement();){

            String sql = "create table test(id int,name varchar(14))";
            boolean execute = statement.execute(sql);
            if (execute){
                ResultSet resultSet = statement.getResultSet();
                System.out.println(resultSet);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "1234";
        try {
            // 这个连接不能放在try-with-resources 中，连接会关闭。
            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

