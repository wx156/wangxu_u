package com.kfm.base.file.inputAndOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exer02 {
    public static void main(String[] args) {
        File file = new File("D:\\c.txt");
        File file1 = new File("D:\\cre.txt");
        /*
        请将文本信息恢复顺序。
        步骤：

        1. 使用流对象逐行读取原文本信息,把读取的信息保存到集合中
        2. 使用Collections集合工具类中的方法sort,对集合中的元素按照自定义规则排序
        3. 遍历集合,把集合中排序后的文本在写入到新的记事本中
        */
        System.out.println(recovery(file, file1));
    }
    public static boolean recovery(File sourse , File result){
        if (sourse != null || sourse.exists() || sourse.isFile()) {
            try {

                BufferedReader br = new BufferedReader(new FileReader(sourse));
                FileWriter fw = new FileWriter(result);
                char[] chars = new char[1024];
                String size;
                List<String> list = new ArrayList<>();
                while ((size= br.readLine()) != null){
                    list.add(size);
                }
                Collections.sort(list, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return Integer.parseInt(o1.split("\\.")[0])-Integer.parseInt(o2.split("\\.")[0]);
                    }
                });
                for (String s : list){
                    char [] chars1 = new char[s.length()];
                    s.getChars(0,s.length(),chars1,0);
                    fw.write(chars1);
                    fw.write("\r\n");
                }
                fw.close();
                br.close();
                return true;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
