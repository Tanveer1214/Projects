class A implements Runnable {
	
	public void run() {
		
		for(int i=0;i<=10;i++) 
			System.out.println("Thread A is runing "+i);
		
	}
}

class B implements Runnable {
	
	public void run() {
		
		for(int i=0;i<=10;i++) 
			System.out.println("Thread B is runing "+i);
		
	}
	
}

public class Runnable_Interface {
	
	public static void main(String []args) {
		
		Thread t1 = new Thread(new A());
		Thread t2 = new Thread(new B());
		t1.start();
		t2.start();
		
	}
	
}

// Runnable interface have only one method which is run().