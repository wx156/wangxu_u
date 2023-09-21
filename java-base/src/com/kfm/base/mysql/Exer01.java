package com.kfm.base.mysql;


import java.sql.*;

public class Exer01 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/company";
            String user = "root";
            String password = "1234";

            try(Connection connection = DriverManager.getConnection(url,user,password);
                Statement statement = connection.createStatement()) {
                String sql = "select * from dept";

                boolean execute = statement.execute(sql);
                if (execute){
                    System.out.println("查询成功");
                    ResultSet resultSet = statement.getResultSet();
                    while (resultSet.next()){
                        int anInt = resultSet.getInt(1);
                        Object obj1 = resultSet.getObject(2);
                        Object obj2 = resultSet.getObject(3);


                        System.out.println(obj1 + " - " + obj2 + " - " + anInt);
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
