package Assignment_problems;

import java.util.Scanner;

class bookInventory{
    String title;
    String author;
    int numberofcopies;

    public bookInventory( String title,String author, int numberofcopies){
        this.title = title;
        this.author= author;
        this.numberofcopies = numberofcopies;
    } 
    void printEntry(){
        System.out.println(title+" by "+author+" - "+numberofcopies+" copies available");

    }    
}
public class Q1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        bookInventory [] books = new bookInventory[4];
        for ( int i=0;i<4;i++){
            System.out.println("Enter the name of the book ");
            String title = sc.nextLine();
            System.out.println("Enter name of the author");
            String author = sc.nextLine();
            System.out.println("Enter the total number of copies available ");
            int number = sc.nextInt();
            sc.nextLine();
            books[i]= new bookInventory(title, author, number);
        }
        for ( int i=0;i<4;i++){
            books[i].printEntry();
        }
    }    
}
