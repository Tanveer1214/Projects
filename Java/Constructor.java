class A {
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    public B() {
        this(10); // calling same class constructor with one argument 
        System.out.println("B");
    }

    public B(int a) { // this constructor will call parent constructor before print a 
        System.out.println(a);
    }

}
public class Constructor {
    public static void main(String[] args) {
        B obj = new B();
    }
}

/*
In inheritance child class constructor will call parent class constructor before run own 
Constructor code. 
 */