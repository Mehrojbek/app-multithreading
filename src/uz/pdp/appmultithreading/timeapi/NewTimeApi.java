package uz.pdp.appmultithreading.timeapi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NewTimeApi {

    public static void main(String[] args) {

//        instant();

//        localDate();

//        localTime();

//        localDateTime();

//        duration();

//        period();

//        zonedDateTime();



    }

    private static void zonedDateTime() {

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

        ZoneId zone = zonedDateTime.getZone();

        ZoneId zoneId = ZoneId.systemDefault();

        System.out.println(zoneId);
        System.out.println(zone);
        System.out.println(zonedDateTime);

    }

    private static void duration() {


        LocalDateTime from = LocalDateTime.of(1997, 5, 4,0,0);
        LocalDateTime to = LocalDateTime.now();

        Duration duration = Duration.between(from, to);

        long days = duration.toDays();
        int millisPart = duration.toMillisPart();
        System.out.println(millisPart);
        System.out.printf("days %d%n",days);

        System.out.println(duration);

    }

    private static void period() {

        LocalDate from = LocalDate.of(1997, 5, 4);
        LocalDate to = LocalDate.now();

        Period period = Period.between(from, to);
        System.out.println(period);

        int days = period.getDays();
        int months = period.getMonths();
        int years = period.getYears();

        System.out.printf("%d yil %d oy %d kun yashadingiz %n",years,months,days);

    }

    private static void localDateTime() {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime localDateTime = now.plusMinutes(45);
        System.out.println(localDateTime);
    }

    private static void localTime() {
//        LocalTime localTime = LocalTime.now();

//        ZoneId.

        ZoneId zoneId = ZoneId.of("America/Anchorage");
        LocalTime localTime = LocalTime.now(zoneId);
        System.out.println(localTime);
        int second = localTime.getSecond();
//        System.out.println(second);

        LocalTime plus = localTime.plus(25, ChronoUnit.MINUTES);
//        System.out.println(plus);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String format = localTime.format(dateTimeFormatter);
//        System.out.println(format);
    }

    private static void localDate() {
        LocalDate date = LocalDate.now();

        LocalDate localDate = date.plusDays(13);
//        DayOfWeek dayOfWeek = date.getDayOfWeek();

        LocalDate date1 = date.plus(13, ChronoUnit.WEEKS);
        int dayOfWeek = date.get(ChronoField.DAY_OF_WEEK);
        int var = date.get(ChronoField.DAY_OF_YEAR);

//        System.out.println(var);
//        System.out.println(dayOfWeek);
//        System.out.println(dayOfWeek);
//        System.out.println(localDate);
//        System.out.println(date1);

        LocalDate localDate1 = localDate.plusDays(34);
        System.out.println(localDate1);
    }

    private static void instant() {
        Instant instant = Instant.now();

        System.out.println(instant);

        Instant instant1 = instant.plusSeconds(2000);
//        Instant instant2 = instant.plus(20, ChronoUnit.MINUTES);
        Instant instant2 = instant.plus(5, ChronoUnit.DAYS);

//        System.out.println(instant1);
        System.out.println(instant2);
    }

}
