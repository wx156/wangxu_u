package com.kfm.base.file.inputAndOutput;

import java.io.*;
import java.nio.charset.Charset;

public class Exer01 {
    public static void main(String[] args) {
        /*
        如何转换一个文件的字符编码集
       */
        File s = new File("d://b.txt");
        Charset sc = Charset.forName("utf-8");

        File r = new File("D://bgbk.txt");
        Charset rc = Charset.forName("gbk");
        conversionByBite(s,sc,r,rc);
    }
    public static boolean conversion(File source ,Charset schar, File result , Charset rchar){
        if (source == null || !source.exists() || !source.isFile()){
            try {
                throw new FileNotFoundException("找不到源文件");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(source), schar);
            FileOutputStream fos = new FileOutputStream(result);
            char [] chars = new char[1024];
            int a;
            while ((a = isr.read(chars)) != -1){
                byte[] bytes = new String(chars,0,a).getBytes(rchar);
                fos.write(bytes);
            }

            isr.close();
            fos.close();
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean conversionByBite(File source ,Charset schar, File result , Charset rchar){
        if (source == null || !source.exists() || !source.isFile()){
            try {
                throw new FileNotFoundException("找不到源文件");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(result);
            byte [] bytes = new byte[(int) source.length()];
            int size;
            while ((size = fis.read(bytes)) != -1){
                String str = new String(bytes,0,size,schar);
                byte [] bytes1 = str.getBytes(rchar);
                fos.write(bytes1);
            }
            fos.close();
            fis.close();
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
