package com.kfm.base.file.inputAndOutput;

import java.io.*;

public class Output01 {
    public static void main(String[] args) {
        File file = new File("D://b.txt");


        try (FileOutputStream fos = new FileOutputStream(file); FileInputStream fis = new FileInputStream("D://c.txt")) {

            fos.write("海上生明月".getBytes());
            fis.transferTo(fos);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
