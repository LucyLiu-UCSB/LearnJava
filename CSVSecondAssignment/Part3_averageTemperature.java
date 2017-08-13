
/**
 * This method returns a double that represents the average temperature in the file. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Part3_averageTemperature {
    public double averageTemperatureInFile (CSVParser parser){
        double sum=0.0;
        int n=0;
        for (CSVRecord record:parser){
            double currentTemp=Double.parseDouble(record.get("TemperatureF"));
            if(currentTemp !=-9999){
            sum=sum+currentTemp;
            n=n+1;
        }
        }
        return sum/n;
        
    }
    public void  testAverageTemperatureInFile() {
        FileResource fr=new FileResource();
        double averageTemp=averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is "+averageTemp);
    }

}
