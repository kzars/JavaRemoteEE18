package advanced.tasks.adventure;

import java.util.HashMap;
import java.util.Map;

public class Location {

    //Fields
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    //Constructor
    public Location(int locationID, String description){
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String,Integer>();
        this.exits.put("Q",0);
    }

    //Adding new exit
    public void addExit(String direction, int locationID){
        exits.put(direction,locationID);
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }
}






























