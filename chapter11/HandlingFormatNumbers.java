import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Month;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.text.ParseException;
import java.text.NumberFormat.Style;
import java.util.stream.Stream;

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


        {
            Locale locale = Locale.getDefault();
            System.out.println(locale);
        }
        {
            System.out.println(Locale.getDefault());
            Locale locale = new Locale("fr");
            Locale.setDefault(locale);
            System.out.println(Locale.getDefault());  // fr
        }


        // Formatting Numbers
        {
            int attendeesPerYear = 3_200_000;
            int attendeesPerMonth = attendeesPerYear / 12;
            
            var us = NumberFormat.getInstance(Locale.US);
            System.out.println(us.format(attendeesPerMonth)); // 266,666
            
            var gr = NumberFormat.getInstance(Locale.GERMANY);
            System.out.println(gr.format(attendeesPerMonth)); // 266.666
            
            var ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
            System.out.println(ca.format(attendeesPerMonth)); // 266 666
        }

        // Formatting currency
        {
            double price = 48;
            Locale.setDefault(new Locale("es", "PE"));
            var myLocale = NumberFormat.getCurrencyInstance(Locale.getDefault());
            System.out.println(myLocale.format(price));
        }

        // Formatting percentage
        {
            double successRate = 0.802;
            var us = NumberFormat.getPercentInstance(Locale.US);
            System.out.println(us.format(successRate)); // 80%
            
            var gr = NumberFormat.getPercentInstance(Locale.GERMANY);
            System.out.println(gr.format(successRate)); // 80 %
        }

        // Parsing numbers
        {
            String s = "40.45";
            
            try {
                var en = NumberFormat.getInstance(Locale.US);
                System.out.println(en.parse(s)); // 40.45
                
                var fr = NumberFormat.getInstance(Locale.FRANCE);
                System.out.println(fr.parse(s)); // 40
            } catch(ParseException e) {
                e.printStackTrace();
            }
        }
        {
            try {
                String income = "$92,807.99";
                var cf = NumberFormat.getCurrencyInstance(Locale.US);
                double value = (Double) cf.parse(income);
                System.out.println(value);  // 92807.99
            } catch(ParseException e) {
                e.printStackTrace();
            }
            
        }


        // Formatting with CompactNumberFormat (JAVA 17)
        {
            var formatters = Stream.of(
                NumberFormat.getCompactNumberInstance(),
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), Style.SHORT),
                NumberFormat.getCompactNumberInstance(Locale.getDefault(), Style.LONG),
                
                NumberFormat.getCompactNumberInstance(Locale.GERMAN, Style.SHORT),
                NumberFormat.getCompactNumberInstance(Locale.GERMAN, Style.LONG),
                NumberFormat.getNumberInstance());
            
            formatters.map(s -> s.format(7_123_456)).forEach(System.out::println);
        }


        // Localizing dates
        {
            Locale.setDefault(new Locale("en", "US"));
            var italy = new Locale("it", "IT");
            var dt = LocalDateTime.of(2022, Month.OCTOBER, 20, 15, 12, 34);
            
            // 10/20/22 --- 20/10/22
            print(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT),dt,italy);
            
            // 3:12 PM --- 15:12
            print(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT),dt,italy);
            
            // 10/20/22, 3:12 PM --- 20/10/22, 15:12
            print(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT,FormatStyle.SHORT),dt,italy);
        }

        // specifying a local category
        {
            var spain = new Locale("es", "ES");
            var money = 1.23;
            
            // Print with default locale
            Locale.setDefault(new Locale("en", "US"));
            printCurrency(spain, money);  // $1.23, Spanish
            
            // Print with selected locale display
            Locale.setDefault(Locale.Category.DISPLAY, spain);
            printCurrency(spain, money);  // $1.23, español
            
            // Print with selected locale format
            Locale.setDefault(Locale.Category.FORMAT, spain);
            printCurrency(spain, money);  // 1,23 €, español
        }

    }

    public static void print(DateTimeFormatter dtf, LocalDateTime dateTime, Locale locale) {
        System.out.println(dtf.format(dateTime) + " --- "
            + dtf.withLocale(locale).format(dateTime));
    }

    public static void printCurrency(Locale locale, double money) {
       System.out.println(NumberFormat.getCurrencyInstance().format(money)
          + ", " + locale.getDisplayLanguage());
    }

}