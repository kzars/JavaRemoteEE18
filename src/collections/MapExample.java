package collections;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();

        //Add values to Map
        map.put("Bob",900);
        map.put("John",920);
        //map.put("John", 1000);

        System.out.println(map);

        //Get value from key
        System.out.println("John's salary: " + map.get("John"));

        //All key values
        System.out.println(map.keySet());

        //Size
        System.out.println(map.size());

        //Check if Map contains key
        System.out.println(map.containsKey("Tony"));

        //Check if Map contains value
        System.out.println(map.containsValue(900));

        //Remove key/value pair from map
        map.remove("Bob");
        System.out.println(map);

        //Example

        Map<String,String> capitalCity = new HashMap<>();
        capitalCity.put("Estonia","Tallin");
        capitalCity.put("Latvia","Riga");
        capitalCity.put("Finland","Helsinki");

        System.out.println(capitalCity.get("Finland"));

        for(Map.Entry<String, String> entry: capitalCity.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

}
