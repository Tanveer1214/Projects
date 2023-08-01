class Example {
    static int a = 10;
    int b = 20;
    public static void fun() {
        int b = 50;
        System.out.println("This is a Static method "+b);
    }

    static class Sum {
        public static void fun(int a, int b) {
            System.out.println(a+b);
        }
    }

    class Division {
        public void fun(int a, int b) {
            System.out.println(a - b);
        }
    }

}

public class StaticMembers {

    /**static {
        System.out.println("Static block is running");
    }*/

    public static void main(String[] args) {
        //Example.fun();
        //System.out.println(Example.a);
        Example.Sum.fun(10,20);

        Example.Sum obj = new Example.Sum(); // if inner class is static then no need to create the object of the outer class you can crate object of inner class like this
        obj.fun(10,30);

        Example o1 = new Example();
        Example.Division o2 = o1.new Division();
        o2.fun(10,5);


    }

}
/* Topic: Static Member
   static member can run or compile without object and there is no need of object for run static member 
   create only once for class if you will create multi object for class but static member create only once 
   but intance member depend on object intance member create every time for object but static member create 
   only once.

   static member in inheritance 
   static member function can inherit but static member variable can not inherit if you will create same
   name function in child class then child class static member function will hide parent static member  
   function. if you will inherit static variable then compiler exchange object with parent class means
   child class object change into parent class object.

    Note: if you will call static variable in instance member function then (error) you can not do that.
          but you can call in static member function.
          you can create static inner class. **/
