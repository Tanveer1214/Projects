public class Linked_List {
	
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<>();

        list.add("Tanveer");
        list.add("Sammer");

        System.out.println(list.get(0));
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list.peek());
        System.out.println(list.contains("Tanveer"));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.indexOf("Sammer"));
        System.out.println(list.remove(0));

        Iterator iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
		
	}
	
}