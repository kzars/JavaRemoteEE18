package homeworks;

import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {

        int rand, guess;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter max random range");
        int max = scanner.nextInt(); //0-20

        rand = (int) (Math.random() * (max + 1));
        //System.out.println("Generated random value : " + rand);

        do{
            System.out.println("Guess the number");
            guess = scanner.nextInt();

            if(guess < rand){
                System.out.println("Try bigger");
            }else if(guess > rand){
                System.out.println("Try smaller");
            }

        } while (guess != rand);

        System.out.println("Congratulations you won!");

    }
}
