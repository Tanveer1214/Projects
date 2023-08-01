class Example extends Thread {
	
	String name;
	
	public Example(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i=0;i<=5;i++)
			System.out.println(name+" "+i);
		
			//Thread.currentThread().setPriority(9); //also you can set Priority like this
			//System.out.println(Thread.currentThread().getPriority());
	}
	
}

public class Thread_Priority {
	
	public static void main(String []args) {
		
		Example t1 = new Example("A");
		Example t2 = new Example("B");
		Example t3 = new Example("C");
		
		t1.setPriority(9); 	//'t1' is high priority
		t2.setPriority(2);	//'t2' is low priority and 't3' is default priority is (5,mid).
		
		System.out.println("t3 priority is "+t3.getPriority());
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}