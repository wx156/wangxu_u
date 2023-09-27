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
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("server.txt");) {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10));
            byte[] bytes = fis.readAllBytes();
            String urls = new String(bytes);
            for (int i = 0; i < urls.split(";").length; i++) {
                String s = urls.split(";")[i];
                URL url = new URL(s);
                poolExecutor.execute(() -> {
                    HttpURLConnection conn = null;
                    try {
                        while (true) {
                            conn = (HttpURLConnection) url.openConnection();
                            long l = System.currentTimeMillis();
                            int responseCode = conn.getResponseCode();
                            long l1 = System.currentTimeMillis();
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
