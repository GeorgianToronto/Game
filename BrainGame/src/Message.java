/*
 * Purpose: Defining a message class to it in the game class
 * Author: Md Anwarul Kabir, 
 * Date: Aug 09, 2023
 */

public class Message {
    //Declaring instance variables
    private String text;
    //Creating a class constructor without any parameters
    public Message(){

    }
    //Creating a class constructor with a parameter
    public Message(String text){
        this.text=text;
    }
    //Defining setter method
    public void setText(String text){
        this.text=text;
    }
    //Defining getter method
    public String getText(){
        return text;
    }
    //Definining print method to print message that takes no parameter
    public String print(){
        String welcomeMessage="-----------------------------------------------------------\n";
        welcomeMessage=welcomeMessage+"---------------------  BRAIN GAME  ------------------------\n";
        welcomeMessage=welcomeMessage+"-----------------------------------------------------------\n";
        welcomeMessage=welcomeMessage+"-------Welcome to the game of luck and inteligence!--------\n";
        return welcomeMessage;
    }
    //Definining print method to print message that takes one parameter. This is an example of method overloading
    public String print(String msgType){
        switch (msgType) {
            case "intro":
                String gameIntro="This is a game that is required not only knowledge and skills but also luck.\n";
                gameIntro=gameIntro+"Mixed of luck, knowledge and intelligence has made this game excited!\n";
                gameIntro=gameIntro+"You will have to start this game by throwing a die that is with your luck!\n";
                gameIntro=gameIntro+"Based on that, you might have the chance of gaining or losing score, \n";
                gameIntro=gameIntro+"without answering any questions of any category among Math, IQ and Riddle.\n";
                gameIntro=gameIntro+"Or, you might have the chance of answering 5 questions from any of those category.\n";
                gameIntro=gameIntro+"Each correct answer will add 10 points to your score, if you can score 50 then you win!\n";
                gameIntro=gameIntro+"Another exciting part is that your time will be calculated to compare with other players.\n";
                gameIntro=gameIntro+"So that you can know that who has completed the game by the lesser amount of time.\n";
                gameIntro=gameIntro+"We hope that you have a clear idea about this game now, best of luck!\n\n";
                
                return gameIntro;
            case "opt":
                String gameOption="GAME OPTIONS\n";
                gameOption=gameOption+"1. Increase score by 10 points\n";
                gameOption=gameOption+"2. Decrease score by 10 points\n";
                gameOption=gameOption+"3. Solve 5 Math problems\n";
                gameOption=gameOption+"4. Solve 5 Riddle problems\n";
                gameOption=gameOption+"5. Solve 5 IQ problems\n";
                gameOption=gameOption+"6. Roll your die again\n";
                return gameOption;
            case "thx":
                String thanks="Thank you for playing the game!\n";
                thanks=thanks+"Have a nice day!!\n";
                
                return thanks;
            default:
                return "defaule";
        }
    }
    //Definining print method to print message that takes four parameter. This is an example of method overloading
    public String print(String msgType, String playerName, int score, long time){
        String greetScore="";
        if(msgType=="greet"){
            greetScore="\nHello " + playerName + ", you have got 10 points as your bonus score!\n";
        }
        else if(msgType=="scr"){
            greetScore="Player Name: " + playerName +"\n";
            greetScore=greetScore+"Total score: " + score +"\n";
            //greetScore=greetScore+"Time spent: " + time/1000 +" seconds\n";
        }
        return greetScore;
    }
    public static String endGameMessage(){
        String egm="****************************\n";
        egm=egm+"**********Game End**********\n";
        egm=egm+"***************************\n";
        return egm;
    }

    public void prinDieFacet(int die){
        System.out.println("Your number is");
        System.out.println("       ----");
        System.out.printf("DIE->|  %d  |", die);
        System.out.println("");
        System.out.println("       ----");
        System.out.println();
    }
}

