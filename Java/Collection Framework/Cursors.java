import java.util.*;
public class Cursors {
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
        list.add("C");
        list.add("CPP");
        list.add("Java");
        list.add("PHP");

        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("Java"))
                iterator.set("Java SE");
        }
        iterator.add("C#");
        System.out.println(list);
		
		/*
		Vector<Integer> v = new Vector<>();
        v.add(10);
        v.addElement(20);
        v.add(30);
        v.addElement(40);
        v.add(50);

        Enumeration<Integer> enumeration = v.elements();

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
		*/
		
		/*
		LinkedList<String> list = new LinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        System.out.println(list);
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            String s = it.next();
            if (s.equals("Two"))
                it.remove();
        }
        System.out.println(list);*/
	}
}
/*
Java Cursors is set of three interfaces (Enumeration, Iterator, IteratorList).
1: Enumeration (1.0)
In java 1.0 Enumeration was available for vector and stack classes. Methods(hasMoreElements(), nextElement()).
2: Iterator (1.2)
Iterator is an interface which available for all list interface classes. Methods(hasNext(), next(), remove()).
3: IteratorList (1.2)
IteratorList is an sub interface of Iterator interface but with some extra methods(hasNext(), next(), hasPrevious(),
previous(), nextIndex(), previousIndex(), remove(), set(), add()).
*/