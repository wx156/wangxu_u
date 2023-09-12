package com.kfm.base.file;

import java.io.File;
import java.io.FileNotFoundException;


public class Exer05 {
    /**
     *
        计算指定目录下所有文件大小
     */
    public static void main(String[] args) {

        File file = new File("D:\\javaexercise");
        if (file == null || !file.exists()){
            try {
                throw new FileNotFoundException("文件不存在");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        File [] files = file.listFiles(e -> e.isFile());
        long size = 0;
        for (File f : files) {
            size += f.length();
        }
        System.out.println(size/1024);
    }
}
