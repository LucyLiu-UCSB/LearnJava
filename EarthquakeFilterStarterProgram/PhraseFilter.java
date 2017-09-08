
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter{
    private String where;//“start”, ”end”, or “any”
    private String phrase;
    
    public PhraseFilter( String loca, String info){
        where=loca;
        phrase=info;
    }
    
    public boolean satisfies(QuakeEntry qe){
        boolean answer=false;
        if (where.equals("start")){
              answer= qe.getInfo().substring(0,phrase.length()).equals(phrase);
        }
        if (where.equals("end")){
            String title=qe.getInfo();
             answer= title.substring(title.length()- phrase.length()).equals(phrase);
        }
        if (where. equals("any")){
             answer= qe.getInfo(). indexOf(phrase)!=-1;
        }
        return answer;
    
    }
    
    public String getName(){      
        return "Phrase ";
    }
}
