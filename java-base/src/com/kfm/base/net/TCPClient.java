package com.kfm.base.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket client = new Socket(InetAddress.getLocalHost(),8822);
             OutputStream os = client.getOutputStream()){
            os.write("hello".getBytes());
            os.write("你好".getBytes());

            client.shutdownInput();

            System.out.println("发送成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
