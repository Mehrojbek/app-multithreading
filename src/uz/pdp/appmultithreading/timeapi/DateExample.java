package uz.pdp.appmultithreading.timeapi;

import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateExample {

    public static void main(String[] args) {

//        date();

//        calendar();


    }

    private static void calendar() {
        Calendar calendar = Calendar.getInstance();
//        Calendar calendar = new GregorianCalendar();

//        calendar.add(Calendar.DATE,12);
//        calendar.add(Calendar.MONTH,3);
//        calendar.add(Calendar.SECOND,120);
//        calendar.add(Calendar.MINUTE,200);

//        int var = calendar.get(Calendar.SECOND);
//        System.out.println(var);

//        calendar.setLenient(false);
//        calendar.set(Calendar.DATE,31);

//        calendar.roll(Calendar.DATE,45);

//        int var = calendar.getWeeksInWeekYear();
//
//        System.out.println(var);
//
//        System.out.println(calendar.getTime());
    }

    private static void date() {
        //        Date date = new Date();

//        date.setTime(1600000000000L);
//        date.set

//        Date date1 = new Date(1,0,1);
        Date date1 = new Date();
        Date date2 = new Date();

//        if (date1.equals(date2)) {
//            System.out.println("Teng ekan");
//        } else if (date1.before(date2)) {
//            System.out.println("avval ekan");
//        } else {
//            System.out.println("avval emas");
//        }
//
//        if (date1.after(date2)) {
//            System.out.println("Keyin");
//        } else {
//            System.out.println("Keyin emas");
//        }

        long time = date1.getTime();
        date1.setDate(32);

//        int seconds = date1.getSeconds();
//        int minutes = date1.getMinutes();
//        int month = date1.getMonth();

//        System.out.println(seconds);
//        System.out.println(minutes);
//        System.out.println(month);
//        System.out.println(System.currentTimeMillis());
//        System.out.println(time);

        System.out.println(date1);
//        System.out.println(date2);
    }

}
