import java.util.List;
import java.util.ArrayList;

import java.io.IOException;
import java.io.FileNotFoundException;

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

        {
            List<? super IOException> exceptions = new ArrayList<Exception>();
            // exceptions.add(new Exception()); // Does not compile because a List <IOException> could have passed and Exception onject wouldnt fit in there
            // Don't confused the objects inside the array with the declaration
            exceptions.add(new IOException());
            exceptions.add(new FileNotFoundException());

            List<? super Mammal> animal = new ArrayList<Animal>();
            // animal.add(new Animal());    // Does not comp
            animal.add(new Mammal());
            animal.add(new Monkey());
        }

        {
            List<String> strings = new ArrayList<>();
            strings.add("first");
            strings.add("second");
            String getFirst = first(strings);
            System.out.println(getFirst);
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
        // but for lower bounded generics it compiles
        list.add("quack");
    }

    static public class Animal {}
    public static class Mammal extends Animal {}
    public static class Monkey extends Mammal {}

    static <T> T first(List<? extends T> list) {
        return list.get(0);
    }



}