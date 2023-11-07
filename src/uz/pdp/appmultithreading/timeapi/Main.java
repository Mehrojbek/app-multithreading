package uz.pdp.appmultithreading.timeapi;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.setLenient(false);

        calendar.add(Calendar.DATE,36);


//        calendar.set(Calendar.DATE, 35);
//        calendar.roll(Calendar.DATE, 43);

//        System.out.println(calendar.getFirstDayOfWeek());

        System.out.println(calendar.getTime());

    }

}
