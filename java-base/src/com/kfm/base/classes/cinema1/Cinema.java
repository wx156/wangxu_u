package com.kfm.base.classes.cinema1;

import java.util.Scanner;

public class Cinema {
    private String name = "【开发喵影院】";
    //用户数组
    private User[] userList = new User[10];
    private int userCount = 0;
    //电影数组
    private Movie[] movieList = new Movie[10];
    private int movieCount = 0;

    private User loginUser;
    //初始化用户和电影
    {
        Movie movie = new Movie("前任4","田羽生" , 20230928, 39.9);
        movieList[movieCount ++] = movie;
        movie = new Movie("金刚大战哥斯拉","xxx" , 20180911, 29.9);
        movieList[movieCount ++] = movie;
        movie = new Movie("金刚川", "xxxx", 20200621, 49.9);
        movieList[movieCount ++] = movie;
        movie = new Movie("水门桥","xxxx" , 20221001, 59.9);
        movieList[movieCount ++] = movie;

        // 普通用户
        User user = new User("111", "张三", "123");
        userList[userCount ++] = user;

        // 管理员
        User admin = new User("222", "管理员", "123", true);
        userList[userCount ++] = admin;

    }
    public Cinema(){
    }
    public Cinema(String name){
        this.name = name;
    }
    private Scanner input = new Scanner(System.in);
    //入口
    public void open(){
        print("欢迎光临"+ name);
        selectMainMenu();
    }
    //开始菜单
    private void selectMainMenu() {
        print("请选择要执行的操作：");
        print("1. 上映电影列表");
        print("2. 查询电影列表");
        print("3. 登录");
        print("4. 注册");
        print("5. 显示所有用户");
        print("0. 退出");
        print("请输入序号：");

        int select = input.nextInt();
        switch (select){
            case 1 -> showMaives();
            case 2 -> queryMoive();
            case 3 -> login();
            case 4 -> register();
            case 5 -> showAllUsers();
            case 0 -> exit();
        }
        //操作完再次显示菜单
        selectMainMenu();
    }
    //显示所有用户
    private void showAllUsers() {
        if (userCount == 0){
            print("暂无用户");
        }else{
            print("用户列表");
            print("序号 \t 角色   \t    手机号    \t   用户名   \t 密码   ");

            for (int i = 0; i < userCount; i++) {
                print(" "+(i+1) + " "+ "\t" + userList[i].info());
            }
        }

    }
    //注册
    private void register() {
        print("请输入手机号");
        String phone = input.next();
        int index = queryUserByPhone(phone);
        if (index == -1){
            print("手机号已注册");
            return;
        }
        String password = null;
        String rePass = null;
        do {
            if (password != null){
                print("两次密码不一致");
            }
            print("请输入密码");
            password = input.next();
            print("请再次输入密码");
            rePass = input.next();
        }while (!password.equals(rePass));
        print("请输入用户名");
        String username = input.next();
        User user = new User(phone,username,password);
        addUser(user);
        print("注册成功！");
        showAllUsers();
    }

    private int queryUserByPhone(String phone) {
        for (int i = 0; i < userCount; i++) {
            if (phone.equals(userList[i].getPhone())){
                return i;
            }
        }
        return -1;
    }

    private void addUser(User user) {
        userList[userCount++] = user;
    }

    //登录
    private void login() {
        print("请输入手机号：");
        String phone = input.next();
        print("请输入密码：");
        String password = input.next();

        int index = queryUserByPhoneAndPass(phone, password);
        if (index == -1){
            print("用户名或密码错误，请重试！");
        }else {
            print("登录成功");
            loginUser = userList[index];
            if (loginUser.getAdmin()){
                showAdminMenu();//管理员
            }else {
                showUserMenu();//普通用户
            }
        }
    }
    //普通用户列表
    private void showUserMenu() {
        print("请输入序号");
        print("1. 个人信息");
        print("2. 修改个人信息");
        print("0. 注销");
        int select = input.nextInt();
        switch (select){
            case 1 -> personal();
            case 2 -> updateInfo();
            case 0 -> logout();
        }
        showUserMenu();
    }

