import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class List_Interface {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();

        List<Integer> list2 = new ArrayList<>();
        list2.add(40);
        list2.add(50);

        list1.add(10);
        list1.add(20);
        list1.add(30);

        list1.add(1,15); // add element at given index
        list1.addAll(2,list2); // add another collection object at given index
        int a = list1.get(3); // return element of given index
        int b = list1.indexOf(20); // return the index of given element or return 1
        int c = list1.lastIndexOf(20); // Returns the index of the last instance of obj in the invoking list or return 1
        ListIterator<Integer> listIterator = list1.listIterator();
//        while (listIterator.hasNext()) {
//            System.out.println(listIterator.next());
//        }
        int d = list1.remove(4); // remove element at given index
        int e = list1.set(2,100); // update element at given index with given value and return old value
        list1.subList(1,3); // return elements from 1 to 3 index

        System.out.println(e);

    }
}