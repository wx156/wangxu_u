package com.kfm.base.string;

public class Work5 {
    public static void main(String[] args) {

        System.out.println(label(6));
    }
    private static String label(int num){
        if (num == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        while (num != 0){
            num -= 1;
            result.append((char) (65+ num%26));
            num /= 26;
        }
        return result.reverse().toString();
    }
}
