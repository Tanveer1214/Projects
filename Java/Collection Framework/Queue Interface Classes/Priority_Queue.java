import java.util.PriorityQueue;

public class Priority_Queue {
     public static void main(String[] args) {
         PriorityQueue<Integer> pq = new PriorityQueue<>();
         pq.add(10);
         pq.add(20);
         pq.add(5);
         pq.add(40);
         pq.add(50);
         System.out.println(pq);
         System.out.println(pq.poll());
         System.out.println(pq.peek());
         System.out.println(pq.contains(20));
         System.out.println(pq.size());
         System.out.println(pq.isEmpty());
     }
}
/*
Use FIFO to store data.
duplicate values are allowed.
null values are not allowed.
data store in ascending order. whole queue will not be sorted only samalest element come at first
if you remove that element then next samalest value come at first. oreder can be change 
using comparator class.
 */