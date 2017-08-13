
/**
 * This method returns a double that represents the average temperature of only those temperatures when the humidity was greater than or equal to value.
 * 
 * @Lucy
 * 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Part4_averageTemperatureWithHighHumidityInFile {
    public double averageTemperatureWithHighHumidityInFile (CSVParser parser,int value){
        double sum = 0.0;
        int n = 0;
        for (CSVRecord record: parser){
            String humidityString = record.get("Humidity");
            String temperatureString = record.get("TemperatureF");
            if (!humidityString.equals("N/A")){
                double humidityNumber= Double.parseDouble(humidityString);
                double temperatureNumber= Double.parseDouble(temperatureString);
                if (humidityNumber> value && temperatureNumber!=-9999 ){
                    sum=sum+temperatureNumber;
                    n=n+1;
                }
            }
        }
        if (n==0){
        System.out.println("No temperatures with that humidity");
        return 0;
        } else{
        return sum/n;}    
    }
    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr= new FileResource();
        double averageTemperature= averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80);
        System.out.println("Average Temp when high Humidity is "+averageTemperature);
    }

}
