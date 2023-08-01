import java.util.*;

class Example implements Comparable<Example> {
    int roll;

    public Example(int roll) {
        this.roll = roll;
    }

    public Example() {}

    public int getRoll() {
        return roll;
    }

    @Override
    public int compareTo(Example e) {
        return roll - e.roll;
    }

}

class Student implements Comparator<Student> {

    String name;

    public Student(String name) {
        this.name = name;
    }

    public Student() {}


    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class Comparator_Comparable {
    public static void main(String[] args) {
        List<Example> list = new ArrayList<>();
        list.add(new Example(20));
        list.add(new Example(30));
        list.add(new Example(10));
        list.add(new Example(5));

        Collections.sort(list);

        for(Example i : list) {
            System.out.println(i.getRoll());
        }

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("Tanveer"));
        list2.add(new Student("Sammer"));
        list2.add(new Student("Zubair"));
        list2.add(new Student("Asif"));

        Collections.sort(list2,new Student());

        for(Student s : list2) {
            System.out.println(s.name);
        }

    }
}