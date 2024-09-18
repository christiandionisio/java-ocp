import java.time.*;
import java.time.format.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

public class Practice {

    public static void main(String ...args) {


        // {
        //     HELLO: for(int i = 0; i<10; i++) {
        //         WORLD: while(i < 5) {
        //             if(i == 2) continue HELLO;
        //             if(i == 4) break WORLD;
        //             System.out.println(i);
        //             i++;
        //         }
        //         break HELLO;
        //     }

        //     System.out.println("Finished loop");
        // }

        // {
        //     String hello = """
        //         Hola mundo
        //         Hello world
        //         GAAAA
        //         """;
        //     hello = hello.indent(2);
        //     hello.lines()
        //         .forEach(System.out::println);
        // }

        // {
        //     record Square(int width, int large) {
        //         public static final int squareDefault = 10;

        //         public Square {
        //             if(width == large) {
        //                 System.out.println("Is a square!!");
        //                 width = squareDefault;
        //                 large = squareDefault;
        //             } else {
        //                 System.out.println("Not a square");
        //             }
        //         }

        //         public Square(int number) {
        //             this(number, number); // it's a must in non canonical constructors
        //             System.out.println("You're only giving one parameter!!");
        //         }

        //         public Square(String name) {
        //             this(squareDefault);
        //             System.out.println("You've gave a string parameter");
        //         }

        //         public final double area() {
        //             return width*large;
        //         }

        //         @Override
        //         public String toString() {
        //             return "Square object overrided!!";
        //         }
        //     }

        //     Square square = new Square(4, 5);
        //     System.out.println(square.width());
        //     System.out.println(square.large());
        //     System.out.println(square.area());
        //     System.out.println(square);
        // }

        // {
        //     Instant instant = Instant.now();
        //     LocalDateTime localDateTime = LocalDateTime.now();
        //     System.out.println(instant);
        //     System.out.println(localDateTime);

        //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'del' yyyy ");
        //     System.out.println(localDateTime.format(formatter));
        // }

        // {
        //     try {
        //         var rlock = new ReentrantLock();
        //         // var f1 = rlock.tryLock();
        //         new Thread(() -> rlock.lock()).start(); // necesary to start new thread to lock the object
        //         // System.out.println(f1);
        //         Thread.sleep(2000);
        //         var f2 = rlock.tryLock();
        //         System.out.println(f2);
        //     } catch (Exception e) {}

        // }
        
        // Type erasure
        {
            List<String> listaString = new ArrayList<>();
            listaString.add("dummy");

            List<Integer> listaInteger = new ArrayList<>();
            listaInteger.add(1);

            List listaRawCollection = new ArrayList();
            listaRawCollection = listaInteger;
            listaRawCollection.add(2);
            // listaRawCollection = listaInteger;
            // listaRawCollection.forEach(System.out::println);

            listaInteger = listaRawCollection;
            listaInteger.forEach(System.out::println);
            

        }

    }

}