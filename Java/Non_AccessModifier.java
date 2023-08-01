import java.util.*;
import java.io.*;

/*
The volatile modifier is used to let the JVM know that a thread accessing the variable must always 
merge its own private copy of the variable with the master copy in the memory. 
Accessing a volatile variable synchronizes all the cached copied of the variables in the main 
memory. Volatile can only be applied to instance variables, which are of type object or private. 
A volatile object reference can be null.
*/
/*
public class MyRunnable implements Runnable{ 
    private volatile boolean active; 
     public void run(){ 
        active = true; 
        while (active){ // line 1 
            // some code here 
        } 
    }     
    public void stop(){ 
        active = false; // line 2 
    }
} 
*/
/*
Usually, run() is called in one thread (the one you start using the Runnable), and stop() is called from another 
thread. If in line 1, the cached value of active is used, the loop may not stop when you set active to false 
in line 2. That's when you want to use volatile. 
*/







/*
An instance variable is marked transient to indicate the JVM to skip the particular variable when serializing the object containing it. 
This modifier is included in the statement that creates the variable, preceding the class or data type of the variable
*/
/*
class Example implements Serializable {
	
	public transient int a = 10; 
	
}

public class Non_AccessModifier {
	
	public static void main(String []args) {
		Example obj = new Example();
		System.out.print(obj.a);
	}
	
}
*/





/*
The synchronized keyword used to indicate that a method can be accessed by only one thread at a time. 
The synchronized modifier can be applied with any of the four access level modifiers.
*/
/*
class Example implements Runnable {
	
	public synchronized void getMessage(int a) {
		System.out.println(a);
	}
	
	public void run() {
		for(int i=1;i<=5;i++) 
			getMessage(i);
	}
	
}

public class Non_AccessModifier {
	
	public static void main(String []args) {
		Example obj = new Example();
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		t1.start();
		t2.start();
	}
	
}
*/