
/**
 * determine the N biggest earthquakes, those with largest magnitude.
 *  
 * @Lucy
 * 
 */
import java.util.*;
public class LargestQuakes {
    public void findLargestQuakes(){
        EarthQuakeParser parser= new EarthQuakeParser();
        String source ="data/nov20quakedata.atom";
        ArrayList <QuakeEntry> list= parser.read(source);
        System.out.println("read data for "+list.size()+ " quakes");
        //int maxIndex=indexOfLargest(list);
        // System.out.println("The index is " +maxIndex+" and information is " +list.get(maxIndex));
        ArrayList <QuakeEntry> maxList= getLargest(list,5);
        for (QuakeEntry qe:maxList){
            System.out.println(qe);
        }
        
    }

    public int indexOfLargest(ArrayList< QuakeEntry> data){
        int maxIndex=0;
        int index=0;
        for (QuakeEntry qe: data){
            if(qe.getMagnitude()>data.get(maxIndex).getMagnitude()){
                maxIndex=index;
            }
            index++;
        }
        return maxIndex;
    }
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> answer=new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy=quakeData;
        for (int j=0;j<howMany;j++){
            int index=indexOfLargest(copy);
            answer.add(copy.get(index));
            copy.remove(index);
        }
        return answer;
    }
}
