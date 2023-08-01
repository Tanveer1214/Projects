import java.util.Scanner;
class Account {
	
	private int bal;
	public Account(int bal) {
		this.bal = bal;
	}
	
	public boolean isSufficientBlance(int w) {
		if(bal > w)
			return(true);
		else
			return(false);
	}
	
	public void withraw(int amt) {
		bal = bal - amt;
		System.out.println("Withrawl money is "+amt);
		System.out.println("Your current balance is "+bal);
	}
}

class Customer implements Runnable {
	
	private String name;
	private Account account;
	public Customer(Account account, String n) {
		this.account = account; 
		name = n;
	}
	
	public void run() {
		
		synchronized(account) {
		
    		Scanner kb=new Scanner(System.in);
			System.out.println(name+"\nEnter amount to withraw");
			int amt = kb.nextInt();
			if(account.isSufficientBlance(amt)) {
					account.withraw(amt);
					System.out.println(name);
				}
			else
				System.out.println("Insufficient Blance");
		}
		
	}
	
}

public class Thread_Synchronization {
	
	public static void main(String []args) {
		Account a1 = new Account(1000);
		Customer c1 = new Customer(a1,"Lela");
		Customer c2 = new Customer(a1,"Majnoo");
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();
	}
}
	
/* Program of synchronizing in java using thread in this program we have two customer (lela) and (majnoo) 
   and they have same account the blance of account is 1000. if both access the account same time if 1 customer
   withraw first the balance will be decrease if the 2 customer access the account the who enter amount greater   
   their balance but already balance decrease so such condition we use synchronizing to overcome that condition*/	
   
   
   
   // Another Example

/*   
 class Table {
	
	public void printTable(String name, int n) {
		System.out.println(name+" Thread is starting");
		for(int i=1;i<=10;i++) 
			System.out.println(n+" x "+i+" = "+i*n);
		
	}
	
}

class displayTable extends Thread {
	
	Table tb;
	String name;
	int n;
	
	public displayTable(String name, Table t, int n) {
		this.name = name;
		tb = t;
		this.n = n;
	}
	
	public void run() {
		
		synchronized(tb) {
			tb.printTable(name,n);
		}
		
	}
	
}

public class Thread_Synchronization {
	
	public static void main(String []args) {
		
		Table obj = new Table();
		
		displayTable t1 = new displayTable("t1",obj,2);
		displayTable t2 = new displayTable("t2",obj,3);
		t1.start();
		t2.start();
		
	}
	
}
*/