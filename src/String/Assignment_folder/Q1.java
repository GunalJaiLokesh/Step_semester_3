package Step_semester_3.src.String.Assignment_folder;
import java.util.Scanner;
public class Q1{
    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the total number of roll numbers");
        int a = sc.nextInt();
        int [] arr = new int[a];
        for ( int i =0;i<a;i++){
            System.out.println("Enter the "+(i+1)+" element");
            arr[i] = sc.nextInt();
        }
        for ( int i =0;i<a;i++){
            for ( int j=i+1;j<a;j++){
                if ( arr[i]==arr[j]){
                    System.out.println("The number"+arr[j]+"is repeated");
                }
            }
        }
    }
}