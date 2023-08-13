/*
 * Purpose: Defining a player class to store player states and use its methods
 * Author: Md Anwarul Kabir, 
 * Date: Aug 09, 2023
 */

public class Player {
    //Declaring instance variables
    private String name;
    private String country;
    private int score;
    private long spentTime;
    private int dieNumber;

    //Creating a class constructor without any parameters
    public Player(){

    }

    //Creating a class constructor with three parameters
    public Player(String name, String country, int score){
        this.name=name;
        this.country=country;
        this.score=score;
    }
    //Defining setter methods
    public void setName(String name){
        this.name=name;
    }
    public void setCountry(String country){
        this.country=country;
    }
    public void setScore(int score){
        this.score=score;
    }
    public void setSpentTime(long spentTime){
        this.spentTime=spentTime;
    }
    public void setDieNumber(int dieNumber){
        this.dieNumber=dieNumber;
    }
    //Defining getter methods
    public String getName(){
        return name;
    }
    public String getCountry(){
        return country;
    }
    public int getScore(){
        return score;
    }
    public long getSpentTime(){
        return spentTime;
    }
    public int getDieNumber(){
        return dieNumber;
    }
    public void updateScore(int score){
        this.score=this.score+score;
    }
    public void updateTime(long time){
        this.spentTime=spentTime+time;
    }
}
