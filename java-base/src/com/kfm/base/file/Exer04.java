package com.kfm.base.file;

import java.io.File;
import java.io.FileNotFoundException;

public class Exer04 {
    /**
    *
    * 计算出磁盘上指定文件夹的实际大小
    */
    public static void main(String[] args) {


        File file = new File("D:\\week\\kechengwenjian");

        System.out.println(count(file) / 1024 / 1024 + "MB");

    }

    private static long count(File file) {
        if (file == null || !file.exists()) {
            try {
                throw new FileNotFoundException("找不到文件");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        long size = 0;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                size += count(f);
            }
        }
        else{
            size += file.length();
        }
        return size;
    }
}
