package advanced.threads.bankaccount;

public class BankAccount {

    private double balance;
    private String accountNumber;

    public BankAccount (String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void deposit(double amount){
        balance += amount;
    }

    public synchronized void withdraw(double amount){
        balance -= amount;
    }

    public void seeBalance(){
        System.out.println(balance);
    }


}
