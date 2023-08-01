import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMap_Class {
    public static void main(String[] args) {
        HashMap<Integer,String> hm1 = new HashMap<>();
        //HashMap<Integer,String> hm2 = new HashMap<>(hm1); // pass object of other HashMap.
        //HashMap<Integer,String> hm3 = new HashMap<>(20); // set capacity 20.
        //HashMap<Integer,String> hm4 = new HashMap<>(20,5); // set capacity 20 when 50% full then increase capacity.

        hm1.put(35,"Tanveer");
        hm1.put(20,"Sagar");
        hm1.put(39,"Zubair");

        System.out.println(hm1.size());
        System.out.println(hm1.get(35));
        System.out.println(hm1.isEmpty());
        System.out.println(hm1.remove(39));
        System.out.println(hm1.containsKey(20));
        hm1.replace(20,"Asif");

        Set set = hm1.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext())
            System.out.print(iterator.next());

    }
}
/*
The HashMap class uses a hashtable to implement the Map interface. This allows the execution time 
of basic operations, such as get( ) and put( ), to remain constant even for large sets. 
-> Duplicate not allowed.
 */