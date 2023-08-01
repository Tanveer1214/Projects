class A extends Thread {
	
	public void run() {
		for(int i=0;i<=5;i++) 
			System.out.println("Thread 'A' is runing "+i);
	}
	
}

class B extends A {
	
	public void run() {
		for(int i=0;i<=5;i++) 
			System.out.println("Thread 'B' is runing "+i);
	}
}

public class Thread_Class {
	
	public static void main(String []args) {
		
		A t1 = new A();
		B t2 = new B();
		t1.start();
		t2.start();
	
	}
	
}