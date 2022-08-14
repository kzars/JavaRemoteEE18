package oop;

public class CallingBook {
    public static void main(String[] args) {

        //Create book class object
        Book book1 = new Book();

        //Setting field values
        book1.title = "Test";
        book1.author = "Test author";
        book1.setNumberOfPages(150);

        book1.printBookInfo();

        //Creating new instance of Book class
        Book book2 = new Book();
        book2.author = "Book 2 author";
        book2.title = "Book 2";
        book2.setNumberOfPages(140);
        book2.printBookInfo();





    }
}
