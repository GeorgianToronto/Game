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
    //Creating StopWatch object
    StopWatch newStopWatch=new StopWatch();
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
        try{
            if(userInputStream.available()!=0){
                userInput.nextLine();
                System.out.println("Introduction skipped!");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println("Are you interested to play this game (y/n)?");
        
        userAnswer=userInput.nextLine();
        if(userAnswer.equalsIgnoreCase("y")){
            //Calling setPlayerInfo method to collect user information
            setPlayerInfo();
            //Calling print method (method overloading) of the Message class to print greetings to player
            System.out.println(userMessage.print("greet", newPlayer.getName(), newPlayer.getScore(), newPlayer.getSpentTime()));
            //Calling print method (method overloading) of the Message class to print score of the player
            System.out.println(userMessage.print("scr", newPlayer.getName(), newPlayer.getScore(), newPlayer.getSpentTime()));
            //Calling startGame method to start game playing
            startGame();
        }
        else if(userAnswer.equalsIgnoreCase("n")){
            System.out.println("Ok, see you next time. Bye!");
            System.exit(0);
        }      
        else{
            System.out.println("Invaild input");
            System.out.println("****Game Ended****");
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
                System.out.println( newPlayer.getName() + ", use your math skills to win the game.\n");
                //Start Math quiz
                startMathQuiz();
            }
            else if(die==4){
                System.out.println(newPlayer.getName() + ", use your riddle skills to win the game.\n");
                //Start riddle quiz
                startRiddleQuiz();
            }
            else if(die==5){
                System.out.println(newPlayer.getName() + ", use your IQ skills to win the game.\n");
                //Start IQ quiz
                startIqQuiz();
            }
            else if(die==6){
                System.out.println("Oh! " + newPlayer.getName() + " just try again.\n");
                getDieOutput();
                gameFlow(newPlayer.getDieNumber());
            }
        }
        else{
            System.out.println("Congratulations " + newPlayer.getName() + "! you have won the game!!\n You are a pround of " + newPlayer.getCountry() + "!\n");
            System.out.println(userMessage.print("scr", newPlayer.getName(), newPlayer.getScore(), newPlayer.getSpentTime()));
            userMessage.print("thx");
            System.exit(0);
            System.out.println(Message.endGameMessage());
        }
    }
    //IQ quiz methos
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
                newPlayer.updateScore(10);
                System.out.println("\n Correct Answer! 10 points added. Current Score= " + newPlayer.getScore() +"\n");
            }
            else{
                newPlayer.updateScore(-10);
                System.out.println("\n Incorrect, 10 points lost!. The correct answer is " + quiz[i][2] + " Current Score= " + newPlayer.getScore() +"\n");
            }
        }
        checkScore();
        userInput.close();
        System.out.println(Message.endGameMessage());
        System.exit(0);
    }
    public void checkScore(){
        if(newPlayer.getScore()==50){
            System.out.println("Congratulations " + newPlayer.getName() + "! you have won the game!!\n You are a pround of " + newPlayer.getCountry() + "!\n");
            System.out.println(userMessage.print("scr", newPlayer.getName(), newPlayer.getScore(), newPlayer.getSpentTime()));
            userMessage.print("thx");
        }
        else if(newPlayer.getScore()>=50){
            System.out.println("Wow " + newPlayer.getName() + "! you have won the game with bonus points!!\n You are a pround of " + newPlayer.getCountry() + "!\n");
            System.out.println(userMessage.print("scr", newPlayer.getName(), newPlayer.getScore(), newPlayer.getSpentTime()));
            userMessage.print("thx");
        }
        else if(newPlayer.getScore()<50){
            System.out.println("Sorry " + newPlayer.getName() + "! you have lost the game!!\n Try again later\n");
            System.out.println(userMessage.print("scr", newPlayer.getName(), newPlayer.getScore(), newPlayer.getSpentTime()));
            userMessage.print("thx");
        }
    }
    //Math quiz methos
    public void startMathQuiz(){
        Scanner userInput=new Scanner(System.in);
        //Two dimentional array
        String[][] quiz={
            {"What is the sum of 12 + 78?","\n A. 50  \n B. 60  \n C. 90 \n", "C"},
            {"What is the BODMAS of 15-13(12*1/2)?","\n A. 12  \n B. 13  \n C. 10 \n", "A"},
            {"What is the square root of 5 using Babylonian method?","\n A. 2.236068  \n B. 2.6512  \n C. 2.45445 \n", "A"},
            {"What is the area of the triangle with first side 7, second side 15, third side 20?","\n A. 35  \n B. 42  \n C. 40 \n","B"},
            {"What is the Fibonacci sequence for the 6th term?","\n A. 45  \n B. 10  \n C. 3 \n","C"},
        };
        //One dimentional array
        String [] answer=new String[5];

        System.out.println();
        System.out.println("Here you go for the Math test!\n");
        for(int i=0;i<quiz.length;i++){

            System.out.println( i+1 + ". " + quiz[i][0] + " " +quiz[i][1]);
            answer[i]=String.valueOf(userInput.next().charAt(0));
            if(quiz[i][2].equals(answer[i].toUpperCase())){
                newPlayer.updateScore(10);
                System.out.println("\n Correct Answer! 10 points added. Current Score= " + newPlayer.getScore() +"\n");
            }
            else{
                newPlayer.updateScore(-10);
                System.out.println("\n Incorrect, 10 points lost!. The correct answer is " + quiz[i][2] + " Current Score= " + newPlayer.getScore() +"\n");
            }
        }
        checkScore();
        userInput.close();
        System.out.println(Message.endGameMessage());
        System.exit(0);
    }
    //Riddle quiz methos
    public void startRiddleQuiz(){
        Scanner userInput=new Scanner(System.in);
        //Two dimentional array
        String[][] quiz={
            {"The more you code, the more of me there is. I may be gone for now but you can\u2019t get rid of me forever. What am I?","\n A. A bug  \n B. An insect  \n C. An error \n", "A"},
            {"As a developer I\u2019m your eyes, showing you the result of your code in your language of choice. What am I?","\n A. Terminal  \n B. A print statement  \n C. An error message \n", "B"},
            {"I take what I\u2019m given, do some magic, and give you back something you expect. There are many different versions of me and we originated from math. I ensure your code is clean and reusable. What am I?","\n A. A variable  \n B. A loop  \n C. A function \n", "C"},
            {"I am a programming construct that allows you to repeat a block of code until a certain condition is no longer true. What am I?","\n A. A recursion  \n B. A loop  \n C. A iteration \n","B"},
            {"I am a program that takes your code, analyses it, and translates it into a format that the computer understands. Without me, your code would be just plain text. What am I?","\n A. A translator  \n B. A compiler  \n C. An interpreter \n","B"},
        };
        //One dimentional array
        String [] answer=new String[5];

        System.out.println();
        System.out.println("Here you go for the Math test!\n");
        for(int i=0;i<quiz.length;i++){

            System.out.println( i+1 + ". " + quiz[i][0] + " " +quiz[i][1]);
            answer[i]=String.valueOf(userInput.next().charAt(0));
            if(quiz[i][2].equals(answer[i].toUpperCase())){
                newPlayer.updateScore(10);
                System.out.println("\n Correct Answer! 10 points added. Current Score= " + newPlayer.getScore() +"\n");
            }
            else{
                newPlayer.updateScore(-10);
                System.out.println("\n Incorrect, 10 points lost!. The correct answer is " + quiz[i][2] + " Current Score= " + newPlayer.getScore() +"\n");
            }
        }
        checkScore();
        userInput.close();
        System.out.println(Message.endGameMessage());
        System.exit(0);
    }
}

