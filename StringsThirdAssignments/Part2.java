
/**
 * Write the method cgRatio that has one String parameter dna, and returns the ratio of C’s and G’s in dna as a fraction of the entire strand of DNA. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int charaterTime(String dna, String Cha){
        int times=0;
        int startIndex=dna.indexOf(Cha);
        while(true){
            if (startIndex==-1){
            break;}
            times=times+1;
            startIndex=dna.indexOf(Cha,startIndex+1);
        }
        return times;
    }
     public float cgRatio(String dna){
        float totalCG=charaterTime(dna,"C")+charaterTime(dna,"G");
        float ratio=totalCG/dna.length();
        return ratio;
    }
    public int countCTG(String dna){
        int times=0;
        int startIndex=dna.indexOf("CTG");
        while(true){
        if(startIndex==-1){
            break;
        }
        times=times+1;
        startIndex=dna.indexOf("CTG",startIndex+3);
        }
        return times;      
    }
   

}
