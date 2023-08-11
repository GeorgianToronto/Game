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
                startIqQuiz();
            }
            else if(die==4){
                System.out.println("Well! " + newPlayer.getName() + " use your riddle skills to win the game.\n");
                //Start riddle quiz
                startIqQuiz();
            }
            else if(die==5){
                System.out.println("Well! " + newPlayer.getName() + " use your IQ skills to win the game.\n");
                //Start IQ quiz
                startIqQuiz();
            }
            else if(die==6){
                System.out.println("Oh! " + newPlayer.getName() + " just try again.\n");
                getDieOutput();
                gameFlow(newPlayer.getDieNumber());
            }
        }

        else if(newPlayer.getScore()==50){
             System.out.println("Congratulations " + newPlayer.getName() + "! " + newPlayer.getCountry() + " is proud of you!\n");
                userMessage.print("scr", newPlayer.getName(), newPlayer.getScore(), newPlayer.getSpentTime());
                userMessage.print("thx");
        }
    }
    public void startIqQuiz(){
        Scanner userInput=new Scanner(System.in);
        //Two dimentional array
        String[][] quiz={
            {"How many continents are there on Earth?","\n A. 20  \n B. 7  \n C. 100 \n", "B"},
            {"Who was the first man on the moon?","\n A. Lance Armstrong  \n B. Ainstein  \n C. Neil Armstrong \n", "C"},
            {"How many continents are there on Earth?","\n A. 20  \n B. 7  \n C. Over 100 \n", "B"},
            {"Some months have 31 days. Some have 30. How many have 28?","\n A. 1  \n B. 12  \n C. 11 \n","B"},
            {"Canoe is to ocean liner as glider is to","\n A. Kite  \n B. Balloon  \n C. Airplane \n","C"},
        };
        //One dimentional array
        String [] answer=new String[5];

        System.out.println();
        System.out.println("Here you go for the IQ test!\n");
        for(int i=0;i<quiz.length;i++){
            System.out.println( i+1 + ". " + quiz[i][0] + " " +quiz[i][1]);
            answer[i]=String.valueOf(userInput.next().charAt(0));
            if(quiz[i][2].equals(answer[i].toUpperCase())){
                System.out.println("\n Correct Answer! 10 points added.\n");
                newPlayer.updateScore(10);
            }
            else{
                System.out.println("\n Incorrect, 10 points lost!. The correct answer is " + quiz[i][2] + "\n");
                newPlayer.updateScore(-10);
            }
            if(newPlayer.getScore()==50){
                System.out.println("Congratulations " + newPlayer.getName() + "! " + newPlayer.getCountry() + " is proud of you!\n");
                userMessage.print("scr", newPlayer.getName(), newPlayer.getScore(), newPlayer.getSpentTime());
                userMessage.print("thx");
                System.exit(0);
            }
        }
        userInput.close();
    }
}

