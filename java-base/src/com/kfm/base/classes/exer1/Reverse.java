package com.kfm.base.classes.exer1;

public class Reverse {
    private String reverse(String b){
        byte[] a =b.getBytes();
        byte[] newA = new byte[a.length];
        int j = 0;

        for (int i = a.length-1; i >= 0; i--) {
            newA[j++] = a[i];
        }
        String c= new String(newA);
        return c;
    }
    public Boolean isResverse (String a){
        if (a.equals(reverse(a))){
            System.out.println("是对称字符串");
            return true;
        }
        else {
            System.out.println("不是对称字符串");
            return false;
        }
    }

}
