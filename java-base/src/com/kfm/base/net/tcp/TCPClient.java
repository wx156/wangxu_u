package com.kfm.base.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 使用循环让代码可以重复发送数据
        while (true) {
            System.out.println("请输入");
            String string = scanner.next();
            try (Socket client = new Socket(InetAddress.getByName("10.0.4.143"), 9999);) {
                // 连接成功
                OutputStream outputStream = client.getOutputStream();

                outputStream.write(string.getBytes());

                client.shutdownOutput();

                // 接收来自服务端的反馈
                InputStream inputStream = client.getInputStream();

                byte[] bytes = inputStream.readAllBytes();

                System.out.println(new String(bytes));

                client.shutdownInput();

            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
