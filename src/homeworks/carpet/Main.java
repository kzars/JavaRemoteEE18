package homeworks.carpet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter floor size");
        System.out.println("Enter floor length");
        double length = scanner.nextDouble();

        System.out.println("Enter floor width");
        double width = scanner.nextDouble();

        //Create Floor class object
        Floor floor = new Floor(width,length);

        System.out.println("Enter carpet price per m^2");
        double cost = scanner.nextDouble();

        //Create Carpet class object
        Carpet carpet = new Carpet(cost);

        //Create Calculator object and pass
        //Floor and Carpet objects as input parameters
        Calculator calculator = new Calculator(floor,carpet);
        System.out.println("Carpet will cost: " + calculator.getTotalCost() + " Eur");


    }
}
