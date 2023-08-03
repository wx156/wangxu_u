package com.kfm.base.classes.cinema;

import java.util.Arrays;

public class MovieTheater {
    private Movie[] moives = new Movie[10];


    // 电影数量
    private int count = 0;
    {
        for (int i = 0; i < 10; i++) {
            String name = "第" + (i + 1) + "个电影";
            addMovie(new Movie(name,33.6,"佚名",20200314));
        }
    }
    public void addMovie(Movie movie) {
        if (count + 1 > moives.length) {
            // 扩容
            grow();
        }
        moives[count++] = movie;
    }

    private void grow() {
        Movie[] newArr = Arrays.copyOf(moives, moives.length * 2);

        moives = newArr;
    }

    public void show() {

        if (count == 0) {
            System.out.println("\u001B[31m 目前没有电影！\u001B[0m");
        } else {
            for (int i = 0; i < moives.length-1; i++) {
                for (int j = 0; j < moives.length - i -1; j++) {
                    if (moives[j].getDate()<moives[j+1].getDate()){
                        Movie temp = moives[j];
                        moives [j] = moives[j+1];
                        moives [j+1] = temp;
                    }
                }
            }
            for (int i = 0; i < moives.length; i++) {
                System.out.println(i + 1 + ". " + moives[i].info());
            }
        }
    }

    public Movie searchByName(String name) {
        for (int i = 0; i < moives.length; i++) {
            if (name.equals(moives[i].getName())) {
                return moives[i];
            }
        }
        return null;
    }
    public Movie[] deleteByName(String name){
        Movie [] arr= new Movie[moives.length];
        for (int i = 0,j = 0; i < moives.length; i++) {
            if (name.equals(moives[i].getName())) {
                continue;
            }else {
                arr[j++] = moives[i];
            }
        }
        return arr;
    }
    public Movie reviseByName(String name){
        for (int i = 0; i < moives.length; i++) {
            if (name.equals(moives[i].getName())) {
                return moives[i];
            }
        }
        return null;
    }
    private User[] users = new User[10];
    private int d = 0;
    {
        for (int i = 0; i < 10; i++) {
            String name = "第" + (i + 1) + "个用户";
            addUser(new User(name,"11111","佚名",2));
        }
    }
    public void addUser(User user) {
        if (count + 1 > moives.length) {
            // 扩容
            grow1();
        }
        users[count++] = user;
    }

    private void grow1() {
        User[] newArr = Arrays.copyOf(users, users.length * 2);

        users = newArr;
    }

    public void show1() {

        if (count == 0) {
            System.out.println("\u001B[31m 目前没有用户！\u001B[0m");
        } else {
            for (int i = 0; i < moives.length; i++) {
                System.out.println(i + 1 + ". " + users[i].info());
            }
        }
    }
    public User searchByName1(String userName) {
        for (int i = 0; i < moives.length; i++) {
            if (userName.equals(users[i].getUserName())) {
                return users[i];
            }
        }
        return null;
    }
}
