import java.util.LinkedList;
import java.util.Queue;

public class Linkedlist_Queue {

    public static void main(String[] args) {
        Queue<Integer> numbers = new LinkedList<>();

        numbers.add(1); // return true if element inserted otherwise throw exception.
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
		numbers.offer(6); // return true if element inserted otherwise false.
        System.out.println("LinkedList: "+numbers);

        System.out.println("First Element: "+numbers.peek()); // return first element if queue is empty then return null.
		System.out.println("First Element: "+numbers.element()); // return first element. if queue is empty throw exception.
        System.out.println("Removed Element is: "+numbers.poll()); // removing element from linked-list.

        System.out.println(numbers.remove()); // it will throw exception if operation failed.
        System.out.println(numbers.contains(5));
        System.out.println(numbers.size());
        System.out.println(numbers.isEmpty());

        System.out.println(numbers);
    }

}
/*
LinkedList class implements Queue and Dequeue interfaces.
we can use linked-list as queue.
LinkedList can use methods of Queue and Dequeue interfaces. 
 */