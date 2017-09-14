
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.Random;
public class MarkovOne {
    private String myText;
    private Random myRandom;
    
    public MarkovOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public ArrayList<String> getFollows(String key){
        int pos=myText.indexOf(key);
        String next= "";
        String subString=myText;
        ArrayList<String> res=new ArrayList<String>();
        while (pos!=-1 && pos<subString.length()-key.length()){  
            next=subString.substring(pos+key.length(),pos+key.length()+1);
            res.add(next);            
            subString=subString.substring(pos+1);
            pos=subString.indexOf(key);
             
            
        }
        return res;
    }
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1);
        String key=myText.substring(index,index+1);
        sb.append(key);
        for(int k=0; k < numChars-1; k++){           
           ArrayList<String> follows=getFollows(key);
           if(follows.size()==0){
               break;
           }
           index=myRandom.nextInt(follows.size());
           String next=follows.get(index);
           sb.append(next);
           key=next;
        }
        
        return sb.toString();
    }

}
