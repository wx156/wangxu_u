package com.kfm.base.date;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Date1 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());

        Calendar calendar = Calendar.getInstance();
        calendar.set(1970,8,18,23,36,55);
//        System.out.println(calendar.toString());

        LocalDate date1 = LocalDate.now();
        System.out.println(date1);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hhmmssSSS");
        System.out.println(sdf.format(date));

        LocalDate localDate =LocalDate.now();

        LocalDate date3 = LocalDate.of(2023,4,30);
        LocalDate date2 = LocalDate.ofYearDay(2020,257);
        System.out.println(date3);
        System.out.println(date2);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek);

        boolean l = localDate.isLeapYear();
        System.out.println(l);

        LocalDateTime ldf = LocalDateTime.now();
        String s = ldf.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(s);

        LocalDateTime parse = LocalDateTime.parse("2023-04-22T23:48:38");
        System.out.println(parse);
    }
}
