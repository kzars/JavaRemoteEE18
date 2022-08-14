package basics.tasks;

import java.util.Arrays;

public class MinMaxMethods {
    public static void main(String[] args) {
        int [] my_array = {10,243,64,23,2,5345,234,54322,4,46,600};
        int [] randomArray = {1,2,3,45,6};
        String [] strangeArray = {"#", "##", "$$$"};

        System.out.println(strangeArray[1].charAt(0) == '#');

        System.out.println(Arrays.toString(my_array));
        System.out.println(my_array[3]);

        System.out.println(max(my_array));
        System.out.println(max(randomArray));

        System.out.println(min(my_array));
        System.out.println(min(randomArray));
    }

    //Max
    public static int max(int [] array){
        int max = array[0];
        for(int i = 1; i< array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }


    //Min
    public static int min(int [] array){
        int min = array[0];
        for(int i = 1; i< array.length;i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

}
