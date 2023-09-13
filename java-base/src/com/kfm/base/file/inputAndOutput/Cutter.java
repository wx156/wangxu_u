package com.kfm.base.file.inputAndOutput;

import java.io.*;

public class Cutter {
    public static void main(String[] args) {
        File file = new File("D://video.mp4");
        long size = 1024 * 700;
        File file1 = new File("D://video");

        cutter(file,size,file1);
    }

    /**
     * 将一个文件流拆分成每个小文件
     * @param file 要拆分的文件流
     * @param size 每个小文件的大小
     * @param file1 拆分后存储小文件流的路径
     * @return 返回的值表示拆分成了几份
     */
    public static int cutter(File file,long size ,File file1){
        int count = 0;
        if (file == null || file.exists() || !file.isFile()){
            try {

                FileInputStream fis = new FileInputStream(file);
                if (size < Integer.MAX_VALUE - 8){
                    byte [] bytes = new byte[(int) size];
                    int countSize = 0;
                    while (fis.available() !=0){
                        countSize = fis.read(bytes);
                        File outFile = new File(file1,"a" + count ++ + "ak.kfm");

                        FileOutputStream fos = new FileOutputStream(outFile);
                        fos.write(bytes, 0 , countSize);
                        fos.close();
                    }
                }else {

                }
                fis.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return count;
    }
}
