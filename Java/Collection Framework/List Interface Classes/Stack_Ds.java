import java.util.Stack;
public class Stack_Ds {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(20);
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.peek());
	}
	
}
/*
Stack is a subclass of Vector that implements a standard last-in, first-out stack. 
Stack only defines the default constructor, which creates an empty stack. Stack includes all the methods defined 
by Vector, and adds several of its own. 
*/