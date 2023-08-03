package com.kfm.base.classes.exer;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private int balance;
    public BankAccount(String accountNumber,String accountHolder,int balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }
    public int getBalance(){
        return balance;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    //存款方法
    public void addBalance(int balance){
        this.balance += balance;
    }
    //取款方法
    public void drawBalance(int balance){
        this.balance -= balance;
    }
}
