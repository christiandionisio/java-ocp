import java.time.*;
import java.time.format.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.Serializable;
import java.io.*;

public class Practice {

    public static void main(String ...args) throws Exception {


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

        //     // the long way
        //     Map<String, Long> countsManual = wordStream.collect(
        //         () -> {
        //             Map<String, Long> map = new HashMap<>();
        //             return map;
        //         },
        //         (map, s) -> {
        //             if(map.get(s) == null) {
        //                 map.put(s, 1L);
        //             } else {
        //                 map.put(s, map.get(s) + 1L);
        //             }
        //         },
        //         (map1, map2) -> {
        //             // when there are multithreading executing
        //             // this do nothing
        //             System.out.println("Map1: " + map1);
        //             System.out.println("Map2: " + map2);
        //         }
        //     );
        //     System.out.println(counts);
        // }


        // {
        //     List<Integer> ls = Arrays.asList(10,47,33,23);
        //     // int max = ls.stream().max(Comparator.comparing(a->a)).get();
        //     // int max = ls.stream().max((a, b) -> a-b).get();
        //     int max = ls.stream().max(Comparator.comparing(Function.identity())).get();
        //     // int max = ls.stream().reduce((a, b) -> (a>b) ? a : b).get();
        //     System.out.println(max);
        // }

        // {
        //     List<Movie> movies = Arrays.asList(
        //         new Movie("Titanic", Movie.Genre.DRAMA, 'U'),
        //         new Movie("Psycho", Movie.Genre.THRILLER, 'U'),
        //         new Movie("Oldboy", Movie.Genre.THRILLER, 'R'),
        //         new Movie("Shining", Movie.Genre.HORROR, 'U')
        //     );

        //     movies.stream()
        //         .filter(mov -> mov.getRating() == 'R')
        //         .peek(mov -> System.out.println(mov.getName()))
        //         .map(mov -> mov.getName());
        //         // .findAny();  // terminal operations is mandatory to execute intermediate operations
        // }

        // {
        //     A a = new A();
        //     a.start();
        //     Thread.sleep(1000);
        //     a.interrupt();
        // }

        // {
        //     // var ia[][] = {{1,2}, null}; // not allowed as an element type of an array
        //     var ia = new int[][]{{1,2}, null};
        //     for(int i = 0; i<2; i++)
        //         for(int j = 0; j<2; j++)
        //             System.out.println(ia[i][j]);
        // }

        // {
        //     System.out.println(Sub.ID);
        //     // Sub sub = new Sub();
        // }

        // {
        //     TestClass testClass = new TestClass();
        //     testClass.m1();
        // }

        // {
        //     List<String> vowels = new ArrayList<String>(); 
        //     vowels.add("a"); 
        //     vowels.add("e"); 
        //     vowels.add("i"); 
        //     vowels.add("o"); 
        //     vowels.add("u"); 
            
        //     Function<List<String>, List<String>> f = list->list.subList(2, 4); 
        //     List<String> view = f.apply(vowels); 
        //     // view.add(1, "x");   // this modify view and vowels lists
        //     vowels.forEach(System.out::print); 
        // }

        // {
        //     String sentence = "Life is a box of chocolates, Forrest. You never know what you're gonna get.";

        //     boolean theWord = Stream.of(sentence.split("[ ,.]"))
        //         .peek(System.out::println)
        //         .anyMatch(w -> w.startsWith("g"));
        //     System.out.println(theWord);
        // }

        // {
        //     char [] a = {'h', 'e', 'l', 'l'};
        //     char [] b = {'h', 'f'};

        //     int x = Arrays.compare(a, b);
        //     int y = Arrays.mismatch(a, b);
        //     System.out.println(x + " " + y);
        // }


        // {
        //     short a = (short)(Short.MAX_VALUE + 2);
        //     System.out.println(a);

        //     int b = (int)(Integer.MAX_VALUE + 1);
        //     System.out.println(b);

        //     long c = (int)(2.8 + 1);
        //     System.out.println(c);

        //     double d = (long)(2.8 + 1L);
        //     System.out.println(d);

        //     short mouse = 10;
        //     short hamster = 3;
        //     // short capybara = mouse * hamster;   // no comile
        //     short capybara = (short)(mouse * hamster);

        //     byte hat = 1;
        //     // final byte hat = 1;  // compiles if hat is final
        //     // short boots2 = 2 + hat; // not compile

        //     int camel = 2, giraffe = 3;
        //     camel = camel * giraffe;
        //     camel *= giraffe;

        //     float goat = 10;
        //     int sheep = 5;      
        //     // sheep = sheep * goat;   // Not compile
        //     sheep *= goat;  // cast automatically sheep to long, then casts the answer to int

            
        // }

        // // Comparing values
        // {
        //     System.out.println("===================");
        //     System.out.println("Comparing values");
        //     System.out.println("===================");
        //     boolean polar = "string" == "String";
        //     System.out.println(polar);

        //     // var monday = new File("schedule.txt");
        //     // var tuesday = new File("schedule.txt");
        //     // var wednesday = tuesday;
        //     // System.out.println(monday == tuesday);      //false
        //     // System.out.println(tuesday == wednesday);   //true

        //     Integer zooTime = Integer.valueOf(9);
        //     Number num = zooTime;
        //     // Integer inte = num; // not compile


        //     System.out.println(null instanceof Object);         //false
        //     Object noObjectHere = null;
        //     System.out.println(noObjectHere instanceof String); //false
        // }


        // // Logic operators
        // {
        //     System.out.println("===================");
        //     System.out.println("Logic operators");
        //     System.out.println("===================");

        //     boolean eyesClose = true;
        //     boolean breathingSlowly = true;

        //     boolean resting = eyesClose | breathingSlowly;
        //     boolean asleep = eyesClose & breathingSlowly;
        //     boolean awake = eyesClose ^ breathingSlowly;

        //     System.out.println(resting);
        //     System.out.println(asleep);
        //     System.out.println(awake);


        //     int hour = 10;
        //     boolean zooOpen = true || (--hour<4);
        //     System.out.println(zooOpen);    //true
        //     System.out.println(hour);       //10


        //     int rabbit = 6;
        //     boolean bunny = (rabbit>=6) || (++rabbit<=7);   // second operator doesn't execute
        //     System.out.println(rabbit);

        //     int stripes = 7;
        //     System.out.println(stripes > 5 ? 21 : "Zebra");
        //     System.out.println(stripes > 5 ? 100 : 'Z');
        //     // int animal = stripes > 5 ? 21 : "Zebra";    // not compile
        //     var t = stripes > 5 ? 21 : "Zebra";

        //     int sheep = 1;
        //     int zzz = 1;
        //     int sleep = zzz<10 ? sheep++ : zzz++;
        //     System.out.println(sheep + ", " + zzz); // "2, 1"
        // }


        // {
        //     // var values = new ArrayList<String>();
        //     var values = Arrays.asList("alemania", "rusia", "belgica");
        //     values.sort((a,b) -> a.compareTo(b));
        //     values.forEach(System.out::println);
        // }

        // {
        //     class Base {
        //         public List<CharSequence> transform(Set<CharSequence> list) {
        //             // valid code
        //             return new ArrayList<CharSequence>();
        //         }
        //     }

        //     class Derived extends Base {
        //         // @Override
        //         // public List transform(Set list) {   // valid
        //         //     return new ArrayList<String>();
        //         // }

        //         // public List<String> transform(TreeSet<String> list) {   // valid overload
        //         //     return new ArrayList<String>();
        //         // }

        //         // @Override
        //         // public ArrayList<CharSequence> transform(Set<CharSequence> list) {   // valid
        //         //     return new ArrayList<CharSequence>();
        //         // }
        //     }
        // }


        // {
        //     String [] sa = {"charlie", "bob", "andy", "dave"};
        //     Arrays.sort(sa);
        //     System.out.println(Arrays.toString(sa));
        //     System.out.println(Arrays.binarySearch(sa, "charlie"));
        // }


        // {
        //     class A {
        //         A() {print();}
        //         void print() {System.out.print("A ");}
        //     }

        //     class B extends A {
        //         int i = 4;
        //         void print() {System.out.print(i+" ");}
        //     }

        //     A a = new B();
        //     a.print();
        // }

        // {
        //     Stream.of("alemania", "alemania", "polonia", "rusia", "rusia")
        //         .distinct()
        //         .forEach(System.out::println);
        // }

        // {
        //     enum Card {
        //         HEART, CLUB, SPADE, DIAMOND;
        //         public boolean isRed() {
        //             return switch(this) {
        //                 case HEART, DIAMOND -> true;
        //                 default -> false;
        //             };
        //         }
        //     }

        //     Arrays.stream(Card.values())
        //         // .peek(System.out::println)
        //         .dropWhile(Card::isRed)
        //         .forEach(System.out::println);
        //     switch(Card.valueOf("HEART")) {
        //         case HEART -> System.out.println("heart");
        //         case CLUB -> System.out.println("club");
        //         case SPADE -> System.out.println("spade");
        //         case DIAMOND -> System.out.println("diamond");
        //         default -> System.out.println("unknown");
        //     }
        // }


        // {
        //     class Booby {
        //         int i;
        //         public Booby() { i = 10; System.out.print("Booby ");}
        //     }

        //     class Dooby extends Booby implements Serializable {
        //         int j;
        //         public Dooby() { j = 20; System.out.print("Dooby ");}
        //     }

        //     class Tooby extends Dooby {
        //         int k;
        //         public Tooby() { k = 30; System.out.print("Tooby ");}
        //     }

        //     var t = new Tooby();
        //     t.i = 100;

        //     var oos = new ObjectOutputStream(new FileOutputStream("./test.txt"));
        //     oos.writeObject(t); oos.close();

        //     var ois = new ObjectInputStream(new FileInputStream("./test.txt"));
        //     t = (Tooby) ois.readObject(); ois.close();

        //     System.out.println(t.i + " " + t.j + " " + t.k);
        // }

        // {
        //     Map<Integer, String> map = new HashMap<>();
        //     map.put(1, "hola");
        //     map.put(2, "mundo");
        //     System.out.println();
        //     map.entrySet().forEach(System.out::println);

        // }

        // {
        //     class A {
        //         public List<? super Integer> getList() {
        //             return new ArrayList<Number>();
        //         }
        //     }

        //     class B extends A {
        //         @Override
        //         public List<? super Number> getList() {     // valid
        //             return new ArrayList<Number>();
        //         }
        //     }
        // }

        // {
        //     interface FI {
        //         void m1();
        //         boolean equals(Object o);   // no need to implement 'cause is in OBject class
        //         String toString();          // no need to implement 'cause is in OBject class
        //     }

        //     class A implements FI {
        //         public void m1() {}
        //         public boolean equals(Object o) {return true;}
        //     }
        // }


        {
            try {
                int i = 0;
                i = Integer.parseInt(args[0]);  // 1_00 will throw NumberFormatException
            } catch(NumberFormatException e) {
                System.out.println("Problem in");
            }
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

// class A { int i = 10;  int m1( ) { System.out.println("class A"); return i; } } 
// class B extends A { int i = 20;  int m1() { System.out.println("class B"); return i; } } 
// class C extends B { int i = 30;  int m1() { System.out.println("class C"); return i; } }

class Movie {
    static enum Genre {DRAMA, THRILLER, HORROR, ACTION};
    private Genre genre;
    private String name;
    private char rating = 'R';
    Movie(String name, Genre genre, char rating) {
        this.name = name; this.genre = genre; this.rating = rating;
    }

    public String getName() {
        return this.name;
    }

    public char getRating() {
        return this.rating;
    }
}

class A extends Thread {
    // volatile boolean flag = true; // making volatile this variable will be visible to all threads
    boolean flag = true; 

    public void run() {
        System.out.println("Starting loop");

        while(!isInterrupted()){};

        System.out.println("Ending loop");
    }
}

class Super { 
    static String ID = "QBANK"; 
    // static {System.out.print("In Super");}
}
class Sub extends Super {
    // static String ID = "IDSUB";
    static {System.out.print("In sub");}
}

interface T1 {
    int VALUE = 1;
    void m1();
    default void m2() {}
}

interface T2 {
    int VALUE = 2;
    void m1();
    default void m2() {}
}

class TestClass implements T1, T2 {
    public void m1(){}
    public void m2(){} // without this implementation it will be an error
}

