package com.kfm.base.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class File1 {
    public static void main(String[] args) {
        File file = new File("d://a.java");
        System.out.println(file.isFile());
        System.out.println(file.getPath());
        System.out.println(file.isDirectory());
        //绝对路径
        System.out.println(file.isAbsolute());

        System.out.println(file.getName()); //最后一级目录

        System.out.println(file.getPath()); //file 对象所表示的路径

        System.out.println(new Date(file.lastModified()));// 最后一次修改的时间--时间戳

        System.out.println(file.length());

//        String [] list = file.list();
//        File[] files = file.listFiles();
//        for (File f : files) {
//            System.out.println(f);
//        }
        File f1 = new File("a.java");
        File f2 = new File("d://a.java");
        try {
            //规范路径表示
            System.out.println(f2.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(f2.canRead());

        File io = new File("d://a.java");
        System.out.println(io.length());
        /*
        先判断父目录是否存在，如果不存在则创建新目录
        然后判断file是否存在，不存在则创建
         */

//        if (!(io.getParentFile().exists())){
//            io.getParentFile().mkdirs();
//        }
//        if (!io.exists()){
//            try {
//                io.createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }


    }
}
