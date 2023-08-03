package com.kfm.base.collection.stream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Exer06 {
    public static void main(String[] args) throws ParseException {
        Map<String, Date> brithday = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");

        brithday.put("张三1", sdf.parse("12-04"));
        brithday.put("张三2", sdf.parse("11-03"));
        brithday.put("张三3", sdf.parse("02-24"));
        brithday.put("张三4", sdf.parse("12-14"));
        brithday.put("张三5", sdf.parse("07-04"));
        brithday.put("张三6", sdf.parse("08-04"));

        System.out.println(brithday);

        Set<Map.Entry<String, Date>> bri = brithday.entrySet();
        
        System.out.println(bri);


    }
}
