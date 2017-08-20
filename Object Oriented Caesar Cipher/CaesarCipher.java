
/**
 * Object Oritented CaesarCipher here.
 * 
 * @Lucy
 * 
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        mainKey=key;
    }
  
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        //String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = alphabet.toLowerCase();
        //String shiftedAlphabetUpper = alphabetUpper.substring(key)+alphabetUpper.substring(0,key);
        String shiftedAlphabetLower = shiftedAlphabet.toLowerCase();
        
        for (int i=0; i<encrypted.length();i+=1){
        char currChar = encrypted.charAt(i);
        if (Character.isUpperCase(currChar)) {
            int idx = alphabet.indexOf(currChar);
            if (idx !=-1){
            char newChar = shiftedAlphabet.charAt(idx);
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
    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        String decrypted=cc.encrypt(input);
        return decrypted;
    }

}
