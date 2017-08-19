
/**
 *  Caesar Cipher algorithm.
 * 
 * @Lucy
 * 
 */
import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input,int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabetUpper = alphabetUpper.substring(key)+
        alphabetUpper.substring(0,key);
        String shiftedAlphabetLower = alphabetLower.substring(key)+
        alphabetLower.substring(0,key);
        for (int i=0; i<encrypted.length();i+=1){
        char currChar = encrypted.charAt(i);
        if (Character.isUpperCase(currChar)) {
            int idx = alphabetUpper.indexOf(currChar);
            if (idx !=-1){
            char newChar = shiftedAlphabetUpper.charAt(idx);
            encrypted.setCharAt(i,newChar);        
        } 
        }else{
            int idx = alphabetLower.indexOf(currChar);
            if (idx !=-1){
            char newChar = shiftedAlphabetLower.charAt(idx);
            encrypted.setCharAt(i,newChar);        
        }
        }
   
    }
        return encrypted.toString();
    }
    
    public void testCaesar(){
    FileResource fr = new FileResource();
    String message = fr.asString();
    String encrypted = encrypt(message, 2);
    System.out.println("key is " + 2 + "\n" + encrypted);
    }
    public String encryptTwoKeys(String input, int key1, int key2){
    String stringKey1="";
    String stringKey2="";
    for (int i=0;i<input.length();i++){
    if(i%2==0){
        stringKey1=stringKey1+input.charAt(i);        
    } else{
        stringKey2=stringKey2+input.charAt(i);    
    }
    }
    String newStringKey1=encrypt(stringKey1,key1);     
    String newStringKey2=encrypt(stringKey2,key2);
    String encryptWord="";
    for(int i=0;i<input.length();i++){
    if(i%2==0){
        encryptWord=encryptWord+newStringKey1.charAt(i/2);
      
    }else{
        encryptWord=encryptWord+newStringKey2.charAt(i/2);
      
    }
    }
    return encryptWord;
    }

   }
























