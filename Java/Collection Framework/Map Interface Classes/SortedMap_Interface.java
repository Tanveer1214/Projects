import java.util.SortedMap;
import java.util.TreeMap;

public class TempJava {
    public static void main(String[] args) {
        SortedMap<Integer,String> tm = new TreeMap<>();
        tm.put(5,"Java");
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
The SortedMap interface extends Map. It ensures that the entries are maintained in an ascending key order. 
 */