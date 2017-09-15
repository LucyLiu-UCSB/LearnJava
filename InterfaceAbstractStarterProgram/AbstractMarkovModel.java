
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public void setRandom(int seed){
        myRandom=new Random(seed);
    }
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);
    
    protected ArrayList<String> getFollows(String key){
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
}
