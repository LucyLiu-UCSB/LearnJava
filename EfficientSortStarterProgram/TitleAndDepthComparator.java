
/**
 *  a Comparator to sort earthquakes by title first and break ties by depth.
 * 
 * @Lucy 
 * @version (a version number or a date)
 */

import java.util.*;
public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2){
        String title1=q1.getInfo();
        String title2=q2.getInfo();
        
        if(title1.compareTo(title2)<0){
            return -1;
        }
        
        if (title1.compareTo(title2)>0){
            return 1;
        }
        
        if(title1.compareTo(title2)==0){
            double depth1=q1.getDepth();
            double depth2=q2.getDepth();
            return Double.compare(depth1,depth2);
        }
        return 0;
    }

}
