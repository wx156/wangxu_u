package com.kfm.base.file.inputAndOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Add {
    public static void main(String[] args) {

    }
    public long add(final File dir, final File target) throws IOException {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(target);
        ) {
            File[] files = dir.listFiles((d, name) -> name.endsWith(".temp"));

            System.out.println(Arrays.toString(files));
            assert files != null;
            for (File file : files) {
                try (FileInputStream fileInputStream = new FileInputStream(file);) {
                    fileOutputStream.write(fileInputStream.readAllBytes());
                } catch (IOException e) {
                    throw new IOException("写错误");
                }
            }
        } catch (IOException e) {
            throw new IOException("读错误");
        }
        return target.length() ; // 返回合并后的文件体积
    }

}
