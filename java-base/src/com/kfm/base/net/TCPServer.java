package com.kfm.base.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8822);

            // 阻塞，等待客户端连接.连接一建立，就会返回连接对象 Socket
            Socket client = server.accept();

            InputStream is = client.getInputStream();

            byte [] bytes = is.readAllBytes();

            String msg = new String(bytes);

            System.out.println("接收到的信息是：" + msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
