import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

public class ParallelStreams {

    public static void main(String ...args) {

        // {
        //     long start = System.currentTimeMillis();
        //     List.of(1,2,3,4,5)
        //         // .stream()
        //         .parallelStream()
        //         .map(w -> doWork(w))
        //         // .forEachOrdered(s -> System.out.print(s + " ")); // Orders the output
        //         .forEachOrdered(s -> System.out.print(s + " "));
            
        //     System.out.println();
        //     var timeTaken = (System.currentTimeMillis()-start)/1000;
        //     System.out.println("Time: "+timeTaken+" seconds");
        // }

        
        // reducee combiner
        // {
        //     System.out.println(List.of('w', 'o', 'l', 'f')
        //         .parallelStream()
        //         .reduce("",
        //             (s1,c) -> s1 + c, //    'w' + 'o' + ...
        //             (s2,s3) -> s2 + s3)); // "wo" + "lf' combines results with parallel stream

        //     System.out.println(List.of(1,2,3,4,5,6)
        //         .parallelStream()
        //         .reduce(0, (a, b) -> (a - b))); // PROBLEMATIC ACCUMULATOR

        //     System.out.println(List.of("w","o","l","f")
        //         .parallelStream()
        //         .reduce("X", String::concat)); // XwXoXlXf
        // }


        {
            Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
            SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new,
                Set::add,
                Set::addAll);
            System.out.println(set);  // [f, l, o, W]
        }




    }

    private static int doWork(int input) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        return input;
    }

}