import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
  
    public HashSet <String> readDictionary(FileResource fr){
        HashSet<String> sh= new HashSet<String>();
        for (String l:fr.lines()){
            String lineLowerCase=l.toLowerCase();
            sh.add(lineLowerCase);
        }
        return sh;
    }
    public int countWords(String message,HashSet<String> dictionary){
        String[] stringArray=message.split("\\W+");
        int count=0;
        for(int i=0;i<stringArray.length;i++){
            if(dictionary.contains(stringArray[i])){
                count=count+1;
            }            
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted,HashSet<String> dictionary){
       String decryption = ""; 
       int maxCount=0;
       
       for(int klength=1; klength<=100;klength++){
           int[] keys=tryKeyLength(encrypted,klength,'e');
           VigenereCipher vc= new VigenereCipher(keys);
           String decrypted=vc.decrypt(encrypted);
           int count=countWords(decrypted,dictionary);
           if(count>maxCount){
               maxCount=count;
               int[] maxKey=keys;
               decryption=decrypted;
           }
       }
       //VigenereCipher vc= new VigenereCipher(maxKey);
       //String decryption=vc.decrypt(encrypted);
       return decryption;
    }
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slice=new StringBuilder();
        int i=0;
        char[] sliceChar=message.toCharArray();
        while (i<message.length()){
            if (i% totalSlices==whichSlice){
                slice.append(sliceChar[i]);
            }
            i++;
        
        }
        String sliceString=slice.toString();
        return sliceString;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        int i=0;
        CaesarCracker cc= new CaesarCracker(mostCommon);
        while ( i < klength){
            String iPiece=sliceString(encrypted, i,klength);
            key[i]=cc.getKey(iPiece);
            i++;
        }
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String frString=fr.asString();
        int[] keys =tryKeyLength(frString,5,'e');
        VigenereCipher vc= new VigenereCipher(keys);
        String res=vc.decrypt(frString);
        System.out.println(res);
    }
  
}
