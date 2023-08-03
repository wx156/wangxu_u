package com.kfm.base.string;

public class Exercise4 {
    public static void main(String[] args) {
        String string = "";
        char [] chars = string.toCharArray();
        int count = 0;


        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length -1; j++) {
                if (chars[i] == chars[j]){
                    chars[j] = chars[j-1];
                    count ++;
                }
            }
        }
        string = String.valueOf(chars,0,chars.length-count+1);
        System.out.println(string.toString());
    }
}
