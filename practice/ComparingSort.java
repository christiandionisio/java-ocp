import java.util.*;

public class ComparingSort {

    public static void main(String ...args) {

        // {
        //     record Rabbit(int id) {}

        //     List<Rabbit> rabbitList = new ArrayList<>();
        //     rabbitList.add(new Rabbit(3));
        //     rabbitList.add(new Rabbit(5));
        //     rabbitList.add(new Rabbit(4));
        //     rabbitList.add(new Rabbit(1));

        //     Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
        //     // Collections.sort(rabbitList, c);
        //     // System.out.println(rabbitList);
        //     Collections.reverse(rabbitList);
        //     System.out.println(rabbitList);
        // }

        // {
        //     List<Integer> list = Arrays.asList(6,9,1,9);
        //     Collections.sort(list);
        //     System.out.println(list);

        //     System.out.println(Collections.binarySearch(list, 6));
        //     System.out.println(Collections.binarySearch(list, 3));  // position of list -1
        //     System.out.println(Collections.binarySearch(list, 0));
        //     System.out.println(Collections.binarySearch(list, 10));
        // }

        {
            var names = Arrays.asList("Fluffy", "Hoppy");
            Comparator<String> c = Comparator.reverseOrder();
            var index = Collections.binarySearch(names, "Hoppy", c);    // list must be ordered
            System.out.println(index);
        }

    }

}