// Static Inner class
/*
public class Inner_Class {
	
	static class Example {
		public void displayMessage() {
			System.out.print("Hey Iam member of inner static class");
		}
	}
	
	public static void main(String[] args) {
		Inner_Class.Example obj = new Inner_Class.Example();
		obj.displayMessage();
	}

}
*/




/* Anonymous Inner Class, An inner class declared without a class name is known as an anonymous inner class. 
In case of anonymous inner classes, we declare and instantiate them at the same time. Generally, they are used 
whenever you need to override the method of a class or an interface. */ 
/*
abstract class Anon {
	
	public abstract void fun();
	
}

public class Inner_Class {
	
	public static void main(String[] args) {
		Anon obj = new Anon() {
			public void fun() {
				System.out.print("Hello World");
			}
		};
		obj.fun();
	}

}
*/



// accesing private member in inner class
/*
class Outer {
	
	private int a = 10;
	
	class inner {
		
		public void fun() {
			System.out.print("Hey iam from inner class "+a);
		}
		
	}
	
}

public class Inner_Class {
	
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.inner obj = outer.new inner();
		obj.fun();
	}

}
*/



// Simple inner class
/*
class Outer {
	
	private class inner {
		
		public void fun() {
			System.out.print("Hey iam from inner class");
		}
		
	}
	
	public void display() {
		inner obj = new inner();
		obj.fun();
	}
	
}

public class Inner_Class {
	
	public static void main(String[] args) {
		Outer obj = new Outer();
		obj.display();
	}
}
*/




// inner class inside the method
/*
class Outer {
	public void fun() {
		int a = 10;
		class inner {
			public int getValue() {
				return a;
			}
		}
		System.out.print(new inner().getValue());
	}
}

public class Inner_Class {
	
	public static void main(String[] args) {
		Outer obj = new Outer();
		obj.fun();
	}
	
}
*/