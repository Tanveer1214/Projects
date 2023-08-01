public class Navigable_Set {

	public static void main(String[] args) {
		NavigableSet<String> st = new TreeSet<>();
        st.add("A");
        st.add("B");
        st.add("D");
        st.add("E");
        st.add("F");

        System.out.println(st);

        System.out.println(st.last()); // return last element.
        System.out.println(st.ceiling("C")); // return element C if available otherwise return greater value than C.
        System.out.println(st.floor("C")); // return element C if available otherwise return smaller value than C.
        System.out.println(st.pollFirst()); // return and delete first element.
        System.out.println(st.pollLast()); // return and delete last element.
        System.out.println(st.isEmpty());
	}
	
}
/*
NavigableSet is the sub interface of sortedset interface.
 */