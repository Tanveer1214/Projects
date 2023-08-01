import java.util.ArrayDeque;

public class Array_Deque {
    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>(); // Default capacity is 16.
        //ArrayDeque<Integer> ad2 = new ArrayDeque<>(20); // capacity will be 20.
        ad.push(10);
        ad.push(20);
        ad.push(30);
        ad.push(40); // return true or false
        ad.offer(50); // return true or throw exception
		
		ad.offerFirst(5); // insert element at first
		ad.offerLast(60); // insert element at last
		
		System.out.println("Elements "+ad);

        System.out.println(ad.pop()); 
		System.out.println(ad.poll());
		System.out.println(ad.pollLast()); // remove last element
		System.out.println(ad.pollFirst()); // remove first element
		System.out.println(ad.element()); // return first element or throw exception
        System.out.println(ad.peek()); // return first element or return null
		System.out.println(ad.peekLast()); // return first element or return null
        System.out.println(ad.isEmpty());
        System.out.println(ad.size());
        System.out.println(ad);
    }
}
/*
The	ArrayDeque	class	extends	AbstractCollection	and	implements	the	Deque interface.
It adds no methods of its own. ArrayDeque creates a	dynamic	array and has no capacity
restrictions.(The Deque interface supports implementations that restrict capacity,
but	does not require such restrictions.)
 */