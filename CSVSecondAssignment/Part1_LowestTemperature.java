
/**
 Find the coldest temperature in any number of files of CSV weather data chosen by the user.
 * 
 * 
 * @Lucy
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Part1_LowestTemperature {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord smallestSoFar = null;
        for (CSVRecord currentRow : parser){
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            if (smallestSoFar == null && currentTemp!=-9999){
                smallestSoFar=currentRow;
            }
            if (smallestSoFar != null){
                double smallestTemp=Double.parseDouble(smallestSoFar.get("TemperatureF"));
                if (currentTemp !=-9999 && currentTemp<smallestTemp){
                    smallestSoFar=currentRow;
                }
            } 
            
            
        }
        return smallestSoFar;
    }
  
    public void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVRecord smallest= coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was "+smallest.get("TemperatureF")+" at "+smallest.get("TimeEST"));
        
    }
    
    public File fileWithColdestTemperature(){
        //CSVRecord smallestSoFar = null;
        File frSofar = null;
        FileResource frFileRe= null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            if( frSofar== null){
                //FileResource frCurrent1= new FileResource(f);
                frSofar=f;
            }
             frFileRe=new FileResource(frSofar);
            FileResource frCurrent= new FileResource(f);
            CSVRecord smallestSoFar= coldestHourInFile(frFileRe.getCSVParser());
            CSVRecord currentLow= coldestHourInFile(frCurrent.getCSVParser());
            double smallestTemp=Double.parseDouble(smallestSoFar.get("TemperatureF"));
            double currentTemp=Double.parseDouble(currentLow.get("TemperatureF"));
            
            if (currentTemp<smallestTemp){
                frSofar=f;
            }
                // 
            
            
        }
   
        return frSofar;
        
    }
    
    
    public void testFileWithColdestTemperature() {
        File coldFile=fileWithColdestTemperature();
        FileResource coldestday=new FileResource(coldFile);
        CSVRecord smallestSoFar= coldestHourInFile(coldestday.getCSVParser());
        System.out.print("Coldest day was in file ");
        System.out.println(coldFile);
        System.out.println("Coldest temperature on that day was "+ smallestSoFar.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        for (CSVRecord record: coldestday.getCSVParser()){
        System.out.println(record.get("DateUTC")+": "+record.get("TemperatureF"));
        }
        
        
    }
    

}

































