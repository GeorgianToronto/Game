/*
 * purpose:  
 * by:  
 */
import java.util.Scanner;
                                                
public class ValidationsGame {

    StoreQuestions ar3 = new StoreQuestions();

    private int score;

    public ValidationsGame(){
    }

    public ValidationsGame(int score){
        this.score = score;
    }
    

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }
    
    public void validateLaunch(int die){
        Scanner in = new Scanner(System.in);
        int number = (int)(Math.random()*5+0);
     
        switch (die) {
            case 1:
                //do something
                break;
            case 2:
                //do something
                break;
            case 3:
                //do something
                break;
            case 4:
                //do something
                break;
            case 5:
                //do something1 1  10
                break;
            case 6:
                 System.out.println(" ");
                System.out.println(ar3.IQChallenge(number));
                System.out.println(ar3.IQOptions(number));

                System.out.println(" ");
                System.out.println("IQ Questions");
                System.out.println("-----------------------------------");
                System.out.println("Insert the letter of your answer");
                char answer = in.next().charAt(0);

                if (answer == ar3.IQAnswers(number)){
                    setScore(+10);
                    System.out.println("Your answer is correct");
                }else{
                    System.out.println("Bad Luck, your answer is wrong");
                }

                break;
            default:
                System.out.println("Play again");
                break;
        }
        in.nextLine();
        in.close();
    }


}
