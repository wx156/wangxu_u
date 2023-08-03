package com.kfm.base.classes.cinema;

public class User {
    private String userName;
    private String phone;
    private String password;
    private int role;
    public User(String username,String phone,String password,int role){
        this.userName = username;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String username){
        this.userName = username;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getRole(){
        if (role != 1 && role != 2){
            System.out.println("请输入正确的身份");
        }
        return role;
    }
    public void setRole(int role){
        this.role = role;
    }
    public String info(){
        return userName + " ," + phone + " ," + password + " ," + role;
    }

    @Override
    public String toString(){
        return info();
    }
}
