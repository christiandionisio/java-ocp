import java.util.stream.*;
import java.util.*;
import java.util.function.*;
import java.util.concurrent.*;

public class StreamPractice {
    public static void main(String ...atgs) {

        // // InStream get average
        // {
        //     var nums = IntStream.range(1,5);

        //     // double average = nums.boxed().collect(Collectors.averagingInt(i -> i));
        //     // double average = nums.mapToObj(i->i).collect(Collectors.averagingInt(i -> i));
        //     // double average = nums.average().getAsDouble();
        //     // double average = nums.parallel().mapToLong(i->i).average().getAsDouble();
        //     double average = nums.summaryStatistics().getAverage();
        //     System.out.println(average);
        // }

        // // Comparable and Comparator 
        // {
        //     interface Test {}
        //     class A implements Comparable<A>, Test {
        //         String fieldString;
        //         Integer i;

        //         public A(String fieldString, Integer i) {
        //             this.fieldString = fieldString;
        //             this.i = i;
        //         }

        //         public int compareTo(A input) {
        //             return fieldString.compareTo(input.fieldString);
        //         }

        //         public String toString() {
        //             return "{fieldString: " + fieldString + ", i: " + i + " }";
        //         }
        //     }

        //     List<A> listA = Arrays.asList(new A("f", 2), new A("c", 4), 
        //         new A("m", 1), new A("a", 10));
        //     // Collections.sort(listA);    // needs to implement Comparable interface
        //     // Collections.sort(listA, (o1, o2) -> o1.i - o2.i);   // second parameter must be interface Comparator
        //     // Collections.sort(listA, Comparator.comparing(a -> a.i));
        //     Collections.sort(listA, Comparator.comparing((A a) -> a.i).reversed());
        //     // Collections.sort(listA, Comparator.naturalOrder()); // orders according to compareTo from a Comparable class needs to implements
        //     System.out.println(listA.toString());
        // }

        // // groupingBy
        // {
        //     Stream<String> ss = Stream.of("a","b","a","b","c","b");
        //     Map<String, Long> data = ss.collect(Collectors.groupingBy(Function.identity(), 
        //         Collectors.counting()));
        //     System.out.println(data);
        // }

        // // List.of, Arrays.asList, Collections.unmodifiable***
        // {
        //     var numA = new Integer[]{1, 5, 3};
        //     // var numA = new Integer[]{1, null, 3};   // this will not compile whit List.of, but compiles with Arrays.asList
        //     var list1 = List.of(numA);  // List.of and copyOf don't support null elements, NullPointerExcetion
        //     // var list1 = Arrays.asList(numA); 
        //     var list2 = Collections.unmodifiableList(list1);    // the view returned may be change if ypu change the original list
        //     numA[1] = 2;
        //     // list1.set(1, 100);
        //     System.out.println(list1 + " " + list2);    // [1,5,3] [1,5,3]
        // }


        // // Functional Interfaces        
        // {
        //     class TestClass {
        //         public double proccess(double payment, int rate) {
        //             double defaultRate = 0.10;
        //             // if(rate>10) defaultRate = rate;     // defaultRate must be effectively final

        //             class Implement {
        //                 public int apply(double data) {
        //                     Function<Integer, Integer> f = x -> x + (int)(x*defaultRate);
        //                     // Function<Integer, Integer> f = x -> x + (int)(x*rate);   // compiles
        //                     return f.apply((int) data);
        //                 }
        //             }

        //             Implement i = new Implement();
        //             return i.apply(payment);
        //         }
        //     }
        // }


        // // TreeSet, subset method
        // {
        //     TreeSet<Integer> s = new TreeSet<Integer>();
        //     TreeSet<Integer> subs = new TreeSet<Integer>();

        //     for(int i = 324; i<=328; i++) {
        //         s.add(i);
        //     }

        //     subs = (TreeSet) s.subSet(326, true, 328, true);    // view that can modify the collection, 
        //                                                         //the changes will be applied to subset and the original collection
        //     // System.out.println(subs);
        //     // subs.add(329);      // IllegalArgumentException: key out of range
        //     System.out.println(s + " " + subs);
        // }


        // // reduce, IntStream
        // {
        //     IntStream is = IntStream.rangeClosed(1,4);
        //     int sum = is.reduce(0, (a,b) -> a+b);   // this will return an int because reduce(idValue, IntBynaryOp)
        //     System.out.println(sum);
        // }
        // {
        //     IntStream is = IntStream.range(1,5);
        //     OptionalInt sum = is.reduce((a,b) -> a+b);
        //     System.out.println(sum.getAsInt());
        //     System.out.println(sum.orElse(0));
        // }
        // {
        //     // Stream<int> si = Stream.of(1,2,3,4);     // will not compile with primitives
        //     Stream<Integer> si = Stream.of(1,2,3,4);
        //     Optional<Integer> sum = si.reduce((a,b) -> a+b);
        //     System.out.println(sum.get());
        // }


        // // Stream takeWhile()
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

        //     Arrays.stream(Card.values()).takeWhile(c -> c.isRed())  // takeWhile takes elements that match with predicate, as soon as predicate returns false testing is stopped and return the result
        //         .forEach(System.out::print);
        // }


        // // Arrays Unsuported operation
        // {
        //     class Data {
        //         int value;
        //         Data (int value) {
        //             this.value = value;
        //         }
        //         public String toString() {return "" + value;}
        //     }

        //     Data[] dataArr = new Data[]{ new Data(1),
        //         new Data(2), new Data(3), new Data(4)};

        //     List<Data> dataList = Arrays.asList(dataArr);
        //     // List<Data> dataList = new CopyOnWriteArrayList(Arrays.asList(dataArr));  // with this would compile

        //     for(Data element: dataList) {
        //         dataList.removeIf((Data d) -> {return d.value%2 == 0;});    // java.lang.UnsupportedOperationException
        //         // System.out.println("Removed " + d + ", ");
        //         // System.out.println("dataListFinal " + dataList);
        //     }
        // }


        // // Collectors toMap(Function, Function, merge)
        // {
        //     class Book {
        //         private String title;
        //         private Double price;
        //         public Book(String title, Double price) {
        //             this.title=title;
        //             this.price=price;
        //         }
        //         public String getTitle() {
        //             return this.title;
        //         }

        //         public Double getPrice() {
        //             return this.price;
        //         }
        //     }

        //     List<Book> books = Arrays.asList(new Book("Gone with the wind", 5.0),
        //         new Book("Gone with the wind", 10.0),
        //         new Book("Atlas Shrugged", 15.0)
        //     );

        //     // books.stream().collect(Collectors.toMap((b -> b.getTitle()), b -> b.getPrice()))    // no compile, this needs to merge
        //     //     .forEach((a,b) -> System.out.println(a + " " + b));

        //     books.stream().collect(Collectors.toMap((b -> b.getTitle()), b -> b.getPrice(), (v1, v2) -> v1 + v2))
        //         .forEach((a,b) -> System.out.println(a + " " + b));
        // }
        // {
        //     var tickers = List.of("A", "D", "E", "C", "A");
        //     var ratio = List.of(1.0, 1.2, 1.5, 1.8, 2.0);
        //     var map1 = IntStream.range(0, tickers.size())
        //         .boxed()
        //         .collect(Collectors.toMap(i -> tickers.get(i),
        //             i -> 1.0/ratio.get(i), (x,y) -> x+y));
            
        //     // var map2 = map1.entrySet().stream().sorted(Map.Entry.comparingByKey(String::compareTo))      //compiles
        //     // var map2 = map1.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey()))      // compiles
        //     // var map2 = map1.entrySet().stream().sorted(Map.Entry.comparingByValue())        // compiles
        //     var map2 = map1.entrySet().stream().sorted(Map.Entry.comparingByKey())
        //         .collect(
        //             Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
        //                 (x,y) -> x-y, LinkedHashMap::new)
        //         );
            
        //     map2.forEach((var k, var v) -> System.out.printf("%s = %.2f\n", k, v));
        // }


        // // ForEach StringBuilder
        // {
        //     List<StringBuilder> messages = Arrays.asList(new StringBuilder(), new StringBuilder());
        //     messages.stream().forEach(s -> s.append("helloworld"));
        //     messages.forEach(s -> {
        //         s.insert(5, ",");
        //         System.out.println(s);
        //     });
        // }


        // allMatch
        {
            List<String> ls = Arrays.asList("Tom Cruise", "Tom Hart", "Tom Hanks", "Tom Brady");
            Predicate<String> p = str -> {
                System.out.println("Looking...");
                return str.indexOf("Tom") > -1;
            };
            boolean flag = ls.stream().filter(str -> str.length()>8).allMatch(p);
            System.out.println(flag);
        }

    }
}