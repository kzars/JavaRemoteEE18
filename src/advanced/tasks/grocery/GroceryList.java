package advanced.tasks.grocery;

//TODO:
// 1. addGroceryItem
// 2. printGroceryList
// 3. removeGroceryItem
// 4. modifyGroceryItem
// 5. searchItem

import java.util.ArrayList;

public class GroceryList {

    //Field
    private ArrayList<String> groceryList = new ArrayList<>();

    //Methods
    public void addGroceryItem(String item){
        groceryList.add(item);
    }

    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for(int i = 0; i < groceryList.size(); i++){
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    private int findItem(String searchItem){
        return groceryList.indexOf(searchItem);
    }

    public void removeGroceryItem(String item){
        int position = findItem(item);
        if (position >= 0){
            groceryList.remove(position);
            System.out.println(item + " deleted");
        } else {
            System.out.println("Item is not in the list");
        }
    }

    public void modifyGroceryItem(int position, String newItem){
        if(position >= 0 && position < groceryList.size()){
            System.out.println("Grocery item " +  groceryList.get(position) + " was modified");
            groceryList.set(position, newItem);
        }else {
            System.out.println("Item number is not valid");
        }
    }

    public boolean searchItem(String searchItem){
        if (findItem(searchItem) >= 0){
            return true;
        }else {
            return false;
        }
    }


}
