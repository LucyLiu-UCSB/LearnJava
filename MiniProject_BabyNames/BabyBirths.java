
/**
 * Investigate the names of newly birthed babys
 * 
 * @Lucy
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BabyBirths {
    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int girlNames = 0;
        int boyNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                boyNames+=1;                
            }
            else {
                totalGirls += numBorn;
                girlNames+=1;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("number of female names = " + girlNames);
        System.out.println("male boys = " + totalBoys);
        System.out.println("number of male names = " + boyNames);

    }
    public void testtotalBirths(){
        FileResource fr= new FileResource();
        totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender){
        int rank=-1;
        int genderRank=0;
        String frAddress="testing/yob"+year+"short.csv";
        FileResource fr= new FileResource(frAddress);
    
        //FileResource fr= new FileResource();
        for(CSVRecord record:fr.getCSVParser(false)){            
            String currentGender=record.get(1);            
            String currentName=record.get(0);
            //System.out.println(currentName);
            if( currentGender.equals(gender)){
                genderRank+=1;
               // System.out.println(genderRank);
                
            }
            if (currentName.equals(name)&&currentGender.equals(gender)){
                rank=genderRank;
                break;
            }
            
        }
        return rank;
        
    }
    public String getName(int year, int rank, String gender){
        String name="No Name";
        String frAddress="testing/yob"+year+"short.csv";
        FileResource fr= new FileResource(frAddress);
    
        int numberLine=0;
        for (CSVRecord record:fr.getCSVParser(false)){
            String currentGender=record.get(1);
            if (currentGender.equals(gender)){
                numberLine+=1;     
            }
            if (currentGender.equals(gender) && numberLine==rank){
            name=record.get(0);
            break;
            }            
        }
        return name;
    }
    public void whatIsNameInYear(String name, int year, int newYear,String gender){        
        int rank=getRank(year,name,gender);
        String newname=getName(newYear, rank, gender);
        System.out.println(name+" born in "+year+" would be "+newname+" if she or he was born in "+newYear);
    }
    
    
}































