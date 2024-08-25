import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Month;

public class HandlingFormatNumbers {

    public static void main(String ...args) {

        // DecimalFormat
        {
            double d = 1234.567;
            NumberFormat f1 = new DecimalFormat("###,###,###.0");
            System.out.println(f1.format(d));  // 1,234.6
            
            NumberFormat f2 = new DecimalFormat("000,000,000.00000");
            System.out.println(f2.format(d));  // 000,001,234.56700
            
            NumberFormat f3 = new DecimalFormat("Your Balance $#,###,###.##");
            System.out.println(f3.format(d));  // Your Balance $1,234.57
        }

        // DateTimeFormatter
        {
            LocalDate date = LocalDate.of(2022, Month.OCTOBER, 20);
            LocalTime time = LocalTime.of(11, 12, 34);
            LocalDateTime dt = LocalDateTime.of(date, time);
            
            System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
            System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
            System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

            var f = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'a las' hh:mm 'horas'");
            System.out.println(dt.format(f));  // octubre 20, 2022 a las 11:..
        }
        {
            var dt = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);
 
            var formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
            System.out.println(dt.format(formatter1));  // 10/20/2022 06:15:30
            
            var formatter2 = DateTimeFormatter.ofPattern("MM_yyyy_-_dd");
            System.out.println(dt.format(formatter2));  // 10_2022_-_20
            
            // var formatter3 = DateTimeFormatter.ofPattern("h:mm z"); // timezone is not specified
            // System.out.println(dt.format(formatter3));  // DateTimeException
        }

        {
            var dateTime = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);
            var formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
            
            System.out.println(dateTime.format(formatter)); // 10/20/2022 06:15:30
            System.out.println(formatter.format(dateTime)); // 10/20/2022 06:15:30
        }

        // Escaping characters
        {
            var dt = LocalDateTime.of(2022, Month.OCTOBER, 20, 6, 15, 30);

            var g1 = DateTimeFormatter.ofPattern("MMMM dd', Party''s at' hh:mm");
            System.out.println(dt.format(g1));  // October 20, Party's at 06:15
            
            var g2 = DateTimeFormatter.ofPattern("'System format, hh:mm: 'hh:mm");
            System.out.println(dt.format(g2));  // System format, hh:mm: 06:15
            
            var g3 = DateTimeFormatter.ofPattern("'NEW! 'yyyy', yay!'");
            System.out.println(dt.format(g3));  // NEW! 2022, yay!
        }

    }

}