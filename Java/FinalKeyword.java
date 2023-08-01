final class Example { // can not inherit
	
	final int a = 10;
	final int b; { b = 20;}
	final int c;
	public Example() { c = 30; }
	
	final static int A = 10;
	final static int B;
	static { B = 20;}
	
	public final void fun() { // can not override 
		System.out.println("Fun is runing");
	}
	
}
public class FinalKeyword {
	
	public static void main(String[] args) {
		
		Example obj = new Example();
		System.out.println(obj.B);
		obj.fun();
		
	}
	
}

/**

-> you can not change final variable value once initlize.
-> default value of variable will be convert into blank variable.
-> you can assign value in final variable (declare time, intilization block, constructor).

-> final class can not inherit

-> Method can not override

*/