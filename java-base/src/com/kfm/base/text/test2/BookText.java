package com.kfm.base.text.test2;

public class BookText {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
//        bookManager.showAllBooks();
//        bookManager.addBookInfo();
//        bookManager.removeBook();
//        bookManager.modifyBookQuantity();
        bookManager.start();
        bookManager.close();
    }
}
