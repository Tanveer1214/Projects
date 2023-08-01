/** Topic: What is Abstract class?
   if you will make abstract class then you can not make object of abstract class but some ways to use 
   abstract class  
   By Reference variable of abstract class, you can make reference variable of abstract class but abstract
   class reference variable can access their methods can not access child class methods    
   By Inheritance you can make child class of abstract class 
   
   Why we should make abstract class 
   suppose you are making software for school then you will make two classes one for student and other 
   for teacher but these two classes property same like name, age, phone,etc then you should make
   abstract class because you can avoid same coding again lets see simple example*/

   
   abstract class A 
   {
	   private int a,b,c;
	   public void setdata(int x, int y, int z) 
	   { a=x; b=y; c=z; }
	   public void showdata()
	   { System.out.println(a+" "+b+" "+c); }
   }
   class B extends A
   {
   }
   
   public class Abstract
   {
	   public static void main(String args[])
	   {
		   //B obj=new B();// create object of child class child class can access parent methods
		   A obj=new B();// create reference variable of abstract class but object of B class 
		   obj.setdata(20,30,40);
		   obj.showdata();
	   }
   }
   
   

/** Topic: Abstract Methods 
   if you will create Abstract method then class must be abstract class 
   Abstract methods can not define abstract methods dont have body but you can inherit absract method but 
   if you will inherit abstract methods then method always abstract method in child class so best way to 
   override methods from abstract class, lets see simple example*/


/*
abstract class A
{
	abstract void setdata(); // absract method you can not define this method here
}
class B extends A
{
	void setdata()
	{ System.out.println("Hello Abstract Methods"); }
}
public class Abstract
{
	public static void main(String args[])
	{
		B obj=new B();
		obj.setdata();
	}
}
*/