/*
 * Purpose: Defining a die class to get a random number between 1 to 6
 * Author: Ingrid Canola
 * Date: 2023-07-16
 * Modified by: Md Anwarul Kabir
 * Date of Modification: Aug 09, 2023
 */
import java.lang.Math;
public class Die {
    //Defining roll method to get an random number between 1 to 6
    public int roll(){
        return (int)(Math.random()*6 + 1);

    }

}
