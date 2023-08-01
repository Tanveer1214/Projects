class InsufficientFund extends Exception {
    private String s;
    public InsufficientFund(String s) {
        this.s = s;
    }

    public String getMessage() {
        return s;
    }

}

class Account {

    private double balance;

    public void Deposit(int amount) {
        System.out.println(amount+" is Deposited successfully");
        balance += amount;
    }

    public void Withdraw(int amount) throws InsufficientFund {
        if(amount <= balance) {
            System.out.println(amount+" withdraw from your account");
            balance -= amount;
            System.out.println("current balance: "+balance);
        }
        else {
            throw new InsufficientFund("Insufficient Balance");
        }
    }

    public double checkBalance() {
        return balance;
    }

}

public class Custom_Exception {
    public static void main(String[] args) {
        Account account = new Account();
        account.Deposit(1000);
        try {
            account.Withdraw(300);
            account.Withdraw(900);
        }catch(InsufficientFund e) {
            System.out.println(e.getMessage());
        }
    }
}