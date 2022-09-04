package advanced.threads.bankaccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount account = new BankAccount("IBAN534534523", 1000.0d);

        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    account.deposit(2);
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++){
                    account.withdraw(0);
                }
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        account.seeBalance();

        System.out.println("Enter amount you want to deposit");
        account.deposit(scanner.nextDouble());
        account.seeBalance();




    }
}
