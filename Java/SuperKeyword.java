class A {
	
	int a = 10;
	
	public void fun() {
		System.out.println("Parent method is runing");
	}
	
	public A() {
		System.out.println("Parent Constructor is runing");
	}
	
}

class B extends A {
	
	int a = 20;
	
	public B() {
		super(); // calling parent Constructor
		System.out.println("Child Constructor is runing");
	}
	
	public void fun() {
		System.out.println("Child method is runing");
	}
	
	public void getMethod() {
		super.fun(); // calling parent method
	}
	
	public void getVariable() {
		System.out.println("a = "+super.a);
		System.out.println("a = "+a);
	}
	
}

public class SuperKeyword {
	
	public static void main(String[] args) {
		
		B obj = new B();
		obj.getMethod();
		obj.getVariable();
		
	}
	
}

/*

class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Employ extends Person {
    double salary;
    public Employ(int id, String name, double salary) {
        super(id,name);
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Salary: "+salary);
    }

}

public class SuperKeyword {
    public static void main(String[] args) {
        Employ obj = new Employ(12,"Tanveer",100000);
        obj.displayInfo();
    }
}

*/