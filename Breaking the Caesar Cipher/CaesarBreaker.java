
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
    
    
}
