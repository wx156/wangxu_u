package com.kfm.base.file;

import java.io.File;
import java.io.IOException;

public class Exer01 {
    /**
     * 在当前模块下的 text 文件夹中创建一个 io.txt 文件
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("text/io.txt");
        if (!(file.getParentFile().exists())){
            file.getParentFile().mkdirs();
        }
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
