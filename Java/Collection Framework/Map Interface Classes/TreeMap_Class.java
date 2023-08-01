import java.util.TreeMap;

public class TreeMap_Class {

    public static void main(String[] args) {
	
        TreeMap<Integer,String> tm = new TreeMap<>();
        tm.put(1,"Java");
        tm.put(2,"C");
        tm.put(3,"C++");
        tm.put(4,"C#");

        System.out.println(tm.firstKey());
        System.out.println(tm.lastKey());
        System.out.println(tm.get(2));
        System.out.println(tm.isEmpty());
        System.out.println(tm.containsKey(4));
        System.out.println(tm.size());
        tm.replace(2,"JavaScript");

        for(String s : tm.values())
            System.out.print(s+" ");
    }
}
/*
The TreeMap class implements the Map interface by using a tree. A TreeMap provides an efficient
means of storing key/value pairs in sorted order, and allows rapid retrieval.
You should note that, unlike a hash map, a tree map guarantees that its elements will be sorted in
ascending key order
 */