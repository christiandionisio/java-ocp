import java.util.Optional;
import java.util.Optional;

public class HandlingOptional {

    public static void main(String ...args) {

        // {
        //     Optional<Double> averageOpt = average(90, 100);
        //     averageOpt.ifPresent(val -> System.out.println(val));
        //     averageOpt.ifPresent(System.out::println);
        // }

        // {
        //     Optional<Double> averageOpt = average();
        //     System.out.println(averageOpt.orElseGet(() -> Math.random()));
        // }

        // {
        //     Optional<Double> averageOpt = average();
        //     // System.out.println(averageOpt.orElseThrow(() -> new IllegalStateException()));
        //     // System.out.println(averageOpt.orElseThrow());   // By default throws NosuchElementException
        // }

        {
            Optional<Integer> optInt = Optional.of(100);
            
            Optional<String> optStr = optInt.flatMap((a) -> {
                System.out.println(a);
                return Optional.of("String");
            });

        }

    }

    public static Optional<Double> average(int... scores) {
        if(scores.length == 0) return Optional.empty();
        int sum = 0;
        for(int score: scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }

}