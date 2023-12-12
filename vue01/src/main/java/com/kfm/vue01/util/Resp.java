package com.kfm.vue01.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resp {

    private Integer code;

    private String msg;

    private Object data;

    public static Resp ok(){
        return new Resp(200, "ok", null);
    }

    public static Resp ok(Object data){
        return new Resp(200, "ok", data);
    }

    public static Resp error(String msg){
        return new Resp(500, msg, null);
    }
}
