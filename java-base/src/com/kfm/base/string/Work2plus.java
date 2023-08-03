package com.kfm.base.string;

public class Work2plus {
    public boolean determine(String str){
        for (int i = 0; i < str.length(); i++) {
            str = str.replace("()","").replace("{}","").replace("[]","");
        }
        return str.length() == 0;
    }
}