    private void logout() {
        loginUser = null;
        print("注销成功！");
        selectMainMenu();
    }

    private void updateInfo() {
        print("请输入新的用户名：");
        String username = input.next();
        loginUser.setUsername(username);
        print("修改成功！");
    }

    private void personal() {
        print(loginUser);
    }

    private void showAdminMenu() {
        print("请输入序号：");
        print("1. 添加电影");
        print("2. 删除电影");
        print("3. 修改电影信息");
        print("4. 显示用户信息");
        print("0. 注销");
        int select = input.nextInt();
        switch (select){
            case 1 -> addMovie();
            case 2 -> removeMovie();
            case 3 -> modifyMovie();
            case 4 -> showAllUsers();
            case 0 -> logout();
        }
    }

    private void addMovie() {
        print("输入电影名称：");
        String name = input.next();
        print("输入导演姓名：");
        String director = input.next();
        print("请输入上映时间(格式: 20230101)：");
        int date = input.nextInt();
        print("请输入票价：");
        double price = input.nextDouble();

        Movie movie = new Movie(name, director, date, price);

        addMovie(movie);

        print("添加成功");
    }
    private void addMovie(Movie movie){
        movieList[movieCount++] = movie;
    }

    private void modifyMovie() {
        showMoives();
        print("请输入要修改的电影序号");
        int n = input.nextInt();
        modifyMovie(n-1);
    }
    private void modifyMovie(int index){

    }

    private void removeMovie() {
        showMoives();
        print("请输入要删除的电影序号: ");
        int num = input.nextInt();

        removeMovie(num - 1);

        print("删除成功");
    }

    private void showMoives() {
        if (movieCount == 0){
            print("暂无电影");
        } else {
            print("上映电影列表");
            // 排序
            sortMovieByDate();

            print("序号 \t 电影名 \t 导演 \t 上映时间 \t 价格");
            for (int i = 0; i < movieCount; i++) {
                print(" " + (i + 1) + " " + " \t " + movieList[i].info());
            }
        }
    }

    private void sortMovieByDate() {
        // 排序
        for (int i = 0; i < movieCount - 1; i++) {
            for (int j = 0; j < movieCount - i - 1; j++) {
                if (movieList[j].getDate() < movieList[j + 1].getDate()){
                    Movie temp = movieList[j];
                    movieList[j] = movieList[j + 1];
                    movieList[j + 1] = temp;
                }
            }
        }
    }

    private void removeMovie(int index) {
        System.arraycopy(movieList,index + 1,movieList,index,movieList.length - index - 1);
        movieList[--movieCount] = null;
    }

    //通过用户名和电话号来确定用户信息
    private int queryUserByPhoneAndPass(String phone, String password) {
        for (int i = 0; i < userCount; i++) {
            User user = userList[i];
            if (phone.equals(user.getPhone()) && password.equals(user.getPassword())){
                return i;
            }
        }
        return -1;
    }
    //通过电影名称查找电影信息
    private void queryMoive() {
        print("请输入电影名称");
        String name = input.next();
        int index = searchMovie(name);

        if (index == -1){
            print("查无此电影");
        }else {
            print(movieList[index]);
        }
    }
    //通过电影名称查找电影信息的方法
    private int searchMovie(String name){
        for (int i = 0; i < movieCount; i++) {
            Movie movie = movieList[i];
            if (name.equals(movie.getName())){
                return i;
            }
        }
        return -1;
    }
    //显示所有电影信息
    private void showMaives() {
        if (userCount == 0){
            print("暂无用户");
        } else {
            print("用户列表");

            print("序号 \t 角色   \t    手机号    \t  密码    \t 用户名   ");
            for (int i = 0; i < userCount; i++) {
                print(" " + (i + 1) + " " + " \t " + userList[i].info());
            }
        }
    }


    //输出方法
    private void print (Object msg){
        System.out.println(msg);
    }
    //退出方法
    private void exit(){
        System.out.println("欢迎下次光临!");
        System.exit(0);
    }
    public String toString(){
        return name + "现有电影 " + movieCount + " 部， 用户 " + userCount + " 人";
    }
}
