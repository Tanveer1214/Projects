class A extends Thread {
	
	public void run() {
		
		for(int i=0;i<=10;i++) {
			try {
				Thread.sleep(5); //Sleep current thread for 5 mili seconds then start again.
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		
		System.out.println("Thread 'A' is runing "+i);
		
		}
		
	}
	
}

class B extends Thread {
	
	public void run() {
	
		for(int i=0;i<=10;i++)
			System.out.println("Thread 'B' is runing "+i);
		
	}
	
}

class C extends Thread {
	
	public void run() {
	
		for(int i=0;i<=10;i++)
			System.out.println("Thread 'C' is runing "+i);
		
	}
	
}

public class Sleep_Thread {
	
	public static void main(String []args) {
		
		A t1 = new A();
		B t2 = new B();
		C t3 = new C();
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}
// The sleep() method of thread class is used to sleep a thread for the specified amount of time.
