import java.util.*;
public class LinkedHash_Set {
	
	public static void main(String[] args) {
		
		ArrayList<String> A = new ArrayList<>();
        A.add("Five");

        LinkedHashSet<String> lh = new LinkedHashSet<>();
        LinkedHashSet<String> lh1 = new LinkedHashSet<>(20);
        LinkedHashSet<String> lh2 = new LinkedHashSet<>(20, 5);
        LinkedHashSet<String> lh3 = new LinkedHashSet<>(A);

        lh.add("One"); // order preserved
        lh.add("Two");
        lh.add("Three");
        lh.add("Two"); // duplicate not allowed.

        System.out.println(lh);
        System.out.println(lh.size());
        System.out.println(lh.isEmpty());
        System.out.println(lh.contains("Three"));

        Iterator iterator = lh3.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
		
	}
}
/*
This class extends HashSet, but adds no members of its own.
LinkedHashSet maintains a linked list of the entries in the set, in the order in which they were 
inserted. This allows insertion-order iteration over the set. That is, when cycling through a 
LinkedHashSet using an iterator, the elements will be returned in the order in which they were 
inserted. The hash code is then used as the index at which the data associated with the key is 
stored. The transformation of the key into its hash code is performed automatically.
 */