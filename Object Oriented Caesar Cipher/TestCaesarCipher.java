
/**
 * Test Object Oriented Caesar Cipher.
 * 
 * @Lucy
 * 
 */
import edu.duke.*;
public class TestCaesarCipher {
    public int[] countLetters(String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int [] counts = new int[26];
        for(int k=0; k<message.length();k++){
        char ch=Character.toLowerCase(message.charAt(k));
        int dex=alphabet.indexOf(ch);
        if(dex!=-1){
            counts[dex]+=1;        
        }
        }
        return counts;
    }
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for (int k = 0;k<vals.length;k++){
            if(vals[k]>vals[maxDex]){
                maxDex=k;            
            }        
        }    
        return maxDex;
    }
    public void simpleTests(){
        FileResource fr= new FileResource();
        String message = fr.asString();
        
        CaesarCipher cc=new CaesarCipher(18);
        String encrypted=cc.encrypt(message);
        System.out.println("encrypted is "+encrypted);
        String decrypted=cc.decrypt(encrypted);
        System.out.println("decrypted is "+decrypted);
        String decryptedAuto=breakCaesarCipher(encrypted);
        System.out.println("decryptedAuto is "+decryptedAuto);
    }
    
    public int getKey(String s){
        int [] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey=maxDex-4;
        if (maxDex<4){
            dkey=26-(4-maxDex);
        }
        return dkey;    
    }
    public String breakCaesarCipher(String input){
        int dkey=getKey(input);
        CaesarCipher cc=new CaesarCipher(dkey);
        String decrypted=cc.decrypt(input);
        return decrypted;
    }

}
