import java.time.*;
import java.time.temporal.*;

public class DatesAndTimesHandling {

    public static void main(String ...args) {

        // Periods
        var annually = Period.ofYears(1);            // every 1 year
        var quarterly = Period.ofMonths(3);          // every 3 months
        var everyThreeWeeks = Period.ofWeeks(3);     // every 3 weeks
        var everyOtherDay = Period.ofDays(2);        // every 2 days
        var everyYearAndAWeek = Period.of(1, 0, 7);  // every year and 7 days

        var date = LocalDate.of(2022, 1, 20);
        var time = LocalTime.of(6, 15);
        var dateTime = LocalDateTime.of(date, time);
        var period = Period.ofMonths(1);
        System.out.println(date.plus(period));     // 2022–02–20
        System.out.println(dateTime.plus(period)); // 2022–02–20T06:15
        // System.out.println(time.plus(period));     // Exception


        // Durations
        var daily = Duration.ofDays(1);               // PT24H
        var hourly = Duration.ofHours(1);             // PT1H
        var everyMinute = Duration.ofMinutes(1);      // PT1M
        var everyTenSeconds = Duration.ofSeconds(10); // PT10S
        var everyMilli = Duration.ofMillis(1);        // PT0.001S
        var everyNano = Duration.ofNanos(1);          // PT0.000000001S

        var daily2 = Duration.of(1, ChronoUnit.DAYS);
        var hourly2 = Duration.of(1, ChronoUnit.HOURS);
        var everyMinute2 = Duration.of(1, ChronoUnit.MINUTES);
        var everyTenSeconds2 = Duration.of(10, ChronoUnit.SECONDS);
        var everyMilli2 = Duration.of(1, ChronoUnit.MILLIS);
        var everyNano2 = Duration.of(1, ChronoUnit.NANOS);


        // ChronoUnit for differences
        var one = LocalTime.of(5, 15);
        var two = LocalTime.of(6, 30);
        var date3 = LocalDate.of(2016, 1, 20);
        System.out.println(ChronoUnit.HOURS.between(one, two));     // 1
        System.out.println(ChronoUnit.MINUTES.between(one, two));   // 75
        // System.out.println(ChronoUnit.MINUTES.between(one, date));  // DateTimeException


        var date4 = LocalDate.of(2022, 1, 20);
        var time2 = LocalTime.of(6, 15);
        var dateTime3 = LocalDateTime.of(date4, time2);
         var duration3 = Duration.ofHours(6);
         System.out.println(dateTime.plus(duration3));  // 2022–01–20T12:15
         System.out.println(time.plus(duration3));      // 12:15
        //  System.out.println(date.plus(duration3));  // UnsupportedTemporalTypeException


        // Working with instants
        var now = Instant.now();
        // do something time consuming
        var later = Instant.now();
        var duration = Duration.between(now, later);
        System.out.println(duration.toMillis());  // Returns number milliseconds

        var date5 = LocalDate.of(2022, 5, 25);
        var time4 = LocalTime.of(11, 55, 00);
        var zone4 = ZoneId.of("US/Eastern");
        var zonedDateTime4 = ZonedDateTime.of(date4, time4, zone4);
        var instant = zonedDateTime4.toInstant(); // 2022–05–25T15:55:00Z
        System.out.println(zonedDateTime4); // 2022–05–25T11:55–04:00[US/Eastern]
        System.out.println(instant); // 202–05–25T15:55:00Z

        
        // Accounting for daylight saving time
        var date6 = LocalDate.of(2022, Month.MARCH, 13);
        var time6 = LocalTime.of(1, 30);
        var zone6 = ZoneId.of("US/Eastern");
        var dateTime6 = ZonedDateTime.of(date6, time6, zone6);
        System.out.println(dateTime6);  // 2022–03-13T01:30-05:00[US/Eastern]
        System.out.println(dateTime6.getHour()); // 1
        System.out.println(dateTime6.getOffset()); // -05:00
        
        dateTime6 = dateTime6.plusHours(1);
        System.out.println(dateTime6);  // 2022–03-13T03:30-04:00[US/Eastern]
        System.out.println(dateTime6.getHour()); // 3
        System.out.println(dateTime6.getOffset()); // -04:00

        var date7 = LocalDate.of(2022, Month.NOVEMBER, 6);
        var time7 = LocalTime.of(1, 30);
        var zone7 = ZoneId.of("US/Eastern");
        var dateTime7 = ZonedDateTime.of(date7, time7, zone7);
        System.out.println(dateTime7); // 2022-11-06T01:30-04:00[US/Eastern]
        dateTime7 = dateTime7.plusHours(1);
        System.out.println(dateTime7); // 2022-11-06T01:30-05:00[US/Eastern]
        dateTime7 = dateTime7.plusHours(1);
        System.out.println(dateTime7); // 2022-11-06T02:30-05:00[US/Eastern]



    }


}