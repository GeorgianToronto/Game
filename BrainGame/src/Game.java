/*
 * Purpose: Defining a game class to in the main method of the main class
 * Author: Md Anwarul Kabir, 
 * Date: Aug 09, 2023
 */

//Importing library to take user input
import java.util.Scanner;
import java.io.InputStream;

public class Game {
    //Creating Message object with default constructor
    Message userMessage=new Message(null);
    //Creating Scanner object with default constructor
    Scanner userInput=new Scanner(System.in);
    //Creating Scanner object with default constructor
    Player newPlayer=new Player();
    //Creating InputStream object with default constructor
    InputStream userInputStream=System.in;
    //Creating Die object with default constructor
    Die newDie = new Die();
    //Declaring a String variable to store user answer
    String userAnswer;

    ValidationsGame ar2 = new ValidationsGame(10);
    char letter;
    
    public void Run(){        
        //Calling print method without parameter
        System.out.println(userMessage.print());
        userMessage.setText("INTRODUCTION: press enter key to skip introduction\n");
        System.out.println(userMessage.getText());
        char[] gameItro=userMessage.print("intro").toCharArray();
        try{
            int i=0;
            while(userInputStream.available()==0 && i<gameItro.length){
                System.out.print(gameItro[i]);
                Thread.sleep(50);
                i=i+1; 
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        userInput.nextLine();
        System.out.println();
        System.out.println("Introduction skipped!");
        System.out.println();
        System.out.println("Are you interested to play this game (y/n)?");
        
        userAnswer=userInput.nextLine();
        if(userAnswer.equals("y")){
            //Calling setPlayerInfo method to collect user information
            setPlayerInfo();
            //Calling print method (method overloading) of the Message class to print greetings to player
            System.out.println(userMessage.print("greet", newPlayer.getName(), newPlayer.getScore(), newPlayer.getSpentTime()));
            //Calling print method (method overloading) of the Message class to print score of the player
            System.out.println(userMessage.print("scr", newPlayer.getName(), newPlayer.getScore(), newPlayer.getSpentTime()));
            //Calling startGame method to start game playing
            startGame();
        }
        else if(userAnswer.equals("n")){
            System.out.println("Ok, see you next time. Bye!");
            System.exit(0); 
        }      
    }

    public void setPlayerInfo(){
        System.out.println("Please enter your name: ");
        newPlayer.setName(userInput.nextLine());
        System.out.println("Please enter your country name: ");
        newPlayer.setCountry(userInput.nextLine());
        newPlayer.setScore(10);
    }
    
    public void startGame(){
        System.out.println();
        System.out.println(userMessage.print("opt"));
        getDieOutput();
        gameFlow(newPlayer.getDieNumber());
        
            //ar2.validateLaunch(6);
            
            //System.out.println("HELLO " + newPlayer.getName() + "  YOUR SCORE IS "+ newPlayer.getScore() + " POINTS");
            
            //userInput.nextLine();
    }

    public void getDieOutput(){
        System.out.println("Now, roll your die by pressing 'D'");
        do{
            letter = userInput.next().charAt(0);
            if (letter == 'D') {       
                newPlayer.setDieNumber(newDie.roll());         
                userMessage.prinDieFacet(newPlayer.getDieNumber());
            }
            else{
                System.out.println("Please enter exactly 'D' to roll your die");
                } 
        }
        while(letter != 'D');
    }

    public void gameFlow(int die){
        if(newPlayer.getScore()<50){
            if(die==1){
                System.out.println("Congratulations " + newPlayer.getName() + "! you have got 10 points by good luck");
                newPlayer.updateScore(10);
                System.out.println("And you have another chance to try your luck");
                getDieOutput();
                gameFlow(newPlayer.getDieNumber());
            }
            else if(die==2){
                System.out.println("Oops! " + newPlayer.getName() + " you have lost 10 points by bad luck.\n");
                newPlayer.updateScore(-10);
                System.out.println("But you have another chance to try your luck");
                getDieOutput();
                gameFlow(newPlayer.getDieNumber());
            }
            else if(die==3){
                System.out.println("Well! " + newPlayer.getName() + " use your math skills to win the game.\n");
                //Start Math quiz
            }
            else if(die==4){
                System.out.println("Well! " + newPlayer.getName() + " use your riddle skills to win the game.\n");
                //Start riddle quiz
            }
            else if(die==5){
                System.out.println("Well! " + newPlayer.getName() + " use your IQ skills to win the game.\n");
                //Start Math quiz
            }
            else if(die==6){
                System.out.println("Oh! " + newPlayer.getName() + " just try again.\n");
                getDieOutput();
                gameFlow(newPlayer.getDieNumber());
            }
        }

        else if(newPlayer.getScore()==50){
            System.out.println("Congratulations " + newPlayer.getName() + "! " + newPlayer.getCountry() + " is proud of you");
            userMessage.print("scr", newPlayer.getName(), newPlayer.getScore(), newPlayer.getSpentTime());
        }
    }
        
}

