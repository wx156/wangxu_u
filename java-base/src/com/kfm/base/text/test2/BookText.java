package com.kfm.base.text.test2;

public class BookText {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/manger";
        String user = "root";
        String pass = "1234";
        BookManager bookManager = new BookManager(url,user,pass);
//        bookManager.addBookInfo();
//        bookManager.removeBook();
//        bookManager.modifyBookQuantity();
        bookManager.showAllBooks();
        bookManager.close();
    }
}
