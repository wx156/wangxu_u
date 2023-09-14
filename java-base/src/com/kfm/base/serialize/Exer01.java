package com.kfm.base.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Exer01 {

    public static void main(String[] args){
        /*
            序列化
         */
//        try (FileOutputStream fos = new FileOutputStream("D:\\serialize\\a.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)){
//            oos.writeInt(123456);
//            oos.writeShort(8990);
//            oos.writeObject(new Student("张三",20,"男"));
//
//            System.out.println(fos);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        /*
            反序列化
         */
        try (FileInputStream fis = new FileInputStream("D:\\serialize\\a.txt");ObjectInputStream ois = new ObjectInputStream(fis)) {
            byte [] bytes = new byte[6];
            if (ois.available() != -1){
                ois.read(bytes);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
