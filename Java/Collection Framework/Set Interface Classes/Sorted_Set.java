import java.util.*;
public class Sorted_Set {
	public static void main(String[] args) {
		SortedSet<String> st = new TreeSet<>();
		st.add("A");
		st.add("B");
		st.add("C");
		st.add("D");
		System.out.println(st);
		System.out.println(st.first()); // return first element.
		System.out.println(st.headSet("C"));// it will return before elements [A, B].
		System.out.println(st.tailSet("B")); // it will return after elements including B. [B, C, D].
		System.out.println(st.subSet("B","D")); // output should be [B, C].
	}

}
/*
The SortedSet interface extends Set and declares the behavior of a set sorted in an ascending 
order. In addition to those methods defined by Set.
*/