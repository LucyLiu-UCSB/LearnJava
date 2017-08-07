
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public Boolean twoOccurrences (String stringa, String stringb){
    int startIndex=stringb.indexOf(stringa);
    if (startIndex==-1){
    return false;
    } else {
    int secondIndex=stringb.indexOf(stringa,startIndex+stringa.length());
    if (secondIndex== -1){
    return false;
    } else{ return true;} 
    }
    }
    public void testing(){
        String stringa= "an";
        String stringb="banana";
        Boolean res=twoOccurrences(stringa, stringb);
        System.out.println(res);
        System.out.println("The part of the string after "+stringa+" in "+stringb+" is "+lastPart(stringa,stringb));
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
        stringa="zoo";
        stringb="forest";
        res=twoOccurrences(stringa, stringb);
        System.out.println(res);System.out.println("The part of the string after "+stringa+" in "+stringb+" is "+lastPart(stringa,stringb));
      
        
    }
    public String lastPart(String stringa, String stringb){
    int startIndex=stringb.indexOf(stringa);
    if (startIndex==-1){
        return stringb;
    } else{
        return stringb.substring(startIndex+stringa.length(),stringb.length());
    }
   
    }
}
