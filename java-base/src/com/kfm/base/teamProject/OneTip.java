package com.kfm.base.teamProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OneTip {
    /***
     * 读取项目下的server文件，将其中的服务器取出来，然后发get请求，得到响应码
     * @param args
     */
    public static void main(String[] args) {
        //新建文件输入流来读取server.txt 文件
        try (FileInputStream fis = new FileInputStream("server.txt");) {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10));
            byte[] bytes = fis.readAllBytes();
            //将读取到的字节码存到urls中
            String urls = new String(bytes);
            /*
                以分号分割字符串ruls并向每个服务器发送请求
             */
            for (int i = 0; i < urls.split(";").length; i++) {
                String s = urls.split(";")[i];
                URL url = new URL(s);
                // 将每一个请求交给线程池中的线程
                poolExecutor.execute(() -> {
                    HttpURLConnection conn = null;
                    try {
                        /*
                            每个服务器隔半分钟发一次请求，验证服务器的稳定性
                         */
                        while (true) {
                            conn = (HttpURLConnection) url.openConnection();
                            long l = System.currentTimeMillis();
                            int responseCode = conn.getResponseCode();
                            long l1 = System.currentTimeMillis();
                            // 对得到的响应码做判断正常则输出绿色的提示信息，错误则打印红色的提示
                            if (responseCode >= 200 && responseCode < 300) {
                                System.out.println("\u001B[32m" + s + "\t" + responseCode + "\t" + "time:" + (l1 - l) + "ms" + "\u001B[32m");
                            } else {
                                System.err.println(s + "\t" + responseCode + "\t" + "time:" + (l1 - l) + "ms");
                            }
                            Thread.currentThread().join(30000);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
