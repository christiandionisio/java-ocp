import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Spliterator;
import java.util.Optional;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BinaryOperator;

public class HandlingStreams { 

    public static void main(String ...args) {

        // // it will generate a stream with infinite values
        // Stream<Double> randoms = Stream.generate(Math::random);
        // Stream<Integer> oddNumbers = Stream.iterate(1, n -> n +  2);
        // // it will generate a finite stream 'cause the second parameter is a condition'
        // Stream<Integer> oddNumbersUnder100 = Stream.iterate(1, n -> n < 100, n -> n +  2);

        // // randoms.forEach(value -> System.out.println(value));
        // // oddNumbers.forEach(System.out::println);
        // // oddNumbersUnder100.forEach(System.out::println);

        // // Counting is a method reduction
        // {
        //     Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        //     System.out.println(s.count()); // 3
        // }

        // // Min and max method are also reduction
        // {
        //     Stream<String> s = Stream.of("monkey", "ape", "bonobo");
        //     Optional<String> min = s.min((s1, s2) -> s1.length()-s2.length());
        //     min.ifPresent(System.out::println); // ape
        // }
        //  {
        //     Stream<String> s = Stream.of("monkey", "ape", "bonobo");
        //     Optional<String> max = s.max((s1, s2) -> s1.length()-s2.length());
        //     max.ifPresent(System.out::println); // ape
        // }

        // // findAny and findFirst methods are not reductions because they don't process all the elements of a streams
        // {
        //     Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        //     Stream<String> infinite = Stream.generate(() -> "chimp");
            
        //     s.findAny().ifPresent(System.out::println); // monkey (usually)
        //     infinite.findAny().ifPresent(System.out::println); // chimp
        // }

        // // Matching methods also are not reductions methods
        // {
        //     var list = List.of("monkey", "2", "chimp");
        //     Stream<String> infinite = Stream.generate(() -> "chimp");
        //     Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
            
        //     System.out.println(list.stream().anyMatch(pred));   // true
        //     System.out.println(list.stream().allMatch(pred));   // false
        //     System.out.println(list.stream().noneMatch(pred));  // false
        //     System.out.println(infinite.anyMatch(pred));        // true
        // }

        // // the reduce method is a reduction because it processes all elements
        // {
        //     Stream<String> stream = Stream.of("w", "o", "l", "f");
        //     // String word = stream.reduce("", (s, c) -> s + c);
        //     String word = stream.reduce("", String::concat);
        //     System.out.println(word); // wolf

        //     Stream<Integer> streamInteger = Stream.of(3, 5, 6);
        //     System.out.println(streamInteger.reduce(1, (a, b) -> a*b)); // 90

        //     BinaryOperator<Integer> op = (a, b) -> a * b;
        //     Stream<Integer> empty = Stream.empty();
        //     Stream<Integer> oneElement = Stream.of(3);
        //     Stream<Integer> threeElements = Stream.of(3, 5, 6);
            
        //     empty.reduce(op).ifPresent(System.out::println);         // no output
        //     oneElement.reduce(op).ifPresent(System.out::println);    // 3
        //     threeElements.reduce(op).ifPresent(System.out::println); // 90

        //     Stream<String> stream2 = Stream.of("w", "o", "l", "f!");
        //     int length = stream2.reduce(0, (i, s) -> i+s.length(), (a, b) -> a+b);
        //     System.out.println(length); // 5
        // }

        // // Collect is similar to reduce
        // {
        //     Stream<String> stream = Stream.of("w", "o", "l", "f");
        //     StringBuilder word = stream.collect(
        //         StringBuilder::new,
        //         StringBuilder::append,
        //         StringBuilder::append);
            
        //     System.out.println(word); // wolf
        // }
        // {
        //     Stream<String> stream = Stream.of("w", "o", "l", "f");
 
        //     TreeSet<String> set = stream.collect(
        //         TreeSet::new,
        //         TreeSet::add,
        //         TreeSet::addAll);
            
        //     System.out.println(set); // [f, l, o, w]
        // }

        // // limit and skip methods
        // {
        //     Stream<Integer> s = Stream.iterate(1, n -> n + 1);
        //     s.skip(5)
        //         .limit(2)
        //         .forEach(System.out::print); // 67
        //     System.out.println();
        // }

        // // Spliteator
        // {
        //     var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-", "mouse-");
        //     Spliterator<String> originalBagOfFood = stream.spliterator();
        //     Spliterator<String> emmasBag = originalBagOfFood.trySplit();
        //     emmasBag.forEachRemaining(System.out::print);  // bird-bunny-cat-
        //     System.out.println();
            
        //     Spliterator<String> jillsBag = originalBagOfFood.trySplit();
        //     jillsBag.tryAdvance(System.out::print);        // dog-
        //     jillsBag.forEachRemaining(System.out::print);  // fish-
        //     System.out.println();
            
        //     originalBagOfFood.forEachRemaining(System.out::print); // lamb-mouse-
        //     System.out.println();
        // }

        // // Collectors
        // {
        //     var ohMy = Stream.of("lions", "tigers", "bears");
        //     TreeSet<String> result = ohMy
        //         .filter(s -> s.startsWith("t"))
        //         .collect(Collectors.toCollection(TreeSet::new));
        //     System.out.println(result); // [tigers]
        // }

        // // Colletiong into maps
        // {
        //     var ohMy = Stream.of("lions", "tigers", "bears");
        //     Map<String, Integer> map = ohMy.collect(
        //         // Collectors.toMap(s -> s, String::length));
        //         Collectors.toMap(String::toString, String::length));
        //     System.out.println(map); // {lions=5, bears=5, tigers=6}
        // }
        // {
        //     var ohMy = Stream.of("lions", "tigers", "bears", "perro");
        //     Map<Integer, String> map = ohMy.collect(Collectors.toMap(
        //         String::length,
        //         k -> k,
        //         (s1, s2) -> s1 + "," + s2)); // merge applies only for duplicated keys
        //     System.out.println(map);            // {5=lions,bears, 6=tigers}
        //     System.out.println(map.getClass()); // class java.util.HashMap
        // }
        // {
        //     var ohMy = Stream.of("lions", "tigers", "bears");
        //     Map<Integer, String> map = ohMy.collect(Collectors.toMap(
        //         String::length,
        //         k -> k,
        //         (s1, s2) -> s1 + "," + s2,
        //         TreeMap::new)); // you can define the ouput class
        //     System.out.println(map); // {5=lions,bears, 6=tigers}
        //     System.out.println(map.getClass()); // class java.util.TreeMap
        // }

        // // groupingBy()
        // {
        //    var ohMy = Stream.of("lions", "tigers", "bears");
        //     Map<Integer, List<String>> map = ohMy.collect(
        //         Collectors.groupingBy(String::length));
        //     System.out.println(map);    // {5=[lions, bears], 6=[tigers]} 
        // }
        // {
        //     var ohMy = Stream.of("lions", "tigers", "bears");
        //     Map<Integer, Set<String>> map = ohMy.collect(
        //         Collectors.groupingBy(
        //             String::length,
        //             Collectors.toSet()));   // you can define the value output class
        //     System.out.println(map);    // {5=[lions, bears], 6=[tigers]}
        // }
        // {
        //     var ohMy = Stream.of("lions", "tigers", "bears");
        //     TreeMap<Integer, Set<String>> map = ohMy.collect(
        //         Collectors.groupingBy(
        //             String::length,
        //             TreeMap::new,   // we can change even the type of Map returned
        //             Collectors.toSet()));
        //     System.out.println(map); // {5=[lions, bears], 6=[tigers]}
        // }

        // // partitioningBy()
        // {
        //     var ohMy = Stream.of("lions", "tigers", "bears");
        //     Map<Boolean, List<String>> map = ohMy.collect(
        //         Collectors.partitioningBy(s -> s.length() <= 5));
        //     System.out.println(map);    // {false=[tigers], true=[lions, bears]}
        // }

        // // mapping()
        // {
        //     var ohMy = Stream.of("lions", "tigers", "bears");
        //     Map<Integer, Optional<Character>> map = ohMy.collect(
        //         Collectors.groupingBy(
        //             String::length,
        //             Collectors.mapping(
        //                 s -> s.charAt(0),
        //                 Collectors.minBy((a, b) -> a - b))));
        //     System.out.println(map);    // {5=Optional[b], 6=Optional[t]}
        // }


        // // Teeing collectors
        // {
        //     record Separations(String spaceSeparated, String commaSeparated) {}

        //     var list = List.of("x", "y", "z");
        //     Separations result = list.stream()
        //         .collect(Collectors.teeing(
        //                     Collectors.joining(" "),
        //                     Collectors.joining(","),
        //                     (s, c) -> new Separations(s, c)));
        //     System.out.println(result);
        // }


        // // Excercises
        // {
        //     System.out.println(Stream.iterate(1, x -> ++x)
        //         .limit(5).map(x -> "" + x)
        //         .collect(Collectors.joining("|")));
        // }

        // {
        //     var spliterator = Stream.generate(() -> "x")
        //         .spliterator();
            
        //     spliterator.forEachRemaining(System.out::println);
        //     spliterator.tryAdvance(System.out::print);  
        //     var split = spliterator.trySplit();
        //     split.tryAdvance(System.out::print);
        // }


        // // Collectors.averaging***()
        // {
        //     var listNumber = Arrays.asList(8.1, 3.1, 4.1, 9.1, 1.1, 4.1);

        //     Double averageDouble = listNumber.stream()
        //         .collect(Collectors.averagingDouble(a -> a));
        //     System.out.println(averageDouble);

        //     Double averageInt = listNumber.stream()
        //         .collect(Collectors.averagingInt(a -> a.intValue()));
        //     System.out.println(averageInt);

        //     Double averageLong = listNumber.stream()
        //         .collect(Collectors.averagingLong(a -> a.longValue()));
        //     System.out.println(averageLong);
        // }


        // // Collectors.collectingAndThen(Collector, Function)
        // {
        //     var listNumber = Arrays.asList(8.1, 3.1, 4.1, 9.1, 1.1, 4.1);
        //     String collected = listNumber.stream()
        //         .collect(Collectors.collectingAndThen(Collectors.counting(),
        //             countingResultCollector -> "Finishing: " + countingResultCollector));
        //     System.out.println(collected);
        // }


        // // Collectors.filtering(Predicate, Collectors)
        // {
        //     var listNumber = Arrays.asList(8.1, 3.1, 4.1, 9.1, 1.1, 4.1);
            
        //     long countedElements = listNumber.stream()
        //         .collect(Collectors.filtering(a -> a > 4, Collectors.counting()));
        //     System.out.println(countedElements);
        // }


    //    //  Collectors.flatMapping(Function, Collectors)
    //     {
    //         var listNumber = Arrays.asList(8.1, 3.1, 4.1, 9.1, 1.1, 4.1);

    //         String numberJoined = listNumber.stream()
    //             .sorted(Double::compare)
    //             .collect(Collectors.flatMapping(a -> Stream.of(String.valueOf(a.intValue())), 
    //                 Collectors.joining("-")));
    //         System.out.println(numberJoined);
    //     }


        // // Collectors.groupingBy
        // {
        //     var listNumber = Arrays.asList(8.1, 3.1, 4.1, 9.1, 1.1, 4.1);
            
        //     Map<String, List<Double>> numbersGrouped = listNumber.stream()
        //         .collect(Collectors.groupingBy(number -> (number > 4) ? "mayorque4": "menorigual4"));
        //     System.out.println(numbersGrouped);

        //     Map<String, Double> averageNumbersGrouped = listNumber.stream()
        //         .collect(Collectors.groupingBy(number -> (number > 4) ? "mayorque4": "menorigual4",
        //                     Collectors.averagingLong(number -> number.longValue())
        //                 )
        //         );
        //     System.out.println(averageNumbersGrouped);

        //     TreeMap<String, Double> averageNumbersGroupedTreeMap = listNumber.stream()
        //         .collect(Collectors.groupingBy(number -> (number > 4) ? "mayorque4": "menorigual4",
        //                     TreeMap::new,
        //                     Collectors.averagingLong(number -> number.longValue())
        //                 )
        //         );
        //     System.out.println(averageNumbersGroupedTreeMap);
    
        // }


        // // Collectors.mapping
        // {
        //     var listNumber = Arrays.asList(8.1, 3.1, 4.1, 9.1, 1.1, 4.1);

        //     String numbersJoined = listNumber.stream()
        //         .collect(Collectors.mapping(n -> String.valueOf(n.intValue()), 
        //             Collectors.joining("-", "[", "]")));
        //     System.out.println(numbersJoined);
        // }


        // // Collectors.maxBy and Collectors.minBy
        // {
        //     var listNumber = Arrays.asList(8.1, 3.1, 4.1, 9.1, 1.1, 4.1);

        //     Optional<Double> maxValue = listNumber.stream()
        //         .collect(Collectors.maxBy(Double::compare));
        //     System.out.println(maxValue.get());

        //     Optional<Double> minValue = listNumber.stream()
        //         .collect(Collectors.minBy(Double::compareTo));
        //     System.out.println(minValue.get());
        // }


        // // Collectors.partitioningBy
        // {
        //     var listNumber = Arrays.asList(8.1, 3.1, 4.1, 9.1, 1.1, 4.1);

        //     Map<Boolean, List<Double>> mapPartitioned = listNumber.stream()
        //         .collect(Collectors.partitioningBy(n -> n>4));
        //     System.out.println(mapPartitioned);

        //     Map<Boolean, String> mapPartitionedString = listNumber.stream()
        //         .collect(Collectors.partitioningBy(n -> n>4,
        //             Collectors.mapping(d -> String.valueOf(d.intValue()), 
        //                 Collectors.joining("-", "<", ">"))));
        //     System.out.println(mapPartitionedString);
        // }


        {

            var listNumber = Arrays.asList(8.1, 3.1, 4.1, 9.1, 1.1, 4.1);
            
            Optional<Double> reducedValue = listNumber.stream()
                .collect(Collectors.reducing((a, b) -> a + b));
            System.out.println(reducedValue.get());

            double reducedValueDouble = listNumber.stream()
                .collect(Collectors.reducing(1.0, (a,b) -> a + b));
            System.out.println(reducedValueDouble);

            String reducedValueString = listNumber.stream()
                .collect(Collectors.reducing("a", d -> "b" + d, (a, b) -> a + "-" + b));
            System.out.println(reducedValueString);

        }
        


    }


}