import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
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
