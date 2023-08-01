import java.util.LinkedHashMap;

public class LinkedHashMap_Class {
    public static void main(String[] args) {
	
        LinkedHashMap<Integer,String> list1 = new LinkedHashMap<>();
        //LinkedHashMap<Integer,String> list2 = new LinkedHashMap<>(list1);
        //LinkedHashMap<Integer,String> list3 = new LinkedHashMap<>(20);
        //LinkedHashMap<Integer,String> list4 = new LinkedHashMap<>(20, 5);
        //LinkedHashMap<Integer,String> list5 = new LinkedHashMap<>(20,5,true);

        list1.put(1,"Java");
        list1.put(2,"C");
        list1.put(3,"C++");
        list1.put(4,"C#");
        list1.replace(2,"Python");
        System.out.println(list1.get(3));
        System.out.println(list1.size());
        System.out.println(list1.isEmpty());
        System.out.println(list1.containsKey(1));
        System.out.println(list1.containsValue("Java"));
        System.out.println(list1.remove(3));

        for(String s : list1.values())
            System.out.print(s+" ");
    }
}
/*
This class extends HashMap and maintains a linked list of the entries in the map, in the order in which 
they were inserted. This allows insertion-order iteration over the map. That is, when iterating a LinkedHashMap, 
the elements will be returned in the order in which they were inserted. You can also create a LinkedHashMap 
that returns its elements in the order in which they were last accessed. 
 */