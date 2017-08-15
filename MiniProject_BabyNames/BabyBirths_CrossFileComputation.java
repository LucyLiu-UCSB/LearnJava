
/**
 * This scripts investigate the Name of newly birthed babys accross CSV files
 * 
 * @Lucy
 *
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BabyBirths_CrossFileComputation {
    public int getRank(File f, String name, String gender){
        int rank=-1;
        int genderRank=0;
   
        FileResource fr= new FileResource(f);
    
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
    
    
    public int yearOfHighestRank(String name, String gender){
        DirectoryResource fr= new DirectoryResource();
        int rankSofar=-1;
        String fileName = null;
        for(File f:fr.selectedFiles()){
            int currentRank=getRank(f,name,gender);
           
            if (rankSofar==-1){
                rankSofar = currentRank;
                fileName=f.getName();
            } else {
            if (currentRank< rankSofar){
                rankSofar = currentRank;
                fileName=f.getName();                
            }            
            }
            //System.out.println(fileName.substring(3,7));
        }
        if (rankSofar==-1){
        return -1;}
        else{
            String year=fileName.substring(3,7);
            return Integer.parseInt(year);
        }
    }
    
    public double getAverageRank(String name, String gender){
        DirectoryResource fr= new DirectoryResource();
        int count = 0;
        int rankSum = 0;
        for (File f : fr.selectedFiles()){
            int currentRank= getRank(f, name, gender);
            if (currentRank !=-1){
                count+=1;
                rankSum=rankSum+currentRank;
            }
        }
        if(count==0){
        return -1.0;
        } else {
        return (float)rankSum/count;}
        
       
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
    String frAddress="testing/yob"+year+"short.csv";
    FileResource fr= new FileResource(frAddress);
    int sumBirth=0;
    for (CSVRecord record : fr.getCSVParser(false)){
        String currentGender=record.get(1);
        String currentName=record.get(0);
        if (currentGender.equals(gender)){
        sumBirth=sumBirth+Integer.parseInt(record.get(2));
        //System.out.println(sumBirth);
        }
        
        if (currentName.equals(name)){
        sumBirth=sumBirth-Integer.parseInt(record.get(2));
        break;    
        }
    }
    return sumBirth;
    }

}













