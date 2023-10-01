package com.kfm.base.teamProject;

import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SendRequest {
    private File file = new File("io//server.txt");

    /***
     * 读取文件中的服务器链接
     * @return list集合中存入每一个连接
     */

    private List<String> readTxt() {
        String s = "";
        // 将文件读出为一个string
        try (FileInputStream fis = new FileInputStream(file);) {
            byte[] bytes = fis.readAllBytes();
            s = new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 用分号分割
        return new ArrayList<>(Arrays.asList(s.trim().split(";")));
    }

    /***
     * 发送请求，并将每一个请求交给一个线程
     */
    public void sendRequest() {
        // 调用readTxt 方法将文件中的链接存入集合
        List<String> strings = readTxt();
        // 创建线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 20, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));
        /*
            遍历集合，给每一个连接发送get 请求
         */
        for (String s : strings) {
            poolExecutor.execute(() -> {
                try {
                    while (true) {
                        URL url = new URL(s);
                        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                        long l = System.currentTimeMillis();
                        int responseCode = urlConnection.getResponseCode();
                        long l1 = System.currentTimeMillis();
                        // 响应码为大于等于200并且小于300，且响应时间小于1000毫秒即是状态正常
                        if (responseCode >= 200 && responseCode < 300 && l1 - l <= 1000) {
                            System.out.println("\u001B[32m" + s + "\t" + responseCode + "\t" + "time:" + (l1 - l) +
                                    "ms" + "\u001B[32m" + "\t" + getTime(System.currentTimeMillis()));
                            //响应时间大于1000毫秒即发送三次请求，若两次正常则取平均时间作为响应时间
                        } else {
                            long avg = 0;
                            int count = 0;
                            for (int i = 0; i < 3; i++) {
                                long l2 = System.currentTimeMillis();
                                int responseCode1 = urlConnection.getResponseCode();
                                long l3 = System.currentTimeMillis();
                                if (l3 - l2 <= 1000 && responseCode1 >= 200 && responseCode1 < 300) {
                                    count++;
                                }
                                avg += (l3 - l2);
                                avg = avg / 3;
                            }
                            if (count >= 2) {
                                System.out.println("\u001B[32m" + s + "\t" + responseCode + "\t" + "time:" + avg +
                                        "ms" + "\u001B[32m" + "\t" + getTime(System.currentTimeMillis()));
                            } else {
                                System.err.println(s + "\t" + responseCode + "\t" + "time:" + (l1 - l) + "ms" + "\t" + getTime(System.currentTimeMillis()));
                            }
                        }
                        Thread.currentThread().join(30000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /***
     * 格式化时间
     * @param l 传入一个long值
     * @return 返回一个格式化时间后的string
     */
    private String getTime(long l){
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simple.format(l);
    }
}
