package com.kfm.base.net.tcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPclientFile {
    public static void main(String[] args) {
        try(Socket client = new Socket("localhost",5598);) {
            OutputStream os = client.getOutputStream();
            FileInputStream fis = new FileInputStream("D:\\file\\110.png");

            byte [] bytes = fis.readAllBytes();
            os.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
