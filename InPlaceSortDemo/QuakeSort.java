import java.util.*;

public class QuakeSort {
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i = from +1; i < quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
        //count from 0 to < in.size()
        for(int i = 0; i < in.size(); i++) {
            /* find the index of the smallest quake*/
            int minIdx = getSmallestMagnitude(in, i);
            /* swap the ith quake with the minIdxth quake */
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i, qmin);
            in.set(minIdx, qi);
        }
    }
    
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
        for(int i = 0; i < in.size(); i++) {
            /* find the index of the smallest quake*/
            if (checkInSortedOrder(in)){
                System.out.println("Passes number is "+i);
                break;
            }
            int minIdx = getSmallestMagnitude(in, i);
            /* swap the ith quake with the minIdxth quake */
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i, qmin);
            in.set(minIdx, qi);
        }
    }
    /* tester method to use in BlueJ */
    public void testSort(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/earthquakeDataSampleSix1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //sortByMagnitude(list);
        //sortByLargestDepth(list);
        //sortByMagnitudeWithBubbleSort(list);
        //sortByMagnitudeWithBubbleSortWithCheck(list);
        sortByMagnitudeWithCheck(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes){
        for(int i=0;i<quakes.size()-2;i++){
            if (quakes.get(i).getMagnitude() > quakes.get(i+1).getMagnitude()){
                return false;
            }
        }
        return true;
    }
    
    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData,int numSorted){
        for (int i = 0; i<quakeData.size()-numSorted-1;i++){
            if (quakeData.get(i).getMagnitude()>quakeData.get(i+1).getMagnitude()){
                QuakeEntry small=quakeData.get(i+1);
                QuakeEntry big=quakeData.get(i);
                quakeData.set(i,small);
                quakeData.set(i+1, big);
            }
        }
    }
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        for(int i =0;i<(in.size()-1);i++){
            onePassBubbleSort(in, i);
        }
    }
    
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in ){
        for(int i =0; i<in.size()-1;i++){
            if (checkInSortedOrder(in)){
                System.out.println("Passes number is "+i);
                break;
            }
            onePassBubbleSort(in, i);
        }
    }
    
    public int getLargestDepth (ArrayList<QuakeEntry> quakeData, int from){
        int maxInx=from;
        for (int i=from +1; i<quakeData.size();i++){
            if(quakeData.get(i).getDepth()>quakeData.get(maxInx).getDepth()){
                maxInx=i;
            }
        }
        return maxInx;
    }
    public void sortByLargestDepth(ArrayList<QuakeEntry>quakeData){
        for (int i=0;i<quakeData.size();i++){
            int maxInx=getLargestDepth(quakeData, i);
            QuakeEntry qi=quakeData.get(i);
            QuakeEntry qMax=quakeData.get(maxInx);
            quakeData.set(i,qMax);
            quakeData.set(maxInx,qi);            
        }
    }
}
