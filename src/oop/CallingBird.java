package oop;

public class CallingBird {
    public static void main(String[] args) {

        Bird bird1 = new Bird();
        //Set fields values
//        bird1.name = "Owl";
//        bird1.color = "White";
//        bird1.avgLifespan = 15.7d;

        //Get field values
//        System.out.println(bird1.name);
//        System.out.println(bird1.color);
//        System.out.println(bird1.avgLifespan);

        //Get birds info using printBirdInfo method

        //Setting field values using setter methods
        bird1.setName("Parrot");
        bird1.setColor("Green");
        bird1.setAvgLifespan(70);

        //Getting values using getter methods
        System.out.println(bird1.getName());
        System.out.println(bird1.getColor());
        System.out.println(bird1.getAvgLifespan());

        bird1.printBirdInfo();



    }
}
