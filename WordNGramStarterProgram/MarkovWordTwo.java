
/**
 * Write a description of MarkovWordTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovWordTwo implements IMarkovModel{
        private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public int indexOf(String[] words, String target1,String target2, int start){
       for (int k=start; k<words.length-1;k++){
           if (words[k].equals(target1)&&words[k+1].equals(target2)){
               return k;
           }
       }
       return -1;
    }
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-2);  // random word to start with
        String key1 = myText[index];
        String key2 = myText[index+1];
        sb.append(key1);
        sb.append(key2);
        sb.append(" ");
        for(int k=0; k < numWords-2; k++){
            ArrayList<String> follows = getFollows(key1,key2);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key1=key2;
            key2 = next;
        }
        
        return sb.toString().trim();
    }
    
    public ArrayList<String> getFollows(String key1,String key2) {
        //String text="this is just a test yes this is a simple test";
        //String[] myText=text.split("\\s+");
        //System.out.println(myText);
        ArrayList<String> follows = new ArrayList<String>();
        int pos=0;
        while ( pos<myText.length-2){
            int start=indexOf(myText,key1,key2,pos);
            if(start==-1){
                break;
            }
            pos=start+1;
            follows.add(myText[pos+1]);
            
            
        }
        //System.out.println(follows);
        return follows;
    }

}
