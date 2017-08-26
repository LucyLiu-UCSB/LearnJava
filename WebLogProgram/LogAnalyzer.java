
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @Lucy
 * 
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
        records=new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr=new FileResource(filename);
         for (String line:fr.lines()){
             records.add(WebLogParser.parseEntry(line));
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     public int countUniqueIPs(){
        ArrayList<String> uniqueIPs = new ArrayList< String>();
        for (LogEntry le:records){
            String ipAddr = le.getIpAddress();
            if(!uniqueIPs.contains(ipAddr)){
            uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
     }
     
     public void printAllHigherThanNum(int num){
         for (LogEntry le:records){
            int statusCode = le.getStatusCode();
            if (statusCode> num){
            System.out.println(le);
            } 
         }        
     }
     
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){ //MMM DD
         ArrayList<String> ipAddress= new ArrayList<String>();            
         for (LogEntry le:records){
             Date d=le.getAccessTime();
             String IpAddress=le.getIpAddress();
             String dString=d.toString();             
             if ((dString.indexOf(someday)!=-1) && (!ipAddress.contains(IpAddress))){
                 ipAddress.add(IpAddress);                 
             }
         }
         System.out.println(ipAddress);
         return ipAddress;        
     }
     public int countUniqueIPsInRange(int low, int high){
          ArrayList<String> ipAddress= new ArrayList<String>();            
         for (LogEntry le:records){
             int statusCode = le.getStatusCode();
             String IpAddress=le.getIpAddress();
                      
             if ((statusCode>=low && statusCode<=high)&&(!ipAddress.contains(IpAddress))){
                 ipAddress.add(IpAddress);                 
             }
         }
         System.out.println(ipAddress);
         return ipAddress.size();        
     }
     
     
}
