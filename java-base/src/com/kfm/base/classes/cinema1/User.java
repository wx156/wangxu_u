package com.kfm.base.classes.cinema1;

public class User {
    private String phone;
    private String username;
    private String password;
    private Boolean admin;

    public User() {
    }

    public User(String phone,String username,String password){
        this(phone,username,password,false);
    }

    public User(String phone, String username, String password, Boolean admin) {
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String info() {
        String role = admin ? "管理员":"用户";
        return role + "\t" + phone + "\t" +
                username + "\t" + "******";
    }

    @Override
    public String toString() {
        return "手机号 '" + phone + '\'' +
                ", " +
                "用户名'" + username + '\'' +
                ", 密码 ****** ";
    }
}
