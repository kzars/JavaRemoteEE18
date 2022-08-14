package oop;

public class Book {

    //Fields
    public String title;        //Public fields
    public String author;
    private int numberOfPages;  // Private field

    //basics.Methods
    public void setNumberOfPages(int numberOfPages){
        if (isNumberOfPagesCorrect(numberOfPages)){
            this.numberOfPages = numberOfPages;
        }else {
            System.out.println("The provided number of pages is incorrect " + numberOfPages);
        }
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    private boolean isNumberOfPagesCorrect(int numberOfPages){
        return numberOfPages > 10;
    }

    public void printBookInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Number of pages: " + numberOfPages);
    }

}
