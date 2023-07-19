/*
 * Application Purpose:  Final Project -- BRAIN GAME --
 * Author: Ingrid Canola, 
 * Main Program
 * Date: 2023-07-16
 */

import java.util.Scanner;

public class BrainGame {
    
    public static int die = 0;

    public static void main(String[] args) {
        
        rollDie ar1 = new rollDie();
        ValidationsGame ar2 = new ValidationsGame(10);

        char letter;

        System.out.println("-----------------------------------------------------------");
        System.out.println("---------------------  BRAIN GAME  ------------------------");
        System.out.println("-----------------------------------------------------------");

        Scanner in = new Scanner(System.in);
        System.out.print("INSERT YOUR NAME: ");
        String player = in.nextLine();

        System.out.println("   ");
        System.out.println("HELLO " + player + "  YOU START WITH A SCORE OF "+ ar2.getScore() + " POINTS");
        System.out.println("PLEASE, ENTER THE LETTER 'D' TO ROLL A DIE");

        do{
            letter = in.next().charAt(0);

            if (letter == 'D') {                
                die = ar1.getDieNumber();
                System.out.println("       ------");
                System.out.printf("DIE--> |  %d  |", die);
                System.out.println("");
                System.out.println("       ------");
            }else{
                System.out.println("PLEASE, ENTER THE LETTER 'D' TO ROLL A DIE");
            } 
        }while(letter != 'D');     

       // ar2.validateLaunch(die);
        ar2.validateLaunch(6);

        System.out.println("   ");
        System.out.println("HELLO " + player + "  YOUR SCORE IS "+ ar2.getScore() + " POINTS");
        

        in.nextLine();
        in.close();
    }
}
