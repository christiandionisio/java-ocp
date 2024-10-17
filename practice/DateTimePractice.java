import java.time.*;

public class DateTimePractice {

    public static void main(String ...args) {

        // // Daylights
        // {
        //     LocalDateTime ldt = LocalDateTime.of(2022, 06, 02, 6, 0, 0);
        //     ZoneOffset nyOffset = ZoneOffset.ofHoursMinutes(-5, 0);
        //     ZoneId nyZone = ZoneId.of("America/New_York");
        //     OffsetDateTime nyOdt = ldt.atOffset(nyOffset);
        //     System.out.println(nyOdt);
        //     ZonedDateTime nyZdt = ldt.atZone(nyZone);
        //     System.out.println(nyZdt);
            
        //     Duration d = Duration.between(nyOdt, nyZdt);
        //     System.out.println(d);
        // }

        // // Duration and Periods
        // {
        //     Duration d = Duration.ofHours(25);    // only accepts long
        //     System.out.println(d);
        //     Duration ds = Duration.ofSeconds(25, 122);   
        //     System.out.println(ds);
        //     Period p = Period.ofDays(1);      // only accepts int
        //     System.out.println(p);
        // }
        {
            Duration d = Duration.ofDays(1);
            System.out.println(d);
            d = Duration.ofMinutes(0);
            System.out.println(d);
            Period p = Period.ofMonths(0);
            System.out.println(p);
            p = Period.ofYears(0);
            System.out.println(p);
        }

    }

}