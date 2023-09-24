package com.kfm.base.text.test2;

import java.util.Date;

public class Book {
    private String book_title;
    private Date publication_date;
    private String author;
    private Double price;
    private int quantify;

    public Book() {
    }

    public Book(String book_title, Date publication_date, String author, Double price, int quantify) {
        this.book_title = book_title;
        this.publication_date = publication_date;
        this.author = author;
        this.price = price;
        this.quantify = quantify;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantify() {
        return quantify;
    }

    public void setQuantify(int quantify) {
        this.quantify = quantify;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_title='" + book_title + '\'' +
                ", publication_date=" + publication_date +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", quantify=" + quantify +
                '}';
    }
}
