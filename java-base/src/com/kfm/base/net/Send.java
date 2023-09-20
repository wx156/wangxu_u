package com.kfm.base.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;

public class Send {
    public static void main(String[] args) {
        try {
            InetAddress mydress = InetAddress.getLocalHost();
            DatagramSocket server = new DatagramSocket();

            File file = new File("D:\\file//110.png");
            FileInputStream fis = new FileInputStream(file);

            byte [] bytes = fis.readAllBytes();

            DatagramPacket dp = new DatagramPacket(bytes,bytes.length,mydress,8810);

            server.send(dp);
            System.out.println("发送成功");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
