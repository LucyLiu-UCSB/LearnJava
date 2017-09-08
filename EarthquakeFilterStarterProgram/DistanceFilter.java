
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter {
    private Location loc;
    private double disMax;
    public DistanceFilter(Location location, double max){
        loc=location;
        disMax=max;
    }
    
    public boolean satisfies(QuakeEntry qe){
        return qe.getLocation().distanceTo(loc)< disMax;
    }
    public String getName(){
        return "Distance ";
    }

}
