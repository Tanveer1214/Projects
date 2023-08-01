import java.util.HashMap;
import java.util.Map;

public class Map_Interface {
    public static void main(String[] args) {
        Map<String,Integer> map =  new HashMap<>(); 
        map.put("Tanveer",35);
        map.put("Sagar",20);
        map.put("Zubair",39);
        map.put("Asif",23);

        System.out.println(map.isEmpty());
        System.out.println(map.size());
        map.remove(39);
        System.out.println(map.get(35));
        System.out.println(map);
    }
}
/*
The Map interface maps unique keys to values. A key is an object that you use to retrieve a value at a later date.
Given a key and a value, you can store the value in a Map object. After the value is stored, you can retrieve it by using its key

-> duplicate values are not allowed.
-> unique key for every single value.
 */