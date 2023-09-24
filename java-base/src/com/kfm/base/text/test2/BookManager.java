package com.kfm.base.text.test2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class BookManager {
    private String url;
    private String user;
    private String pass;
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

    public BookManager(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        init();
    }

    private Connection conn;

    private void init() {
        getConnect();

        if (!haveTables()) {
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

    private boolean haveTables() {
        getConnect();
        try {
            ps = conn.prepareStatement("show tables");
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                if (rs.getRow() >= 2){
                    return true;
                }
            }
            return false;
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

    // --------------------------------------------------------------

    private void addBookInfo1(){
        print("（输入信息顺序为书名、出版日期、作者、价格、数量）" + "\r\n" + "请输入图书信息（中间用短杠隔开）：");
        String str = inpu.next();
        getConnect();
        String sql = "insert into  books(book_title,publication_date,author,price,quantity) values(?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,str.split("-")[0]);
            ps.setObject(2,new Date(Long.valueOf(str.split("-")[1])));
            ps.setNString(3,str.split("-")[2]);
            ps.setDouble(4,Double.valueOf(str.split("-")[3]));
            ps.setInt(5,Integer.valueOf(str.split("-")[4]));
            ps.execute();
            print("插入《" + str.trim().split("-")[0] + "》成功");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addBookInfo(){
        addBookInfo1();
    }
    private void removeBook1(){
        print("请输入要删除的书的名称：");
        String str = inpu.next();
        if (havaBook(str)) {
            String sql = "delete from books where book_title = ?";
            getConnect();
            try {
                ps = conn.prepareStatement(sql);
                ps.setObject(1,str);
                ps.executeUpdate();
                print("《" + str + "》" + "删除成功");
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
    public void removeBook() {
        removeBook1();
    }

    private void modifyBookQuantity1(){
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
            String sql = "update books set quantity = ? where book_title = ?";
            try {
                ps = conn.prepareStatement(sql);
                ps.setObject(1,num);
                ps.setObject(2,str);
                ps.executeUpdate();
                print("修改《" + str + "》" + "的数量为"+ num + "本成功");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            print("查无此书");
        }
    }
    public void modifyBookQuantity(){
        modifyBookQuantity1();
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

    public void showAllBooks(){
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
