/* Topic: Interface
   An interface in Java is a blueprint of a class. It has static constants and abstract methods. 
   The interface in Java is a mechanism to achieve abstraction. There can be only abstract methods in the 
   Java interface, not method body. It is used to achieve abstraction and multiple inheritance in Java.
   interfaces can have abstract methods and variables. It cannot have a method body.

   Java Interface also represents the IS-A relationship.   

   It cannot be instantiated just like the abstract class.

   Since Java 8, we can have default and static methods in an interface.

   Since Java 9, we can have private methods in an interface.
   
   
   Why use Java interface?
   There are mainly three reasons to use interface. They are given below.

   It is used to achieve abstraction.
   By interface, we can support the functionality of multiple inheritance.
   It can be used to achieve loose coupling.**/
  
// Example 1

import java.util.Scanner;
interface A
{
	 void setdata(int a, int b);
	 void showdata();
}
class B implements A
{
	int c;
	public void setdata(int a, int b)
	{
		c=a+b;
	}
	
	public void showdata()
	{
		System.out.println("Sum is "+c);
	}
}

public class Interf
{
	public static void main(String args[])
	{
		A obj=new B();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two numbers");
		int i=sc.nextInt();
		int j=sc.nextInt();
		obj.setdata(i,j);
		obj.showdata();
		
	}
}  

/* //Example 2

interface Example
{
	int a=5;
	void setdata();// you can make arguments functions (As your choice)
}

interface Example2 extends Example// you can multi extends interfaces 
{
	void showdata();
}

class Example1 implements Example2
{
	public void setdata()
	{ System.out.println(" Hello Interface"); }
	public void showdata()
	{ System.out.println(" Hello Interface again"+" "+a); }
}

public class Interf	
{
	public static void main(String args[])
	{
		Example1 obj=new Example1();
		obj.setdata();
		obj.showdata();
	}
}
	
**/	
	
	