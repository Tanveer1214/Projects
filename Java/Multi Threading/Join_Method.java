class Example extends Thread {
	
	String name;
	
	public Example(String name) {
		this.name = name;
	}
	
	public void run() {
		
		for(int i=1;i<=5;i++) {
			
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
			
			System.out.println(name+" "+i);
			//System.out.println(Thread.currentThread().getName()); // this method returns a reference to the currently executing thread object. or return name of current thread.
			
		}
		
	}
	
}

public class Join_Method {
	
	public static void main(String []args) {
		
		Example t1 = new Example("t1");
		Example t2 = new Example("t2");
		Example t3 = new Example("t3");
		
		t1.setName("Tanveer");
		System.out.println("t1 = "+t1.getName());
		//System.out.println("Id of t1 is "+t1.getId());
	
		t1.start();
		
		try {
			//t1.join(); // start 't2' and 't3' after 't1' completation.
			t1.join(1500); // start 't2' and 't3' after 't1' complete its task for 1500 mili seconds. (3 times).
		}catch(Exception e) {}
		
		t2.start();
		t3.start();
		
	}
	
}