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


        // // allMatch
        // {
        //     List<String> ls = Arrays.asList("Tom Cruise", "Tom Hart", "Tom Hanks", "Tom Brady");
        //     Predicate<String> p = str -> {
        //         System.out.println("Looking...");
        //         return str.indexOf("Tom") > -1;
        //     };
        //     boolean flag = ls.stream().filter(str -> str.length()>8).allMatch(p);
        //     System.out.println(flag);
        // }


        // {
        //     List<Integer> names = Arrays.asList(1,2,3);
        //     names.forEach(x -> x=x+1);
        //     names.forEach(System.out::println);

        //     List<StringBuilder> namesBuilder = Arrays.asList(new StringBuilder("1"),
        //         new StringBuilder("2"),new StringBuilder("3"));
        //     namesBuilder.forEach(x -> x.append("1"));
        //     namesBuilder.forEach(System.out::println);
        // }


        // // Arrays initializer values
        // {
        //     var str = "111";
        //     boolean[] bA = new boolean[1];
        //     if(bA[0]) str = "222";
        //     System.out.println(str);

        //     char [] cA = new char[2];
        //     int [] iA = new int[2];
        //     float [] fA = new float[2];
        //     System.out.println(Arrays.toString(cA));
        //     System.out.println(Arrays.toString(iA));
        //     System.out.println(Arrays.toString(fA));
        // }


        // // all match, cut circuit
        // {
        //     List<String> values = Arrays.asList("Java EE", "C#", "Python");
        //     boolean flag = values.stream().allMatch(str -> {
        //         System.out.println("Testing: " + str);
        //         return str.equals("Java");
        //     });
        //     System.out.println(flag);
        // }


        // // Random Stream methods
        // {
        //     new Random().doubles(10).forEach(System.out::println);
        //     Random r = new Random();
        //     DoubleStream.generate(() -> r.nextDouble()).limit(10)
        //         .forEach(System.out::println);
        //     Random r = new Random();
        //     DoubleStream.iterate(r.nextDouble(), (d) -> r.nextDouble()).limit(10)
        //         .forEach(System.out::println);
        // }


        // // groupingBy
        // {
        //     class Student {
        //         public static enum Grade { A, B, C, D, F}

        //         private String name;
        //         private Grade grade;
        //         public Student(String name, Grade grade) {
        //             this.name = name;
        //             this.grade = grade;
        //         }
        //         public String toString() {
        //             return name + ":" + grade;
        //         }

        //         public String getName(){
        //             return this.name;
        //         }
        //         public Grade getGrade() {
        //             return this.grade;
        //         }
        //     }

        //     List<Student> ls = Arrays.asList(new Student("S1", Student.Grade.A),
        //         new Student("S2", Student.Grade.A),
        //         new Student("S3", Student.Grade.C));

        //     Map<Student.Grade, List<String>> grouping = ls.stream()
        //         .collect(Collectors.groupingBy(s -> s.getGrade(), 
        //             Collectors.mapping(s1 -> s1.getName(), Collectors.toList())));
        //     System.out.println(grouping);

        //     Map<Student.Grade, List<String>> listStringName = ls.stream()
        //         .collect(() -> new HashMap<Student.Grade, List<String>>(), 
        //             (map, s) -> {
        //                 if(map.containsKey(s.getGrade())) {
        //                     List<String> val = map.get(s.getGrade());
        //                     val.add(s.getName());
        //                     map.put(s.getGrade(), val);
        //                 } else {
        //                     map.put(s.getGrade(), new ArrayList<String>(Arrays.asList(s.getName()))); 
        //                 }
        //             }, 
        //             (map1, map2) -> {});
        //     System.out.println(listStringName);
        // }


        // {
        //     List<Double> dList = Arrays.asList(10.0, 12.0);
        //     DoubleFunction df = x -> x + 10;
        //     // dList.stream().forEach(df); // not compile
        //     // dList.stream().forEach(x -> x+10);  // not compile
        //     dList.stream().forEach(System.out::println);
        // }


        // // parallel stream reduce
        // {
        //     List<String> vals = Arrays.asList("a", "b");
        //     String join = vals.parallelStream()
        //         .reduce("-", (a, b) -> {
        //             System.out.println(a + " " + b);
        //             return a.concat(b);});  // always returns in order
        //     System.out.println(join);
        // }


        // // takeWhile
        // {
        //     IntStream is = IntStream.range(2,6);
        //     // IntStream is2 = is.dropWhile(x -> x%2 == 0);    // this drops elements while predicate is true
        //     IntStream is2 = is.takeWhile(x -> x%2 == 0);    // this takes elements while predicate is true
        //     is2.forEach(System.out::print);

        //     // var i = new Integer[]{1,2,3,4,5};
        //     // Arrays.stream(i)
        //     //     .peek(System.out::print)
        //     //     .map(m->m)
        //     //     .forEach(System.out::println);
        // }


        // // DoubleStream DoubleUnaryOperator
        // {
        //     DoubleStream ds = DoubleStream.of(1.0, 2.0, 3.0);
        //     DoubleFunction<DoubleUnaryOperator> doubleF = m -> (n -> m+n);
        //     ds.map(doubleF.apply(5.0)).forEach(System.out::println);
        // }


        // Queue
        {
            class Person {
                private String name;
                public Person(String name) {this.name = name;}
                public String getName() {return name;}
                public void setName(String name) {this.name = name;}

                public String toString() {return name;}
            }

            class Helper {
                public void helpPeople(Queue people, Queue helped) {
                    do {
                        Person p = (Person) people.poll();
                        System.out.println("Helped : " + p + " ");
                        helped.offer(p.getName());
                    } while (!people.isEmpty());
                }
            }

            Queue<Person> q = new LinkedList<Person>();
            q.offer(new Person("Pope"));
            q.offer(new Person("John"));
            System.out.println(q);

            Queue<Person> helpedQ = new LinkedList<Person>();
            Helper h = new Helper();
            h.helpPeople(q, helpedQ);
        }


    }
}