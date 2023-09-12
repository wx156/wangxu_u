package com.kfm.base.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Exer03 {
    /**
     *
     * 统计一个文件夹中每种文件的个数并打印(不考虑目录)
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("d://");
        Map<String,Integer> map = countFile(file);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        entries.forEach(e -> System.out.println(e.getKey() +":"+ e.getValue()));
    }

    private static Map<String, Integer> countFile(File file) {
        if (file == null || !file.exists()){
            try {
                throw new FileNotFoundException("文件不存在");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        File[] files = file.listFiles();
        for (File f : files){
            if (f.isFile()){
                String name = f.getName();
                String[] split = name.split("\\.");
                String key = split[split.length - 1];
                map.put(key,map.getOrDefault(key,0)+1);
            }
        }
        return map;
    }
}
