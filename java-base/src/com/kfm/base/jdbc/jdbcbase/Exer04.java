package com.kfm.base.jdbc.jdbcbase;

import java.sql.*;

public class Exer04 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String pass = "1234";
        try {
            Connection conn = DriverManager.getConnection(url,user,pass);
            String sql = "call proc_inout(?)";
            CallableStatement pc = conn.prepareCall(sql);
            pc.setObject(1,101);

            pc.execute();
            System.out.println(pc.getInt(1));
//            ResultSet rs = pc.getResultSet();
//            if ((rs = pc.getResultSet()).next()) {
//                System.out.println(rs.getString(1));
//            }
//            System.out.println(pc.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
