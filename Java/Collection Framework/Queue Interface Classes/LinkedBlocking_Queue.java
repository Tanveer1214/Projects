import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlocking_Queue {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(); // you can set capacity also

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.offer(40);
        System.out.println("LinkedList: "+queue);

        System.out.println("First Element: "+queue.peek());
        System.out.println("Element Removed: "+queue.remove()); // poll() and clear() methods also use for remove elements

        try {
            queue.put(50); // add element at the end of the list
        }catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println(queue.take()); // remove and return element from queue
        }catch (Exception e) {
            System.out.println(e);
        }

		System.out.println("LinkedList: "+queue);

    }
}

/*
The LinkedBlockingQueue uses linked lists as its internal storage.

It is considered as a thread-safe collection. Hence, it is generally used in multi-threading applications.

Suppose, one thread is inserting elements to the queue and another thread is removing elements from the queue.

Now, if the first thread is slower than the second thread, then the linked blocking queue can make the second thread waits until the first thread completes its operations.
 */