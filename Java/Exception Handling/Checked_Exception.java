import java.io.*;

class Example {
	
	public void fun() throws IOException {
		throw new IOException("Device Error");
	}
	
	public void fun2() throws IOException {
		fun();
	}
	
	public void fun3() {
		
		try {
			fun2();
		} catch(Exception e) {
			System.out.print("Exception Handled");
		}
		
	}
	
}
	
public class Checked_Exception {
	
	public static void main(String[] args) {
		
		Example obj = new Example();
		obj.fun3();
		
	}
	
}