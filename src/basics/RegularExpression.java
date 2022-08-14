package basics;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {


        Pattern pattern = Pattern.compile("a+bcd");
        Matcher matcher = pattern.matcher("rabcd");

        System.out.println(matcher.matches());
        System.out.println(matcher.find());

        //Any 3 lowercase letters or any numbers 5-9
        System.out.println(Pattern.matches("[a-z5-9]{3}","sPs"));


        // Example : 344-FDF
        //           531-FG
        //           879-FEFD

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your car's plate number");
        String plateNumber = scanner.nextLine();

        Pattern pattern1 = Pattern.compile("[0-9]{3}-[A-Z]{2,4}");
        Matcher matcher1 = pattern1.matcher(plateNumber);

        boolean correctPlateNumber = matcher1.matches();

        if(correctPlateNumber){
            System.out.println("Your inputted plate number is correct");
        }else {
            System.out.println("Your inputted plate number is not correct");
        }











    }
}
