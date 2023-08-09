/*
 * purpose:  
 * by:  
 */

public class Die {

    private int outcome;

    public Die(){
    }
    
    public int getDieNumber(){
        outcome = (int)(Math.random()*6 + 1);

        return outcome;
    }

}
