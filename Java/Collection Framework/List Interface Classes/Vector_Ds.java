import java.util.*;
public class Vector_Ds {
	
	public static void main(String []args) {
	
		Vector v = new Vector(3,2); // initial size is 3, increment is 2 
		System.out.println(v.size()); // getting size of vector
		System.out.println("Initial Capacity "+v.capacity()); // getting capacity of vector
		
		v.addElement(10);
		v.addElement(20);
		v.addElement(30);
		v.addElement(40);
		
		System.out.println("Final Capacity "+v.capacity());
		
		System.out.println("First Value "+v.firstElement());
		System.out.println("Last Value "+v.lastElement());
		
		Enumeration vEnum = v.elements(); 
		
		System.out.println("Vector Values");
		while(vEnum.hasMoreElements()) 
			System.out.print(vEnum.nextElement() + " "); 
	
	}
	
}
/*

The Vector 
The Vector class is similar to a traditional Java array, except that it can grow as necessary to accommodate new elements. 
Like an array, elements of a Vector object can be accessed via an index into the vector. 
The nice thing about using the Vector class is that you don't have to worry about setting it to a specific 
size upon creation; it shrinks and grows automatically when necessary. 
 
The Vector Class Vector implements a dynamic array. It is similar to ArrayList, but with two differences: 

 Vector is synchronized. 
 
 Vector contains many legacy methods that are not part of the collections framework. 

Vector proves to be very useful if you don't know the size of the array in advance or you just need one that 
can change sizes over the lifetime of a program. 

*/