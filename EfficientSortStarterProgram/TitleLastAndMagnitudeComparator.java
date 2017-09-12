
/**
 * a Comparator to sort earthquakes by the last word in their title first and break ties by magnitude.
 * 
 * @Lucy 
 * @version (a version number or a date)
 */
import java.util.*;
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1,QuakeEntry q2){
        String[] arr1=q1.getInfo().split("\\W+");
        String[] arr2=q2.getInfo().split("\\W+");
        String lastWord1=arr1[arr1.length-1];
        String lastWord2=arr2[arr2.length-1];
        if (lastWord1.compareTo(lastWord2)<0){
        return -1;}
        if (lastWord1.compareTo(lastWord2)>0){
        return 1;}
        if (lastWord1.compareTo(lastWord2)==0){
        return Double.compare(q1.getMagnitude(),q2.getMagnitude());
        }
        return 0;
    }
}
