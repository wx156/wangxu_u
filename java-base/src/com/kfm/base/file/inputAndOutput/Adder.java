package com.kfm.base.file.inputAndOutput;

import java.io.*;
import java.util.Arrays;

public class Adder {
    public static void main(String[] args) {
        File file = new File("D:\\video");
        File file1 = new File("D://video-1.mp4");
        System.out.println(adder(file, file1));

    }

    /**
     * 将拆分后的文件流合并
     *
     * @param file   文件所在文件夹
     * @param result 合并后的文件
     * @return true 表示合并成功， false 标识合并失败
     */
    public static long adder(File file, File result) {
        long size = 0;
        if (file == null || file.exists() || !file.isDirectory()) {
            File[] files = file.listFiles(e -> e.getName().endsWith(".kfm"));

            if (files != null) {
                Arrays.sort(files ,(f1, f2) ->{
                    if ((f1.getName().length() - f2.getName().length()) == 0) {
                        return f1.compareTo(f2);
                    }else {
                        return (f1.getName().length() - f2.getName().length());
                    }
                });
            }
            try {
                FileOutputStream fos = new FileOutputStream(result);
                for (File f : files) {
                    if (f.length() < Integer.MAX_VALUE - 8) {
                        FileInputStream fis = new FileInputStream(f);
                        fos.write(fis.readAllBytes());
                        size += f.length();
                        fis.close();
                    }
                }
                fos.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return size;
    }
}
