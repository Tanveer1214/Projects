import java.util.IdentityHashMap;

public class IdentityHashMap_Class {
    public static void main(String[] args) {
        IdentityHashMap<Integer,String> idm = new IdentityHashMap<>();
        idm.put(1,"Java");
        idm.put(2,"C");
        idm.put(3,"C++");
        idm.put(4,"C#");
        idm.replace(2,"Python");
        System.out.println(idm.get(3));
        System.out.println(idm.size());
        System.out.println(idm.isEmpty());
        System.out.println(idm.containsKey(1));
        System.out.println(idm.containsValue("Java"));
        System.out.println(idm.remove(3));

        for(String s : idm.values())
            System.out.print(s+" ");
    }
}
/*
This class implements AbstractMap. It is similar to HashMap except that it uses reference equality when comparing the elements. 
This class is not a general-purpose Map implementation. While this class implements the Map interface, it intentionally violates Map's general contract, which mandates the use of the equals method when comparing objects. 
This class is designed for use only in rare cases wherein reference-equality semantics are required. This class provides constant-time performance for the basic operations (get and put), assuming the system identity hash function (System.identityHashCode(Object)) disperses elements properly among the buckets. 
This class has one tuning parameter (which affects performance but not semantics): expected maximum size. This parameter is the maximum number of key-value mappings that the map is expected to hold.
 */