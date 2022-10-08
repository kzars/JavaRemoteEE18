package advanced.tasks.adventure;
// Change the program to allow players to type full words, or phrases, then move to the
// correct location based upon their input.
// The player should be able to type commands such as "Go West", "run South", or just "East"
// and the program will move to the appropriate location if there is one.  As at present, an
// attempt to move in an invalid direction should print a message and remain in the same place.
//
// Single letter commands (N, W, S, E, Q) should still be available.


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locationMap = new HashMap<Integer, Location>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Put all locations in location map
        locationMap.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locationMap.put(1, new Location(1, "Welcome to the Ishimura Spaceship in the end of universe." +
                "Mutants are located on the northern part of the ship. Damaged engines are on the southern side . Evacuation point in the western side of the spaceship. Easter side is a Captain's bridge(Control panel) . Clear the ship of mutants and repair the engines to fly away or you can immediately evacuate by abandoning the ship .\n"));
        locationMap.put(2, new Location(2, "You are in the middle of a forest after carefully passing a broken bridge made of bones on a river. You hear something coming your way."));
        locationMap.put(3, new Location(3, "You are in a deep, dark forest surrounded by alive trees close to Misty Mountains"));
        locationMap.put(4, new Location(4, "Welcome to the bank of Westeros! Jonathan will serve You in order to assist You with order to submit a transaction, loan request, withdraw or deposit Your coins!"));
        locationMap.put(5, new Location(5, "You entered in a small hut and you can smell a strange smell.. a good and sweet smell.. “Come in”, says the monk, “I just finished making first chocolate.. do you want to taste it?”."));
        locationMap.put(6, new Location(6, "To drink honey beer and relax, you can go to the tavern , where the famous Jaskier performs today."));
        locationMap.put(7, new Location(7, "You have entered Magical Forest, trees are talking to you.  You feel scared. Possible exits are east and south."));
        locationMap.put(8, new Location(8, "My Queen my queen, on her dragon with thy wings shall spread and along the lands shall get, to proclaim what’s worth, her kingdom her throne…."));
        locationMap.put(9, new Location(9, "the arrows will pass, we will retreat"));

        //Adding exits for each location

        locationMap.get(1).addExit("W",2);
        locationMap.get(1).addExit("N",7);
        locationMap.get(1).addExit("E",6);
        locationMap.get(1).addExit("S",5);
        //locationMap.get(1).addExit("Q",0);

        locationMap.get(2).addExit("W",3);
        locationMap.get(2).addExit("E",1);
        //locationMap.get(2).addExit("Q",0);

        locationMap.get(3).addExit("N",4);
        locationMap.get(3).addExit("E",2);
        //locationMap.get(2).addExit("Q",0);

        locationMap.get(4).addExit("S",3);

        locationMap.get(5).addExit("N",1);

        locationMap.get(6).addExit("W",1);

        locationMap.get(7).addExit("S",1);
        locationMap.get(7).addExit("E",8);

        locationMap.get(8).addExit("W",7);
        locationMap.get(8).addExit("N",9);

        locationMap.get(9).addExit("S",8);

        // Vocabulary for storing possible accepted words
        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("WEST","W");
        vocabulary.put("EAST","E");
        vocabulary.put("POHI","N");
        vocabulary.put("LOUNA","S");
        vocabulary.put("LAAS","W");
        vocabulary.put("IDA","E");
        vocabulary.put("VALJAPAAS","Q");

        //Set initial/starting location
        int location = 1;
        while (true){
            //Printing description of current location
            System.out.println(locationMap.get(location).getDescription());

            //Quit game if location is 0
            if (location == 0){
                break;
            }

            //Printing possible exits for current location
            Map<String, Integer> exits = locationMap.get(location).getExits();
            System.out.println("Available exits are: ");
            for (String exit: exits.keySet()){
                System.out.print(exit + " ");
            }

            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (direction.length() > 1){
                String [] words = direction.split(" ");
                for (String word: words){
                    if(vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)){
                location = exits.get(direction);

                System.out.println("Walking to next location");
                for (int i = 0; i < 6; i++){
                    System.out.print(".");
                    try{
                        Thread.sleep(500);
                    }catch (Exception e){

                    }
                }
                System.out.println();
            } else {
                System.out.println("You cannot go in that direction");
            }
        }

    }
}
