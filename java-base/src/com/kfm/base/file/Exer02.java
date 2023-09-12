package com.kfm.base.file;

import java.io.File;
import java.io.FileNotFoundException;

public class Exer02 {
    /**
     *
     * 删除一个多级文件夹
     * @param args
     */
    public static void main(String[] args) {
        File a1 = new File("a/b/c");
        System.out.println(deletefl(a1));
    }

    private static boolean deletefl(File file) {
        if (file == null || !file.exists()){
            try {
                throw new FileNotFoundException("找不到文件");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files){
                deletefl(f);
            }
        }
        return file.delete();
    }
}
