package basics;

public class TwoDimensionalArray {
    public static void main(String[] args) {

        String[][] dreamCars = new String[2][5];

        dreamCars[0][0] = "Audi";
        dreamCars[0][1] = "BMW";
        dreamCars[0][2] = "Opel";
        dreamCars[0][3] = "Volvo";
        dreamCars[0][4] = "Lamborghini";

        dreamCars[1][0] = "Lada";
        dreamCars[1][1] = "Ferrari";
        dreamCars[1][2] = "Subaru";
        dreamCars[1][3] = "Saab";
        dreamCars[1][4] = "McLaren";

        System.out.println(dreamCars.length);
        System.out.println(dreamCars[0].length);

        // i = rows
        // j = columns
        for(int i =0; i < dreamCars.length; i++){
            for (int j = 0; j < dreamCars[i].length; j++){
                System.out.println(dreamCars[i][j]);
            }
        }



    }
}
