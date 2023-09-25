package com.kfm.base.text.test2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class BookManager {
    private String url = "jdbc:mysql://localhost:3306/manger";
    private String user = "root";
    private String pass = "1234";
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private Scanner inpu = new Scanner(System.in);

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void print(String str){
        System.out.println(str);
    }

    public BookManager() {
        init();
    }



    private void init() {
        getConnect();
        String s1 = "books";
        String s2 = "operation_log";
        if (!haveTables(s1,s2)) {
            runTxt();
        }
    }

    private void runTxt() {
        try (FileInputStream fis = new FileInputStream("sql.txt");){
            byte[] bytes = fis.readAllBytes();
            for (int i = 0; i < new String(bytes).split(";").length; i++) {
                String sql = new String(bytes).split(";")[i].trim();
                getConnect();
                ps = conn.prepareStatement(sql);
                ps.execute();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private boolean haveTables(String str,String str1) {
        getConnect();
        try {
            ps = conn.prepareStatement("show tables");
            ps.execute();
            rs = ps.getResultSet();
            boolean flag1 = true;
            boolean flag2 = true;
            while (rs.next()) {
                String string = rs.getString(1);
                if (str.equals(string)){
                    flag1 = true;
                }else if (str1.equals(string)){
                    flag2 = true;
                }else {
                    flag1 = false;
                    flag2 = false;
                }
            }
            return (flag1 || flag2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取连接，没有的话创建，
     *
     * @return 返回一个connection 对象
     */
    private Connection getConnect() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }
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

    public void start (){
        print("欢迎光临开发喵书院！" + "\n" + "请输入序号选择功能：");
        print(" 1 展示所有书籍");
        print(" 2 添加书籍");
        print(" 3 修改图书数量");
        print(" 4 删除书籍");
        print(" 5 退出");

        int result = inpu.nextInt();
        switch (result){
            case 1 -> showAllBooks();
            case 2 -> addBookInfo();
            case 3 -> modifyBookQuantity();
            case 4 -> removeBook();
            case 5 -> {
                close();
                System.exit(0);
            }
            default -> {
                print("输入错误，请重新输入：");
                start();
            }
        }
        start();
    }

    // --------------------------------------------------------------

    private void addBookInfo(){
        print("（输入信息顺序为书名、出版日期、作者、价格、数量）" + "\r\n" + "请输入图书信息（中间用短杠隔开）：");
        String str = inpu.next();
        getConnect();
        String sql = "insert into  books(book_title,publication_date,author,price,quantity) values(?,?,?,?,?)";
        String sql1 = "insert into operation_log (description) values(?)";
        String result = "插入《" + str.trim().split("-")[0] + "》成功";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,str.split("-")[0]);
            ps.setObject(2,new Date(Long.valueOf(str.split("-")[1])));
            ps.setNString(3,str.split("-")[2]);
            ps.setDouble(4,Double.valueOf(str.split("-")[3]));
            ps.setInt(5,Integer.valueOf(str.split("-")[4]));
            ps.executeUpdate();
            print(result);
            ps = conn.prepareStatement(sql1);
            ps.setString(1,result);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void removeBook(){
        print("请输入要删除的书的名称：");
        String str = inpu.next();
        String result = "《" + str + "》" + "删除成功";
        if (havaBook(str)) {
            String sql = "delete from books where book_title = ?";
            String sql1 = "insert into operation_log (description) values(?)";
            getConnect();
            try {
                ps = conn.prepareStatement(sql);
                ps.setObject(1,str);
                ps.executeUpdate();
                print(result);
                ps = conn.prepareStatement(sql1);
                ps.setString(1,result);
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            print("查无此书");
        }

    }
    private boolean havaBook(String str) {
        getConnect();
        String sql = "select * from books where book_title = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,str);
            rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    private void modifyBookQuantity(){
        print("请输入要更改的书的名称：");
        String str = inpu.next();
        print("请输入要修改的数量");
        int num = inpu.nextInt();
        if (havaBook(str)) {
            int count = bookCount(str);
            while (num <= count){
                print("输入的数量要比原图书数量多");
                print("请重新输入：");
                num = inpu.nextInt();
            }
            getConnect();
            String result = "修改《" + str + "》" + "的数量为"+ num + "本成功";
            String sql = "update books set quantity = ? where book_title = ?";
            String sql1 = "insert into operation_log (description) values(?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setObject(1,num);
                ps.setObject(2,str);
                ps.executeUpdate();
                print(result);
                ps = conn.prepareStatement(sql1);
                ps.setString(1,result);
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            print("查无此书");
        }
    }

    private int bookCount(String str) {
        getConnect();
        String sql = "select quantity from books where book_title = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,str);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
    //----------------------------------------------------------------------

    private void showAllBooks(){
        getConnect();
        String sql = "select * from books";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                print(rs.getInt("id") + "\t" +
                        rs.getString("book_title") +"\t" +
                        rs.getDate("publication_date") +"\t" +
                        rs.getString("author") +"\t" +
                        rs.getDouble("price") +"\t" +
                        rs.getInt("quantity") + "\t");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
