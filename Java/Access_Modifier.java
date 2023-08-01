class A { // you can not create class as private

	private int a = 10; // can not access out of class without using public methods
	int b = 20; // can be access in same package 
	protected int c = 30; // can be access in same package
	public int d = 40; // can be access every where
	
	public int getter() {
		return this.a;
	}
	
	private void fun() { // can not access out of the class
		System.out.println("This is private method");
	}
	
	// private A() { } // if the constructor is private inheritance is not possible
	
	private class Example { // we can create inner class as private
		public void Greetings() {
			System.out.println("How are you?");
		}
	}
	
	public void getObject() {
		Example obj = new Example();
		obj.Greetings();
	}
	
}

class B extends A {
	
	public void display() {
		//fun();
		getObject();
		System.out.println(getter());
	}
		
}

public class Access_Modifier {
	public static void main(String[] args) {
		B ob = new B();
		ob.display();
	}
}