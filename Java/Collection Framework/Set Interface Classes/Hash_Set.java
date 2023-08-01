public class Hash_Set {
	
	public static void main(String[] args) {
		ArrayList<String> A = new ArrayList<>();
        A.add("Tanveer");
        HashSet<String> H = new HashSet<>();// default capacity is 16.
        HashSet<Integer> H2 = new HashSet<>(20); // now capacity will be 20.
        HashSet<Integer> H3 = new HashSet<>(20, 5); // capacity == 20, when 50% full then increase capacity.
        HashSet<String> H4 = new HashSet<>(A); // you can pass collection object.

        H.add("One"); // not order preserved means when you print it will randomly print. No guarantee One will print first.
        H.add("Two");
        H.add("Three");
        H.add("Four");
        H.add("Five");
        H.add("Two"); // Duplicates are not allowed.

        System.out.println(H.size());
		System.out.println(H.remove("Three"));
        System.out.println(H.isEmpty());
        System.out.println(H.contains("Five"));
        System.out.println(H);

        Iterator iterator = H.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //H.toArray();
	}
	
}

/*
 HashSet extends AbstractSet and implements the Set interface. It creates a collection 
 that uses a hash table for storage. A hash table stores information by using a mechanism called 
 hashing. In hashing, the informational content of a key is used to determine a unique value, 
 called its hash code.The hash code is then used as the index at which the data associated with 
 the key is stored. The transformation of the key into its hash code is performed automatically.
 */