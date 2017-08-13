
/**
 * Find the day with Lowest Humidity .
 * 
 * @Lucy
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Part2_LowestHumidity {
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord smallestSoFar = null;
        double currentHumidity = 65.00;
        for (CSVRecord currentRow : parser){
            String currString=currentRow.get("Humidity");
            if (!currString.equals("N/A")){
             currentHumidity = Double.parseDouble(currString);}
            if (smallestSoFar == null && !currString.equals("N/A")){
                smallestSoFar=currentRow;
            }
            if (smallestSoFar != null){
                double smallestHumidity=Double.parseDouble(smallestSoFar.get("Humidity"));
                if (!currString.equals("N/A") && currentHumidity<smallestHumidity){
                    smallestSoFar=currentRow;
                }
            } 
        
        }
    return smallestSoFar;

    }
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }
    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord smallestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        //double currentHumidity = 65.00;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            String currString=currentRow.get("Humidity");
            //if (!currString.equals("N/A")){
            double currentHumidity = Double.parseDouble(currString);//}
            if (smallestSoFar == null && !currString.equals("N/A")){
                smallestSoFar=currentRow;
            }
            if (smallestSoFar != null){
                double smallestHumidity=Double.parseDouble(smallestSoFar.get("Humidity"));
                if (!currString.equals("N/A") && currentHumidity<smallestHumidity){
                    smallestSoFar=currentRow;
                }
            } 
        }
        return smallestSoFar;
    }
    public void testLowestHumidityInManyFiles(){
        CSVRecord smallestHumidity=lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+ smallestHumidity.get("Humidity")+" at "+smallestHumidity.get("DateUTC"));
        
    }
}

