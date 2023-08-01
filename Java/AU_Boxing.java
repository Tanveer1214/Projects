public class AU_Boxing {
    public static void main(String[] args) {

        int a = 10;
        Integer b = a; // AutoBoxing
        System.out.println(b);

        Integer c = 30;
        int d = c; // Unboxing
        System.out.println(d);

    }
}
/*
Autoboxing:
Autoboxing is the automatic conversion that the java compiler makes between the primitive types 
and their Corresponding object wrapper classes. For example, converting an int to an Integer.

Unboxing:
Converting a primitive value, an int into an object of the corresponding wrapper class (Integer) 
is called unboxing. 
 */