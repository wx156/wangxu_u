package com.kfm.base.classes.cinema1;

public class Movie {
    private String name;
    private String director;
    private int date;
    private double price;

    public Movie() {
    }

    public Movie(String name, String director, int date, double price) {
        this.name = name;
        this.director = director;
        this.date = date;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String info() {
        return name + "\t" +director + "\t" + date + "\t" + price;
    }

    @Override
    public String toString() {
        return "电影名'" + name + '\'' +
                ", 导演'" + director + '\'' +
                ", 上映时间" + date +
                ", 价格" + price;
    }
}
