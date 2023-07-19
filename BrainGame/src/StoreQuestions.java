/*
 * purpose:  
 * by:  
 */

public class StoreQuestions {

    public StoreQuestions(){
    }
    
    public String IQChallenge(int i){
       
        String[] IQquestions = new String[5];

        IQquestions[0] = "How many continents are there on Earth?";
        IQquestions[1] = "Who was the first man on the moon?";
        IQquestions[2] = "How many zeroes are there in 1 million?";
        IQquestions[3] = "Some months have 31 days. Some have 30. How many have 28?";
        IQquestions[4] = "Canoe is to ocean liner as glider is to";
    
        return IQquestions[i];
    }

    public String IQOptions(int i){
       
        String[] IQOptions = new String[5];
        IQOptions[0] = "A.20   B.7  C.Over 100"; //answer B.7
        IQOptions[1] = "A.Lance Armstrong  B.My mom  C.Neil Armstrong"; //C.Neil Armstrong
        IQOptions[2] = "A.6  B.3  C.5"; //A.6
        IQOptions[3] = "A.1  B.12  C.11"; //B.12
        IQOptions[4] = "A.kite  B.balloon  C.airplane"; //answer C.airplane

        return IQOptions[i];
    }

    public char IQAnswers(int i){
       
        char[] IQAnswers = new char[5];
        IQAnswers[0] = 'B'; 
        IQAnswers[1] = 'C'; 
        IQAnswers[2] = 'A'; 
        IQAnswers[3] = 'B'; 
        IQAnswers[4] = 'C'; 

        return IQAnswers[i];
    }


}
