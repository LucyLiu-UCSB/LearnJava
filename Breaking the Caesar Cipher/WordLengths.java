
/**
 * figure out the most common word length of words from a file.
 * 
 * 
 * @Lucy
 */
import edu.duke.*;
public class WordLengths {
    public int[] countWordLengths(FileResource resource, int[] counts){
        //FileResource fr= new FileResource();
        for (String s: resource.words()){
            int StringLength = s.length();
            int beginIndex=0;
            int endIndex=s.length()-1;
            if (!Character.isLetter(s.charAt(0))){
                 beginIndex=1;
            } 
            if (!Character.isLetter(s.charAt(endIndex))){
                endIndex=s.length()-2;
            }
            int characterLength=endIndex-beginIndex+1;
            if(characterLength< (counts.length-1)){
                counts[characterLength]=counts[characterLength]+1;            
            } else {
                counts[counts.length-1]=counts[counts.length-1]+1;
            }  
            
        }
        return counts;
    }
    
        
    public void testCountWordLengths (){
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        
        counts=countWordLengths(fr, counts);
        for(int i=0; i< (counts.length-1);i++){
        System.out.println(counts[i]);}
    
    }

}
