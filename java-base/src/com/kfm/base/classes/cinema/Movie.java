package com.kfm.base.classes.cinema;

public class Movie {
    private String name;
    private double price;
    private String director;
    private int date;
    public Movie(String name,double price,String director,int date){
        this.name = name;
        this.price = price;
        this.director = director;
        this.date = date;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getDirector(){
        return director;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public int getDate(){
        return date;
    }
    public void setDate(int date){
        this.date = date;
    }
    public String info(){
        return date + "出版的 " + director + " 的" + name + ", 售价" + price;
    }

    @Override
    public String toString(){
        return info();
    }
}
