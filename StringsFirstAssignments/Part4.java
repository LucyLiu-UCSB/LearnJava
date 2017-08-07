
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part4 {
    public void URLcheck(){
        URLResource web = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String word: web.words()){
            String temp=word.toLowerCase();
            int startindex=temp.indexOf("youtube.com");
            if (startindex!= -1){
            int quotationStartIndex=temp.lastIndexOf("\"",startindex);
            int quotationStopIndex=temp.indexOf("\"",startindex);
        
            System.out.println(word.substring(quotationStartIndex,quotationStopIndex+1));
        }
            
        }

    }
    
}
