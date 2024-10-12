import java.util.stream.*;
import java.util.*;
import java.util.function.*;

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

        // groupingBy
        {
            Stream<String> ss = Stream.of("a","b","a","b","c","b");
            Map<String, Long> data = ss.collect(Collectors.groupingBy(Function.identity(), 
                Collectors.counting()));
            System.out.println(data);
        }

    }
}