import java.util.*;

public class OptionalPractice {

    public static void main(String ...args) {

        class NewClass {
            public static Optional<String> getGrade(int marks) {
                Optional<String> grade = Optional.empty();
                if(marks > 50) {
                    grade = Optional.of("PASS");
                } else {
                    grade.of("FAIL");
                }

                return grade;
            }
        }

        Optional<String> grade1 = NewClass.getGrade(50);
        Optional<String> grade2 = NewClass.getGrade(55);
        System.out.println(grade1.orElse("UNKNOWN"));

        if(grade2.isPresent()) {
            grade2.ifPresent(x -> System.out.println(x));
        } else {
            System.out.println(grade2.orElse("Empty"));
        }

    }

}