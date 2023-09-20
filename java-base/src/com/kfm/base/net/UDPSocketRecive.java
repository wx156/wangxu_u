package com.kfm.base.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPSocketRecive {
    public static void main(String[] args) {
        // 接收王旭

        //1. 创建用于接收信息的`DatagramPacket`对象
        int length = 1024 * 30;
        byte[] bytes = new byte[length];
        DatagramPacket packet = new DatagramPacket(bytes, length);
        DatagramSocket socket = null;
        try {
            //2.创建socket对象
            socket = new DatagramSocket(8810);
            //3.接收信息
            socket.receive(packet);
            File file = new File("d://123.png");
            FileOutputStream fos = new FileOutputStream(file);

            fos.write(packet.getData(), 0, packet.getLength());

            System.out.println(packet.getAddress().getHostAddress() + "发送成功");

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            socket.close();
        }
    }
}



