package com.kfm.base.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exer03 {
    public static void main(String[] args) {
        MyConnection my = new MyConnection();
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "1234";

        Connection connection = my.getConnection(url,user,password);
        String sql = "select * from emp";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            boolean execute = pst.execute();

            if (execute){
                System.out.println("查询成功");
                ResultSet resultSet = pst.getResultSet();
                while (resultSet.next()){
                    Object object = resultSet.getObject(1);
                    System.out.println(object);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
