import java.util.*;
public class Tree_Set {
	
	public static void main(String[] args) {
	
		TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("C");
        treeSet.add("D");

        System.out.println(treeSet.isEmpty());
        System.out.println(treeSet.size());
        System.out.println(treeSet);
	
	}
	
}
/*
TreeSet provides an implementation of the Set interface that uses a tree for storage. 
Objects are stored in a sorted and ascending order. Access and retrieval times are quite fast, 
which makes TreeSet an excellent choice when storing large amounts of sorted information that 
must be found quickly.
 */