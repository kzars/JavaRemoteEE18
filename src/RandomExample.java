public class RandomExample {
    public static void main(String[] args) {

        float number = 5.6f;
        System.out.println(number);

        //Rounding value up
        System.out.println("Ceil : " +  Math.ceil(number) );

        //Rounding value down
        System.out.println("Floor : " + Math.floor(number));

        //Rounding according to math rules
        System.out.println("Round : " + Math.round(number));

        //Absolute value
        System.out.println("Abs : " + Math.abs(-56));

        //Power
        System.out.println("Power : " + (int) Math.pow(2,4));

        //Casting
        System.out.println((int) number);

        //Min
        System.out.println("Min : " + Math.min(105,99));

        //Max
        System.out.println("Max : " + Math.max(200,343));

        //Max or Min from 3 values
        System.out.println("Max from 3 : " + Math.max(345,Math.max(232,454)));

        //SQRT
        System.out.println("Sqrt : " + Math.sqrt(64));

        //Random
        System.out.println("Random : " + Math.random());
        System.out.println("Random (0-9) : " + (int) (Math.random() * 10)); // 0-9
        System.out.println("Random (0-10) : " + (int) (Math.random() * 11)); // 0-10
        System.out.println("Random (1-10): " + ((int) (Math.random() * 10) + 1)); // 1-10
    }
}
