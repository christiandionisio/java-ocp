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

        // // binarySearch
        // {
        //     List<Integer> list = Arrays.asList(6,9,1,9);
        //     Collections.sort(list);       // Collection must be ordered for binary
        //     System.out.println(list);

        //     System.out.println(Collections.binarySearch(list, 6)); // position of List
        //     System.out.println(Collections.binarySearch(list, 3));  // (position of list) -1
        //     System.out.println(Collections.binarySearch(list, 0));
        //     System.out.println(Collections.binarySearch(list, 10));
        // }


        // // reverse order & binarySearch
        // {
        //     var names = Arrays.asList("Fluffy", "Hoppy");
        //     Comparator<String> c = Comparator.reverseOrder();
        //     var index = Collections.binarySearch(names, "Hoppy", c);    // list must be ordered
        //     System.out.println(index);
        // }


        // // FIXME: Immutable lists
        // // List.of and List.copyof are immutable, 
        // // Arrays.asList can only replace elements but cannot add or delete
        // {
        //     List<Integer> aList = Arrays.asList(40,30,20);
        //     // List<Integer> aList = List.of(40,30,20);
        //     List<Integer> bList = List.copyOf(aList);

        //     // bList.sort((Integer::compare));      // UnsupportedOperationException
        //     // System.out.println(bList);

        //     // aList.sort((Integer::compare));  // same as below
        //     aList.sort((a, b) -> Integer.compare(a,b));
        //     System.out.println(aList);
        // }


        // // FIXME: Arrays.compare() and Arrays.mismatch()
        // {
        //     int [] ia1 = {0, 1, 4, 5};
        //     int [] ia2 = {0, 1, 1, 5, 6};

        //     int x = Arrays.compare(ia1, ia2);
        //     int y = Arrays.mismatch(ia1, ia2);
        //     System.out.println(x + " " + y);
        // }


        // {
        //     class TestClass {
        //         static String[] sa = {"a", "aaaa", "aaa", "aa"};
        //         static {
        //             System.out.println(Arrays.toString(sa)); 
        //             Arrays.sort(sa); 
        //             System.out.println(Arrays.toString(sa));
        //         }
        //     }

        //     String search = "aaaA";
        //     if(args.length != 0) search = args[0];
        //     System.out.println(Arrays.binarySearch(TestClass.sa, search));
        // }


        {
            var a = new int[]{1,2,3,4,5};
            var b = new int[]{1,2,3,4,5,3};
            var c = new int[]{1,2,3,4,5,6};

            int x = Arrays.compare(a,c);
            int y = Arrays.compare(b,c);
            System.out.println(x + " " + y);

            int u = Arrays.mismatch(a,c);
            int v = Arrays.mismatch(b,c);
            System.out.println(u + " " + v);
        }

    }

}