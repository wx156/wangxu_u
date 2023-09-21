package com.kfm.base.net.tcp;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TCPServerFile {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5598);//每发一次关闭一次
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.AbortPolicy());
        while (true){
            int i = 0;
            executor.execute(()->{
                try {
                    Socket accept = serverSocket.accept();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(accept.getInputStream());
                    byte b[] = bufferedInputStream.readAllBytes();
                    FileOutputStream fileOutputStream = new FileOutputStream("D:\\1\\"+System.currentTimeMillis()+".jpg");
                    fileOutputStream.write(b);
                    System.out.println("上传完毕");
                    accept.shutdownInput();
                    //给客户端返回信息
                    OutputStream outputStream = accept.getOutputStream();
                    outputStream.write("文件保存成功".getBytes());
                    outputStream.close();
                    bufferedInputStream.close();
                    fileOutputStream.close();
                    accept.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}