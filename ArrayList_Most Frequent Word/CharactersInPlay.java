
/**
 * Determine the characters in one of Shakespeare’s plays that have the most speaking parts.
 * 
 * @Lucy
 * 
 */
import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> counts;
    public CharactersInPlay(){
        characters = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    
    public void update(String name) {
        name=name.toLowerCase();
        int index = characters.indexOf(name);
        if (index == -1){
            characters.add(name);
            counts.add(1);
        } 
        else {
            int freq = counts.get(index);
            counts.set(index,freq+1);
        }       
    }
    
    public void findAllCharacters(){
        characters.clear();
        counts.clear();
        FileResource resource = new FileResource();
        for (String line :resource.lines()){
            int index = line.indexOf(".");
            if ( index != -1){                
            update(line.substring(0,index));               
            }
        }
    }
    public void tester(){
        findAllCharacters();
        for (int k =0; k<characters.size();k++){
            System.out.println(characters.get(k)+" appears "+counts.get(k)+" times ");
        }
        charactersWithNumParts(1,2);
    }
    public void charactersWithNumParts(int num1, int num2){
        for (int k =0; k<characters.size();k++){
            if(counts.get(k)<= num2 && counts.get(k)>=num1){
            System.out.println(characters.get(k));
            }
        }        
    }
    
    
}

