
/**
 * Write a description of MarkovModel here.
 * 
 * @Lucy
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.Random;
public class MarkovModel extends AbstractMarkovModel{
    
     private int keyLength;
    
    public MarkovModel(int N) {
        keyLength=N;
        
    }
    
   

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-keyLength);;
        String key=myText.substring(index,index+keyLength);
        sb.append(key);
        for(int k=0; k < numChars-keyLength; k++){           
           ArrayList<String> follows=getFollows(key);
           if(follows.size()==0){
               break;
           }
           index=myRandom.nextInt(follows.size());
           String next=follows.get(index);
           sb.append(next);
           key=key.substring(1)+next;
        }
        
        return sb.toString();
    }
     public String toString(){        
     return "MarkovModel of order"+keyLength ;  
    }
}
