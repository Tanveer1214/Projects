/* Topic: Exception Handling
          Exception distrup normal flow of prgram if Exception occour in our program then our program
		  will be end 
   What happen when exception occour?
	      when exception occour then java throw the exception then java default catch mechanism will 
		  catch exception and print java default meesage then our program will be end 
   
   How can we handle exception and avoid stop program?
   there are some possible ways that you can handle java exception
   1: our throw default catch
   2: default throw our catch
   3: our throw and our catch
   there are 3 types of exception
   1: chacked exception (compile time exception)
   2: unchacked exception (run time exception)
   3: error
   if you want control exception then use (try,block) then write exception situation inside block 
   Examples given below**/

import java.io.*;
public class Excep
{
	public static void main(String args[]) throws IOException// tells compiler for exception
	{
		throw new IOException();
	}
}
		

/*
import java.util.Scanner;
public class Excep
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int b=10000;
		System.out.println("Enter Amount for withraw");
		int w=sc.nextInt();
		try{
			if(b<w)
			{
				throw new ArithmeticException("Insuffient Balance");
			}
			else
			{
				System.out.println("Transaction Successfull");
				b=b-w;
				System.out.println("Your current balance is "+b);
			}
		}catch(ArithmeticException e){ System.out.println(e.getMessage()); }
		
		System.out.println("Thanks for using our serviceses");
	}
}
*/


/*public class Excep
{
	public static void main(String args[])
	{
		try{
			int a=5/0;
		}catch(ArithmeticException e){ System.out.println("ye Exception hai");}
        System.out.println("Hello java");
	}
}*/


// More about exception from javatpoint
class Example extends Exception {

    public Example() {}

    public Example(String s) {
        super(s);
    }

    // try-catch, nested try-catch, finally block
    public void ExceptionExample() {
        try {
            //int a = 10/0;

            try {
                int[] arr = {1,2,3};
                System.out.println(arr[3]);
            }catch(NumberFormatException e) { // if this catch block not mach with exception the jvm will math with outer catch block.
                e.printStackTrace();
            }

        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer Catch Block Executed...");
        }
        catch(Exception e) {
            System.out.println("Exception catch block is running...");
        }
        finally { // finally block always execute either exception handled or not.
            System.out.println("Important code inside finally block...");
        }
        System.out.println("Rest of code..");
    }

    // custom exception
    public void customException() {
        try {
            throw new Example("This is custom exception");
        } catch(Example e) {
            System.out.println(e.getMessage());
        }
    }

    public void validate(int age) {
        if(age<18) {
            //throw Arithmetic exception if not eligible to vote
            throw new ArithmeticException("Person is not eligible to vote");
        }
        else {
            System.out.println("Person is eligible to vote!!");
        }
    }

}

public class Excep {
    public static void main(String[] args) {
        Example obj = new Example();
        //obj.ExceptionExample();
        //obj.customException();
        obj.validate(17);
    }
}