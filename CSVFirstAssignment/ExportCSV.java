
/**
 * The CSV file exportdata.csv has information on the export products of countries
 * 
 * @Lucy 
 * 
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class ExportCSV {
    public CSVParser tester ( ){
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        return parser;
    }
    public String countryInfo(CSVParser parser, String country){
        String export="NOT FOUND";
        for (CSVRecord record:parser){
            String coun=record.get("Country");
            
            if(coun.contains(country)){
            export=record.get("Exports");
            String value=record.get("Value (dollars)");
            export=country+": "+export+": "+value;
             }
        }
        System.out.println(export);
        return export;
         
    }
    public void countryInfoTest(){
        CSVParser parser=tester();
        countryInfo(parser,"Nauru");
    }
    public void listExportsTwoProducts(CSVParser parser,String exportItem1,String exportItem2){
        for (CSVRecord record : parser){
            String export=record.get("Exports");
            if (export.contains(exportItem1)&(export.contains(exportItem2))) {
                System.out.println(record.get("Country"));
            }
        }
    }
    public void listExportsTwoProductsTest(){
        CSVParser parser=tester();
        listExportsTwoProducts(parser,"gold","diamonds");
    }
    public int numberOfExporters (CSVParser parser,String exportItem){
        int num=0;
        for (CSVRecord record:parser){
            String export=record.get("Exports");
            if(export.contains(exportItem)){
            num=num+1;}
        }
        return num;
    }
    public void numberOfExportsTest(){
        CSVParser parser=tester();
        System.out.println(numberOfExporters(parser,"sugar"));
    }
    public void bigExporters(CSVParser parser, String dollar){
        //CSVParser parser=tester();
        for(CSVRecord record:parser){
        String value=record.get("Value (dollars)");
        if (value.length()>dollar.length()){
            String country=record.get("Country");      
            System.out.println(country+" "+value);
         }
        
    }
    }
    public void bigExportersTest(){
        CSVParser parser=tester();
        bigExporters(parser,"$999,999,999,999");
    
    }

}
















