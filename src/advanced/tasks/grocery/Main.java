package advanced.tasks.grocery;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO:
// 1. Deleting all items (GroceryList.java) - extra choice in menu
// 2. Add 5 default items to the list when running program
// 3. Optional -  Fix problem with option when entering not number or not number from choice (print "enter valid option")
// 4. Adding or modifying item name cannot start with number (GroceryList.java) =  Using reg-ex validate that item you are adding to the list is consisting only from any number of letter followed by any numbers an the there could be more letter again


public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit){
            System.out.println("Enter your choice");

            try {
                choice = scanner.nextInt();
                //buf fix
                scanner.nextLine();
                switch (choice){
                    case 0:
                        //print all options
                        printInstructions();
                        break;
                    case 1:
                        //print grocery list
                        groceryList.printGroceryList();
                        break;
                    case 2:
                        //add item
                        addItem();
                        break;
                    case 3:
                        //modify item
                        modifyItem();
                        break;
                    case 4:
                        //remove item
                        removeItem();
                        break;
                    case 5:
                        //search item
                        searchForItem();
                        break;
                    case 6:
                        //Delete all items
                        groceryList.deleteAllItems();
                        break;
                    case 7:
                        //quit
                        quit = true;
                        break;
                    default:
                        System.out.println("Input no valid");
                }
            }catch (InputMismatchException e){
                System.err.println("Wrong input! Integers only!");
                //buf fix
                scanner.nextLine();
            }



        }

    }

    public static void printInstructions(){
        System.out.println("\nPress");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the list of grocery items");
        System.out.println("\t 2 - To add an item to the list");
        System.out.println("\t 3 - To modify an item in the list");
        System.out.println("\t 4 - To remove an item from the list");
        System.out.println("\t 5 - To search for an item in the list");
        System.out.println("\t 6 - To delete all item in the list");
        System.out.println("\t 7 - To quit the application");
    }

    public static void addItem(){
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.println("Enter item number");
        int itemNo = scanner.nextInt();
        //fixing input bug
        scanner.nextLine();
        System.out.println("Enter replacement item");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo-1,newItem);
    }

    public static void removeItem(){
        System.out.println("Enter item name:");
        String itemName = scanner.nextLine();
        groceryList.removeGroceryItem(itemName);
    }

    public static void searchForItem(){
        System.out.println("Enter item to search for");
        String searchItem = scanner.nextLine();
        if(groceryList.searchItem(searchItem)){
            System.out.println("Found " + searchItem + " in our grocery list");
        }else {
            System.out.println(searchItem + " is not in the shopping list");
        }

    }

}
