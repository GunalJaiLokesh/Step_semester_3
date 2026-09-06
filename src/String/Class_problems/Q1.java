package Step_semester_3.src.String.Class_problems;

import java.util.Random;
import java.util.Scanner;
public class Q1 {
    public static void main (String [] args){
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int computer = rand.nextInt(3)+1;
        int draw=0, player=0, comp=0;
        for ( int i=0;i<5;i++){
            System.out.println("Enter \n1 - for Rock \n 2- for Paper\n 3 - for Scissors ");
            int user = sc.nextInt();
            if ( user == computer ){
                System.out.println("DRAW");
                draw++;
            }
            else if((user ==1 && computer == 3 )||
                    (user ==2 && computer == 1)||
                    (user ==3 && computer == 2)){
                        System.out.println("Player wins");
                        player ++;
            }
            else{
                System.out.println("Computer wins");
                comp++;
            }
        }
        System.out.println("Computer won"+comp+" times");
        System.out.println("User won "+player+" times");
        System.out.println("Draw:"+draw);
    }
}