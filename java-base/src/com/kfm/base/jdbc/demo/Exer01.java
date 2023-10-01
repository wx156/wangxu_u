package com.kfm.base.jdbc.demo;

import java.io.IOException;
import java.io.InputStream;

public class Exer01 {
    public static void main(String[] args) {
//        File file = new File("server.txt");
        InputStream resourceAsStream = Exer01.class.getClassLoader().getResourceAsStream("server.txt");
        try {

            System.out.println(resourceAsStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
