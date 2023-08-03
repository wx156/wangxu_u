package com.kfm.base.string;

public class Work3 {
    public static void main(String[] args) {
        String a = "abcdabcfdc";
        a = subString(a);
        System.out.println(a);
    }
    public static String subString(String str){
        String max = "";
        for (int start = 0; start < str.length(); start++) {
            String sub = str.substring(start, start + 1);
            for (int end = start + 1; end < str.length(); end++) {
                String current = str.substring(end, end + 1);

                if (sub.contains(current)){
                    if (sub.length() > max.length()) {
                        max = sub;
                    }
                    break;
                } else{
                    sub += current;
                }
            }
        }
        return max;
    }
    public static String subString1(String str){
        String max = ""; // 存储最长子串
        int start = 0; // 子串的起始下标
        for (int end = start + 1; end < str.length(); end++) {
            // 子串的范围
            String sub = str.substring(start, end);
            // 当前位置的字符
            String current = str.substring(end, end + 1);
            // 当前位置的字符是否在子串中存在
            if (sub.indexOf(current) != -1){
                // 当前子串和目前最大子串谁大
                if (sub.length() > max.length()) {
                    max = sub;
                }

                // 找下一个子串的开始坐标
//                str.indexOf(current);  sub.indexOf()
                start = str.indexOf(current, start) + 1;

                // 最长子串比剩下的长度还长
                if (max.length() > str.length() - start - 1){
                    break;
                }
            } else if (end == str.length() - 1){ // 不存在并且是最后一个
                sub = str.substring(start); // 一直到最后一个都没有重复的
                // 当前子串和目前最大子串谁大
                if (sub.length() > max.length()) {
                    max = sub;
                }
            }

        }
        return max;
    }
}
