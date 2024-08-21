import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

public class JavaCollections {

    public static void main(String ...args) {

        // List methods
        List<String> stringList = new ArrayList<>();
        stringList.add("Hola"); 
        stringList.add("Mundo"); 
        stringList.add("Hello"); 
        stringList.add("World"); 
        System.out.println(stringList);

        stringList.replaceAll(word -> (word.startsWith("H")) ? "replaced": word);
        System.out.println(stringList);

        stringList.set(0, "setted");
        System.out.println(stringList);


        // Queue methods
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(4);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.peek());

        // Deque methods
        Deque<Integer> deque = new LinkedList<>();
        deque.add(11);
        deque.addFirst(12);
        deque.offerFirst(13);
        deque.addLast(14);
        deque.offerLast(15);
        deque.add(16);
        System.out.println(deque);
        System.out.println(deque.peekLast());
        System.out.println(deque.peekFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        System.out.println(deque);

        // using as a stack
        deque.push(16);
        System.out.println(deque);
        deque.pop();
        System.out.println(deque);



    }

}