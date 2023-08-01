v[=import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlocking_Queue {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

        queue.add("Tanveer");
        queue.add("Sagar");
        queue.offer("Zubair");
        System.out.println("Elements: "+queue);

        System.out.println("First Value: "+queue.peek());
        System.out.println("Removed Element is: "+queue.remove()); // using remove() method
        System.out.println("Removed Element is: "+queue.poll()); // using poll() method

        try {
            queue.put("Asif"); // this method will add value and also throw exception
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            queue.take(); // if the array blocking queue is empty, it waits until there are elements in the array blocking queue to be deleted
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
/*
Array Blocking queue is thread safe.
Suppose, one thread is inserting elements to the queue and another thread is removing
elements from the queue, Now if the first thread is slower than the second thread waits
until the first thread completes its operations.
 */