package patterns.behavioral.chain;

import java.util.Scanner;

public class ATMDispenseChain {

    private DispenseChain c1;

    public static void main(String[] args) {

        ATMDispenseChain atmDispenseChain = new ATMDispenseChain();

        while (true){
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner scanner = new Scanner(System.in);
            amount = scanner.nextInt();

            if (amount % 10 != 0){
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }

            atmDispenseChain.c1.dispense(new Currency(amount));
        }
    }

    public ATMDispenseChain(){
        //initializing the chain
        c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        // set chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);

    }

}
