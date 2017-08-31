
/**
 * Test methods for Vigenere Program
 * 
 * @Lucy
 * 
 */

import java.util.*;
import edu.duke.*;

public class Tester {
    public void testCaesarCipher(){
        FileResource fr = new FileResource("VigenereTestData/titus-small.txt");
        String frString=fr.asString();
        CaesarCipher cc= new CaesarCipher(5);
        String encrypt=cc.encrypt(frString);
        String decrypt=cc.decrypt(encrypt);
        System.out.println(encrypt);
        System.out.println(decrypt);
        
    }
    
    public void testCaesarCracker(){
        FileResource fr = new FileResource("VigenereTestData/oslusiadas_key17.txt");
        String frString=fr.asString();
        CaesarCracker cc= new CaesarCracker('a');
        String decrypt=cc.decrypt(frString);
        
        //System.out.println(encrypt);
        System.out.println(decrypt);
        
    }
    
    public void testVigenereCracker(){
        FileResource fr = new FileResource("VigenereTestData/titus-small.txt");
        String frString=fr.asString();
        int[] code={17,14,12,4};
        VigenereCipher cc= new VigenereCipher(code);
        String encrypt=cc.encrypt(frString);
        String decrypt=cc.decrypt(encrypt);
        System.out.println(encrypt);
        System.out.println(decrypt);
    }
    
    public void testtryKeyLength(){    
        FileResource fr = new FileResource("VigenereTestData/athens_keyflute.txt");
        String frString=fr.asString();
        VigenereBreaker vb= new VigenereBreaker();
        int[] keys= vb.tryKeyLength(frString,5,'e');
        for(int i=0;i<keys.length;i++){
             System.out.println(keys[i]);
        }      
    }
    public void testbreakForLanguage() {
        FileResource fr=new FileResource();
        String encrypted= fr.asString();
        VigenereBreaker vb=new VigenereBreaker(); 
        FileResource FileReDic=new FileResource("dictionaries/English");
        HashSet<String> dic=vb.readDictionary(FileReDic);
        String decrypted=vb.breakForLanguage(encrypted,dic);
        System.out.println(decrypted);
    
        
    }

}
