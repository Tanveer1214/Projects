import java.io.*;
import java.util.Scanner;
class Example {
	
	public void ATM() {
		
		Scanner sc = new Scanner(System.in);
		int b = 10000;
		System.out.println("Enter Amount for withraw");
		int w = sc.nextInt();
		try {
			if(b < w) {
				throw new ArithmeticException("Insuffient Balance");
			}
			else {
				System.out.println("Transaction Successfull");
				b = b - w;
				System.out.println("Your current balance is "+b);
			}
		} catch(ArithmeticException e) { 
			System.out.println(e.getMessage());
		}
		
		System.out.println("Thanks for using our serviceses");
		
	}
	
}

public class Unchecked_Exception {
	
	public static void main(String[] args) {
		
		int a = 10;
		try {
			a = a/0; // if you not handle this situation then java default exception will handle this situation but next lines of code will not be exicute.
		} catch(ArithmeticException e) { // you can also use finally block here or you can use after catch. note: you can use multiple catch block but finally block must be one.
			System.out.println(e.getMessage());
		}
		
		Example obj = new Example();
		obj.ATM();
		
	}
	
}