import java.time.*;

public class DateTimePractice {

    public static void main(String ...args) {

        {
            LocalDateTime ldt = LocalDateTime.of(2022, 06, 02, 6, 0, 0);
            ZoneOffset nyOffset = ZoneOffset.ofHoursMinutes(-5, 0);
            ZoneId nyZone = ZoneId.of("America/New_York");
            OffsetDateTime nyOdt = ldt.atOffset(nyOffset);
            System.out.println(nyOdt);
            ZonedDateTime nyZdt = ldt.atZone(nyZone);
            System.out.println(nyZdt);
            
            Duration d = Duration.between(nyOdt, nyZdt);
            System.out.println(d);
        }

    }

}