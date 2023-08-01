import java.util.*;
public class Array_List {
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();

        list.add("Tanveer");
        list.add("Sagar");
        list.add("Umar");
        list.add(1,"Zubair");

        list.set(3,"Asif"); // this value will replace with 3 index value.

        System.out.println(list.get(0));
        System.out.println(list.isEmpty());
        System.out.println(list.remove("Zubair"));
        
        Iterator<String> it = list.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

        /**
        for (String s : list) { // also you can use "for each" loop like this
            System.out.println(s);
        }*/

		
	}
	
}

/*
In Java, we need to declare the size of an array before we can use it. Once the size of an array is declared, it's hard to change it.

To handle this issue, we can use the ArrayList class. It allows us to create resizable arrays.

Unlike arrays, arraylists can automatically adjust their capacity when we add or remove elements from them. Hence, arraylists are also known as dynamic arrays.
*/