public class Number_Character {
	
	public static void main(String []args) {
	
		Integer x = 10;
		String s = "20";
		int a = -50;
		double b = 100.2023;
		
		//Number Class or Wrapper classes
		System.out.println(x.floatValue()); // return x in float type, 10.0.
		System.out.println(x.compareTo(8)); // return 0 if equal, 1 for less then, -1 for greater than
		System.out.println(x.equals(10));
		System.out.println(Integer.valueOf(s)); // return the value of s in integer form.
		System.out.println(String.valueOf(x));
		System.out.println(Integer.toString(x));
		System.out.println(Integer.parseInt(s));
		System.out.println(Math.abs(a)); // this will remove - and return abslute value 50
		System.out.println(Math.ceil(b)); // The method ceil gives the smallest integer that is greater than or equal to the argument.
		System.out.println(Math.floor(b));
		System.out.println(Math.min(70,65)); // return smaller one from both argument.
		System.out.println(Math.max(70,65)); // return greater one from both argument.
		System.out.println(Math.random()); // generate random number 0 to 0.1.
		
		//Character class
		System.out.println(Character.isLetter('T')); // return true if character otherwise false.
		System.out.println(Character.isDigit('T')); // return true if Digit otherwise false.
		System.out.println(Character.isWhitespace(' ')); // return true if (' ', '\n', '\t').
		System.out.println(Character.isUpperCase('T'));
		System.out.println(Character.isLowerCase('T'));
		System.out.println(Character.toUpperCase('t'));
		System.out.println(Character.toLowerCase('T'));
		System.out.println(Character.toString('T'));
	
	}
	
}
/*
All the wrapper classes (Integer, Long, Byte, Double, Float, Short) are subclasses of the abstract class Number. 
The object of the wrapper class contains or wraps its respective primitive data type. Converting primitive data 
types into object is called boxing, and this is taken care by the compiler. Therefore, while using a wrapper class 
you just need to pass the value of the primitive data type to the constructor of the Wrapper class. 
And the Wrapper object will be converted back to a primitive data type, and this process is called unboxing. The Number class is part of the java.lang package.
*/