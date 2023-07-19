/*
 * purpose:  
 * by:  
 */

public class rollDie {

    private int outcome;

    public rollDie(){
    }
    
    public int getDieNumber(){
        outcome = (int)(Math.random()*6 + 1);

        return outcome;
    }

}
