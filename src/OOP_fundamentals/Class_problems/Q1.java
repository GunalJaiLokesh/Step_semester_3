package OOP_fundamentals.Class_problems;

class libraryBook{
    String title;
    String isbn;
    public libraryBook(String title, String isbn){
        this.title = title;
        this.isbn = isbn;
    }
    public libraryBook(String title){
        this(title,"pending");
    }
    void display(){
        System.out.println(title+"|"+isbn+" catalogued:true ");
    }
}
public class Q1 {
    public static void main (String [] args){
        libraryBook [] lib = new libraryBook[4];
        String [] title = {"Clean Code", "Untitled Draft", "1984","Notes"};
        String [] isbns = {"978-0132350884", "", "9780451524935", ""};
        for ( int i=0;i<title.length;i++){
            lib[i]= new libraryBook(title[i], isbns[i]);
            lib[i].display();
        } 
    }
}
