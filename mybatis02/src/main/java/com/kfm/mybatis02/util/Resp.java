package com.kfm.mybatis02.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resp implements Serializable {

    private Integer code;

    private String msg;

    private Object data;

    public static Resp ok(Object data){
        return new Resp(200, "操作成功", data);
    }

    public static Resp ok(){
        return new Resp(200, "操作成功", null);
    }

    public static Resp error(String msg){
        return new Resp(500, msg, null);
    }

}
