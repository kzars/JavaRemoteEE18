package advanced.tasks.adventure;

public class SplitExample {
    public static void main(String[] args) {


        String s = "You are standing at the end of the road before a small brick building";
        String [] splits = s.split(" ");

        for (String i: splits){
            System.out.println(i);
        }

        String[] building = "You are inside a building a well house for, a small spring".split(", ");
        for (String i: building){
            System.out.println(i);
        }


    }

}
