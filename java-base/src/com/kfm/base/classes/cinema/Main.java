package com.kfm.base.classes.cinema;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    static MovieTheater movieTheater = new MovieTheater();


    public static void start() {
        print("欢迎使用 开发喵影院系统 ");
        showMenu();
    }
    //功能菜单
    private static void showMenu() {
        print("请选择功能:");
        print("1. 查询电影信息");
        print("2. 显示所有电影信息");
        print("3. 管理员登录");
        print("4. 用户登录");
        print("5. 用户注册");
        print("6. 退出");
        System.out.print("请输入：");
        int menu = input.nextInt();
        selectMenu(menu);
    }
    //管理员菜单
    private static void showMenu1() {
        print("请选择功能:");
        print("1. 新增电影");
        print("2. 删除电影");
        print("3. 修改电影");
        print("4. 查看使用用户信息");
        print("5. 退出");
        System.out.print("请输入：");
        int menu = input.nextInt();
        administretorMenu(menu);
    }
    //普通用户菜单
    private static void showMenu2() {
        print("请选择功能:");
        print("1. 修改用户信息");
        print("2. 查询用户信息");
        print("3. 退出");
        System.out.print("请输入：");
        int menu = input.nextInt();
        userMenu(menu);
    }
    //功能设置
    private static void selectMenu(int menu) {
        switch (menu) {
            case 1 -> searchMovie();
            case 2 -> showAllMovie();
            case 3 -> showMenu1();
            case 4 -> showMenu2();
            case 5 -> userRegister();
            case 6 -> exit();
        }

        // 再次展示菜单
        showMenu();
    }
    //管理员设置
    private static void administretorMenu(int menu) {
        switch (menu) {
            case 1 -> addMovie();
            case 2 -> deleteMovie();
            case 3 -> reviseMovie();
            case 4 -> checkAllUsers();
            case 5 -> exit();
        }

        // 再次展示菜单
        showMenu1();
    }
    //普通用户设置
    private static void userMenu(int menu) {
        switch (menu) {
            case 1 -> reviseUserInfo();
            case 2 -> searchUserInfo();
            case 3 -> exit();
        }

        // 再次展示菜单
        showMenu2();
    }

    private static void exit() {
        print("欢迎下次光临");
        System.exit(0);
    }

    private static void showAllMovie() {
        movieTheater.show();
    }
    //查找电影
    private static void searchMovie() {
        print("请输入电影的【名称】:");
        String name = input.next();

        Movie movie = movieTheater.searchByName(name);
        if (movie == null){
            System.out.println("\u001B[31m 没有找到此电影，请联系管理员！\u001B[0m");
        } else {
            print(movieTheater.toString());
        }
    }
    //修改电影
    private static void reviseMovie(){
        print("请输入电影的【名称】:");
        String name = input.next();

        Movie movie = movieTheater.reviseByName(name);
        if (movie == null){
            System.out.println("\u001B[31m 没有找到此电影，请联系管理员！\u001B[0m");
        } else {
            print(movieTheater.toString());
        }
    }
    //删除电影
    private static void deleteMovie(){
        String name = input.next();

        Movie []movie = movieTheater.deleteByName(name);
        if (movie == null){
            System.out.println("\u001B[31m 没有找到此电影，请联系管理员！\u001B[0m");
        } else {
            print(movieTheater.toString());
        }
    }
    //添加电影
    private static void addMovie() {
        print("请输入电影的【名称】:");
        String name = input.next();
        print("请输入电影的【价格r】:");
        double price = input.nextDouble();
        print("请输入电影的【导演】:");
        String director = input.next();
        print("请输入书的【上映时间】:");
        int date = input.nextInt();

        // 对象创建好了
        Movie movie = new Movie(name, price, director, date);

        // 添加到  中的数组
        movieTheater.addMovie(movie);

        print("添加 《" + name + "》 成功!");

    }
    //用户注册
    private static void userRegister(){
        print("请输入用户名：");
        String userName = input.next();
        print("请输入手机号：");
        String phone = input.next();
        print("请输入用户密码：");
        String password = input.next();
        print("请输入用户身份（1表示管理员，2表示普通用户）：");
        int role = input.nextInt();
        User user = new User(userName,phone,password,role);

    }
    //查看所有用户信息
    private static void checkAllUsers(){
        movieTheater.show1();
    }

    //修改用户信息
    private static void reviseUserInfo(){
        movieTheater.show1();
    }
    //查找用户
    private static void searchUserInfo(){
        print("请输入用户的【名称】:");
        String name = input.next();

        User user = movieTheater.searchByName1(name);
        if (user == null){
            System.out.println("\u001B[31m 没有找到此用户\u001B[0m");
        } else {
            print(movieTheater.toString());
        }
    }
    private static void print(String msg) {
        System.out.println(msg);
    }
}
