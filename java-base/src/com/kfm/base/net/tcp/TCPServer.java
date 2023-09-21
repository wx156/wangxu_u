package com.kfm.base.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {

        while(true){
            try (ServerSocket server = new ServerSocket(9999);){

                // 等待客户端连接
                Socket accept = server.accept();

                InputStream inputStream = accept.getInputStream();

                byte[] bytes = inputStream.readAllBytes();

                System.out.println("接收到" + accept.getInetAddress() + " 的信息：" + new String(bytes));

                // 返回信息
                OutputStream outputStream = accept.getOutputStream();
                outputStream.write("已收到，Over".getBytes());

                accept.shutdownOutput();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}