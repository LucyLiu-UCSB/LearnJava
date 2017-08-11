
/**
 * write a method to determine how many occurrences of a string appear in another string.
 * 
 * Lucy
 * 
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int startindex=stringb.indexOf(stringa);
        int times=0;
        while (true) {
        if (startindex == -1){
        return times;} 
        times=times+1;
        stringb=stringb.substring(startindex+stringa.length());
        startindex=stringb.indexOf(stringa);
        }
        
    }
    public void testHowMany(){
        String stringa="GAA";
        String stringb="ATGAACGAATTGAATC";
        System.out.println(howMany(stringa,stringb));
        stringa="AA";
        stringb="ATAAAAA";
        System.out.println(howMany(stringa,stringb));
    }

}
