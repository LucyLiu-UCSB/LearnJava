import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
  
    public HashSet <String> readDictionary(FileResource fr){
        HashSet<String> sh= new HashSet<String>();
        for (String l:fr.lines()){
            String lineLowerCase=l.toLowerCase();
            sh.add(lineLowerCase);
        }
        return sh;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
        String dicString="";
        for(String words:dictionary){
            dicString=dicString+words;
        }
        HashMap<Character,Integer> characterCount= new HashMap<Character,Integer>();
        for (int i=0;i<dicString.length();i++){
            char ithChar=dicString.charAt(i);
            if (!characterCount.containsKey(ithChar)){
                characterCount.put(ithChar,1);
            }else{
                characterCount.put(ithChar,characterCount.get(ithChar)+1);
            }
        }
        int maxCount=0;
        char maxChar='e';
        for(char character:characterCount.keySet()){
            if(maxCount<characterCount.get(character)){
                maxChar=character;
            }
        }
        return maxChar;
    }
    
    public String breakForAllLangs(String encrypted, HashMap<String,HashSet<String>>languages){
        int maxCount=0;
        String maxDecryted="";
        for (String key:languages.keySet()){
        String decryted= breakForLanguage(encrypted, languages.get(key));
        int count = countWords(decryted, languages.get(key));
            if(count>maxCount){
                maxDecryted=decryted;
            }        
        }
        return maxDecryted;
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
       char commonChar=mostCommonCharIn(dictionary);
       for(int klength=1; klength<=100;klength++){
           int[] keys=tryKeyLength(encrypted,klength,commonChar);
           for(int i=0;i<keys.length;i++){
           System.out.println(keys[i]);}////////////////////////////////////
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
        CaesarCracker cc= new CaesarCracker(mostCommon);////////////////////////////
        System.out.println(""+mostCommon);
        while ( i < klength){
            String iPiece=sliceString(encrypted, i,klength);
            key[i]=cc.getKey(iPiece);
            i++;
        }
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        HashMap<String,HashSet<String>> hmDic= new HashMap<String,HashSet<String>> ();
        DirectoryResource dr= new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            HashSet<String> hs=readDictionary(fr);
            String name=f.getName();
            hmDic.put(name, hs);
            System.out.println("okay");
        }
        FileResource frEncrypted= new FileResource();
        String frString=frEncrypted.asString();
        String res=breakForAllLangs(frString,hmDic);
        System.out.println(res);
    }
  
}
