package com.kfm.base.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBHelperText {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "1234";
        DBHelper dbHelper = new DBHelper(url,user,password);
//        update测试
//        String sql = "update abs set id = 2";

//        String sql = "insert into abs values(3,'wangwu')";

        //selectOne 测试
//        String sql = "select * from abs where name = ?";
//        String p ="zhangsan";
//        try {
//            System.out.println(dbHelper.selectOne(sql, new IResultMapper<Abs>() {
//                @Override
//                public Abs mapper(ResultSet set) {
//                    Abs abs = new Abs();
//                    try {
//                        abs.setId(set.getInt("id"));
//                        abs.setName(set.getString("name"));
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return abs;
//                }
//            },p));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        String sql = "select * from abs";
        try {
           List list = dbHelper.selectlist(sql, new IResultMapper<Abs>() {
                @Override
                public Abs mapper(ResultSet set) {
                    Abs abs = new Abs();
                    try {
                        abs.setId(set.getInt("id"));
                        abs.setName(set.getString("name"));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    return abs;
                }
            });
           for (Object obj : list){
               System.out.println(obj);
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbHelper.close();
    }
}
class Abs {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Abs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}