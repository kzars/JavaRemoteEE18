public class ArrayExamples {
    public static void main(String[] args) {


        //Declare array that will store 3 elements of type String
        String[] names = new String[3];

        //Setting element values using each element's index
        names[0] = "Ben";
        names[1] = "Tom";
        names[2] = "Bob";

        //Getting values from array
        System.out.println(names[2]);

        //Length
        System.out.println(names.length);

        //Second way declare and initialize array
        String[] dreamCars = new String[]{"BMW", "Tesla", "Daewoo", "Ferrari"};

        //Iterate through all elements in array with for loop
        for (int i = 0; i < dreamCars.length; i++){
            System.out.println(dreamCars[i]);
        }

        //Same thing but using For-each loop
        for(String car: dreamCars){
            System.out.println(car);
            System.out.println("Hello Car");
        }



    }
}
