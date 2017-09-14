
/**
 * Write a description of Tester here.
 * 
 * @Lucy 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
public class Tester {
    public void testGetFollowsWithFile(){
        MarkovOne markov=new MarkovOne();
        FileResource fr = new FileResource();
        String st=fr.asString();
        st = st.replace('\n',' ');
        markov.setTraining(st);
        
        ArrayList<String> res=markov.getFollows("t");
        System.out.println(res);
        System.out.println("res size is "+ res.size());
        
        
    }
    
    public void testGetFollows(){
        MarkovOne markov= new MarkovOne();
        markov.setTraining("this is a test yes this is a test.");
        ArrayList<String> res=markov.getFollows("t");
        System.out.println(res);
        System.out.println("res size is "+ res.size());
        
    }
}
