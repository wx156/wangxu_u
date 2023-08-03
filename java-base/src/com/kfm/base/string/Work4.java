package com.kfm.base.string;

public class Work4 {
    public static void main(String[] args) {
        String a = "abcre";
        String b = "abcde";
        String c = "abcde";
        String s = publicFront(a,b,c);
        System.out.println(s);
    }

    public static String publicFront(String a, String b, String c) {
        int length1 = a.length();
        int length2 = b.length();
        int length3 = c.length();
        String s = "";
        int min = Math.min(Math.min(length1, length2), length3);
        if ((a.substring(0,1).contains(b.substring(0,1)) && (b.substring(0,1).contains(c.substring(0,1))) && (a.substring(0,1).contains(c.substring(0,1))))){
            for (int i = 0; i < min; i++) {

                if ((a.substring(i, i + 1).contains(b.substring(i, i + 1)) && (b.substring(i, i + 1).contains(c.substring(i, i + 1))) && (a.substring(i, i + 1).contains(c.substring(i, i + 1)))))
                {
                    s += a.substring(i, i + 1);
                }else {
                    break;
                }
            }
            return s;
        }
        System.out.println("不存在公共前缀");
        return "";
    }
}
