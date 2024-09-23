import java.time.*;
import java.time.format.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Practice {

    public static void main(String ...args) {


        // {
        //     HELLO: for(int i = 0; i<10; i++) {
        //         JACK: System.out.println("HOla");
        //         WORLD: while(i < 5) {
        //             if(i == 2) continue HELLO; else System.out.println("ELSE");
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
        
        // // Type erasure
        // {
        //     List<String> listaString = new ArrayList<>();
        //     listaString.add("dummy");

        //     List<Integer> listaInteger = new ArrayList<>();
        //     listaInteger.add(1);

        //     List listaRawCollection = new ArrayList();
        //     listaRawCollection = listaInteger;
        //     listaRawCollection.add(2);
        //     // listaRawCollection = listaInteger;
        //     // listaRawCollection.forEach(System.out::println);

        //     listaInteger = listaRawCollection;
        //     listaInteger.forEach(System.out::println);
            

        // }

        // {
        //     System.out.println(Practice.NestedClass.varStatic);
        //     Practice.NestedClass.methodStatic();
            
        //     Practice.NestedClass a = new Practice.NestedClass();
        //     a.nonStaticMethod();
        //     a.methodStatic();


        //     System.out.println(Practice.InnerClass.varInnerStatic);
        //     Practice.InnerClass.innerMethodStatic();
            
        //     Practice.InnerClass innerInstance = new Practice().new InnerClass();
        //     innerInstance.innnerMethod();
        //     innerInstance.innerMethodStatic();


        // }


        // {
        //     Float f1 = 10.0f;
        //     Float f2 = 0.0f;
        //     Float f3 = null;

        //     double f = 0.0;

        //     try {
        //         f = f1/f2;  // Float.POSITIVE_INFINITY
        //         System.out.println(f);
        //         f3 = f1/f2;
        //     } catch(Exception e) {
        //         System.out.println("Exception");
        //     }

        //     System.out.println(f3.isInfinite());
        // }

        // {
        //     A ac = new C();
        //     B bc = (B) ac;
        //     A a = new A();
        //     // B ba = (B) a;   // ClassCastException 

        //     System.out.println(ac.m1());    // 30
        //     System.out.println(ac.i);       // 10
        //     System.out.println(bc.i);       // 20
        //     System.out.println(bc.m1());    // 30
        //     System.out.println(a.m1());     // 10
        // }


        // {
        //     Stream<String> wordStream = Stream.of("word1", "word2", "word3",
        //         "word2", "word2", "word3","word1", "word1", "word1",
        //         "word4", "word5", "word3", "word3", "word2", "word3");

        //     Map<String, Long> counts = wordStream.collect(
        //         Collectors.groupingBy(s -> s,Collectors.counting()
        //     ));

        //     // // the long way
        //     // Map<String, Long> countsManual = wordStream.collect(
        //     //     () -> {
        //     //         Map<String, Long> map = new HashMap<>();
        //     //         return map;
        //     //     },
        //     //     (map, s) -> {
        //     //         if(map.get(s) == null) {
        //     //             map.put(s, 1L);
        //     //         } else {
        //     //             map.put(s, map.get(s) + 1L);
        //     //         }
        //     //     },
        //     //     (map1, map2) -> {
        //     //         // when there are multithreading executing
        //     //         // this do nothing
        //     //         System.out.println("Map1: " + map1);
        //     //         System.out.println("Map2: " + map2);
        //     //     }
        //     // );
        //     System.out.println(counts);
        // }


        {
            List<Integer> ls = Arrays.asList(10,47,33,23);
            // int max = ls.stream().max(Comparator.comparing(a->a)).get();
            // int max = ls.stream().max((a, b) -> a-b).get();
            int max = ls.stream().max(Comparator.comparing(Function.identity())).get();
            // int max = ls.stream().reduce((a, b) -> (a>b) ? a : b).get();
            System.out.println(max);
        }

    }

    static public class NestedClass {
        String var1 = "hello";
        static String varStatic = "hello static";

        void nonStaticMethod() {
            System.out.println("noStaticMethod");
        }

        static void methodStatic() {
            System.out.println("staticMethod");
        }
    }

    class InnerClass {

        static String varInnerStatic = "variable inner static";

        void innnerMethod() {
            System.out.println("innerMethod");
        }

        static void innerMethodStatic() {
            System.out.println("innerMethodStatic");
        }

    }

}

class A { int i = 10;  int m1( ) { System.out.println("class A"); return i; } } 
class B extends A { int i = 20;  int m1() { System.out.println("class B"); return i; } } 
class C extends B { int i = 30;  int m1() { System.out.println("class C"); return i; } }
