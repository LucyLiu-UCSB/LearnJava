
/**
 *  Test CaesarCipherTwo.
 * 
 * @Lucy
 * 
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
    public void simpleTests(){
        FileResource fr= new FileResource();
        String message = fr.asString();
        CaesarCipherTwo cct=new CaesarCipherTwo(17,3);
        
        String encrypted=cct.encrypt(message,17,3);
        System.out.println("encrypted is "+encrypted);
        
        String decrypted=cct.decrypt(encrypted);
        System.out.println("decrypted is "+decrypted);
        
        
    
    }

}
