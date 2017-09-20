
/**
 * Write a description of MarkovWord here.
 * 
 * @Lucy 
 * @version (a version number or a date)
 */

import java.util.*;
public class MarkovWord implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    public MarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    public int indexOf(String[] words, WordGram target, int start){
       int targetL = target.length();
       String[] stringK = new String[targetL];
       //WordGram wgK=new WordGram();
       for (int k=start; k<words.length-targetL+1;k++){           
           System.arraycopy( words,  k,  stringK,  0,  targetL );
           WordGram wgK=new WordGram(stringK,0,targetL);
       if (wgK.equals(target)){
           return k;
       }
       }
       return -1;
    }
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        String key = myText[index];
        sb.append(key);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = next;
        }
        
        return sb.toString().trim();
    }
    
    public ArrayList<String> getFollows(WordGram kGram) {
        //String text="this is just a test yes this is a simple test";
        //String[] myText=text.split("\\s+");
        //System.out.println(myText);
        
        ArrayList<String> follows = new ArrayList<String>();
        int pos=0;
        while ( pos<myText.length-kGram.length()){
            int start=indexOf(myText,kGram,pos);
            if(start==-1){
                break;
            }
            pos=start+1;
            follows.add(myText[pos+kGram.length()-1]);
            
            
        }
        //System.out.println(follows);
        return follows;
    }

}
