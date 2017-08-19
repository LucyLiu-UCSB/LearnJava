
/**
 * Caesar Cipher Two Keys Decrypt
 * 
 * @Lucy 
 * 
 */
public class CaesarBreaker {
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
    public String decrypt(String encrypted, int key){
        CaesarCipher cc=new CaesarCipher();
        String message = cc.encrypt(encrypted, 26 - key);
        return message;
    }
    
    public void testDecrypt(String encrypted, int key){
        String message = decrypt(encrypted,key);
        System.out.println(message);
    }
    
    public String halfOfString(String message, int start){
        String halfMessage="";
        for (int k= start; k<message.length();k++){
            if ((k-start)%2==0) {
                halfMessage=halfMessage+message.charAt(k);            
            }
        }
        return halfMessage;
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
    public String decryptTwoKeys(String encrypted){
         CaesarCipher cc=new CaesarCipher();
         String halfString1=halfOfString(encrypted,0);
         String halfString2=halfOfString(encrypted,1);
         int key1=getKey(halfString1);
         int key2=getKey(halfString2);
         System.out.println("key1 is "+ key1+" and key2 is "+key2);
         String decrypted=cc.encryptTwoKeys(encrypted,26-key1,26-key2);
         return decrypted;
    }
}
