import java.util.List;
import java.util.ArrayList;

public class GenericTypesBounding {

    public static void main(String ...args) {

        // Unbounded wildcard
        {
            // Notice that this is valid witohut <>
            // List keywords = new ArrayList();
            // keywords.add("java");
            // keywords.add(new Object());
            // keywords.add(1);

            // List<String> keywords = new ArrayList();    // also valid
            // var keywords = new ArrayList<>();           // valid but var return tipe Arraylist<Object>
            List<String> keywords = new ArrayList<>();
            keywords.add("java");
            printList(keywords);
        }

        // Upper-bounded wildcards
        {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            System.out.println(total(list));
        }

        // Lower-bounded wildcards
        {
            List<String> strings = new ArrayList<String>();
            strings.add("tweet");
            
            List<Object> objects = new ArrayList<Object>(strings);
            addSound(strings);
            addSound(objects);
            printList(strings);
            printList(objects);
        }

    }

    // Unbounded wildcard
    public static void printList(List<?> list) {
        for(Object x: list) 
            System.out.println(x);
    }

    // Upper-bounded wildcards
    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number: list)
            count += number.longValue();
        return count;
    }

    // Lower-bounded wildcards
    public static void addSound(List<? super String> list) {
        // In this case you cannot set unbounded or
        // upper bounded generics because they are inmutable
        list.add("quack");
    }


}