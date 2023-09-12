package com.kfm.base.file.inputAndOutput;

import java.io.*;

public class Cut {


    public static void main(String[] args) {

        File f = new File("d://video.mp4"); // 被拆分的文件
        long size = 1024 * 1024 * 2; // 表示每个文件体积最大为20MB
        File dir = new File("D:/video"); // 拆分后的小文件的存放目录
        // 将 f 对应的文件拆分成 N 份，每一份大小 至多 20MB，并将拆分后的文件依次序放入到dir 对应的目录中
        System.out.println(split(f, size, dir));
    }
    /**
     * 将指定文件切割为不超过 size 大小的 N 份后，依次序放入到 directory 目录中
     * @param original 被拆分的原始文件
     * @param size 表示被拆分后的单个文件的最大体积
     * @param directory 表示将拆分后的多个文件放入到哪个目录中
     * @return 返回切割后的文件数目
     */
    public static int split(final File original, final long size, final File directory) {
        int n = 0; // 表示拆分后文件个数的变量
        try (
                FileInputStream fileInputStream = new FileInputStream(original);
        ) {
            byte[] bytes = new byte[size > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) size];
            int index;
            while ((index = fileInputStream.read(bytes)) != -1) {  // 按照最大值读文件
                File file = new File(directory, n + ".temp");  // 每部分文件名
                try (FileOutputStream fileOutputStream = new FileOutputStream(file);) {
                    fileOutputStream.write(bytes, 0 , index);  // 将读的文件写在指定地点
                    n ++;
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }
        return n; // 返回拆分后的文件个数
    }

}