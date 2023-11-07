package uz.pdp.appmultithreading.timeapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatterExample {

    public static void main(String[] args) {



//        simpleDateFormat();

    }

    private static void simpleDateFormat() {
        //        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy h:m:s:S a z");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy h:m:s:S a z");
        Date date = new Date();
//        System.out.println(date);
        String format = simpleDateFormat.format(date);
//        String format = dateTimeFormatter.format(ZonedDateTime.now());
//        System.out.println(format);


        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyy h:m:s:S a z");

        try {
            String dateString = "02-11-2023 7:51:43:889 PM GMT+05:00";
            Date date2 = simpleDateFormat2.parse(dateString);
            System.out.println(date2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
