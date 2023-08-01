import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TempJava {
    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(20);
        list1.add(30);

        boolean b1 = list.add(10); // add single value in list return true or false
        list.clear(); // remove all elements from list
        boolean b2= list.addAll(list1); // add other collection object and return true or false
        boolean b3 = list.contains(20); // return true if 20 is in list or return false
        list1.add(20);
        list1.add(30);
        boolean b4 = list.containsAll(list1); // return true if list1 elements same in list or return false
        boolean b5 = list.equals(list1); // it will compare two collection objects if both same return true or false.
        int b6 = list.hashCode(); // return hashcode of collection
        boolean b7 = list.isEmpty(); // if list will be empty return true or return false
        Iterator<Integer> iterator = list.iterator(); // use for print values of collection or visit sequentially in list
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        boolean b8 = list.remove(30); // Removes one instance of obj from the invoking collection. Returns true if the element was removed. Otherwise, returns false.
        boolean b9 = list.removeAll(list1); // Removes all elements of list1 from the invoking collection. Returns true if the collection changed (i.e., elements were removed). Otherwise, returns false.
        boolean b10 = list.retainAll(list1); // Removes all elements from the invoking collection except those in list1. Returns true if the collection changed (i.e., elements were removed). Otherwise, returns false.
        int s = list.size(); // return the size of list
        Object[] arr = list.toArray(); // Returns an array that contains all the elements stored in the invoking collection. The array elements are copies of the collection elements.
        arr = list.toArray(arr); // Returns an array containing only those collection elements whose type matches that of array.

        System.out.println(s);

    }
}