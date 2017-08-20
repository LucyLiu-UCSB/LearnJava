
/**
 * encrypts a message with two keys and also decrypts the same message.
 * 
 * @Lucy
 * 
 */
public class CaesarCipherTwo {    
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        mainKey1=key1;       
        mainKey2=key2;
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
    public String encryptOne(String input,String shiftedAlphabet) {
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
    
    public String encrypt(String input, int key1, int key2){
    String stringKey1=halfOfString(input,0);
    String stringKey2=halfOfString(input,1);    
    
    String newStringKey1=encryptOne(stringKey1,shiftedAlphabet1);     
    String newStringKey2=encryptOne(stringKey2,shiftedAlphabet2);
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
    
    public String decrypt(String input){
        TestCaesarCipher tcc= new TestCaesarCipher();
        String stringKey1=halfOfString(input,0);
        String stringKey2=halfOfString(input,1);
        int dkey1=tcc.getKey(stringKey1);
        //System.out.println("dkey1 is"+dkey1);
        int dkey2=tcc.getKey(stringKey2);
         //System.out.println("dkey2 is"+dkey2);
        CaesarCipherTwo cct= new CaesarCipherTwo(26-dkey1,26-dkey2);
        String decrypted=cct.encrypt(input,26-dkey1,26-dkey2);
        return decrypted;
    
    }


}
