class Singleton {
	
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	protected static void fun() {
		System.out.println("Fun for Singleton");
	}
	
}

public class SingleTon {
	
	public static void main(String []args) {
		Singleton singleton = Singleton.getInstance();
		singleton.fun();
	}
	
}

/*
The Singleton's purpose is to control object creation, limiting the number of objects to only one. Since there is 
only one Singleton instance, any instance fields of a Singleton will occur only once per class, just like static 
fields. Singletons often control access to resources, such as database connections or sockets. 
*/