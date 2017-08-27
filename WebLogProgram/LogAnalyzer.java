
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
     public HashMap<String, Integer>countVisitsPerIP(){
         HashMap<String, Integer> counts= new HashMap<String, Integer>();
         for(LogEntry le:records){
             String IpAddress=le.getIpAddress();
             if(!counts.containsKey(IpAddress)){
                 counts.put(IpAddress,1);
             }else{
                 counts.put(IpAddress,counts.get(IpAddress)+1);
             }             
         }
         System.out.println(counts);
         return counts;
     }
     public int mostNumberVisitsByIP(HashMap<String, Integer> counts){
         int maxCount=0;
         String maxCountIp= null;
         for (String s: counts.keySet()){
             if (counts.get(s)> maxCount) {
                 maxCount=counts.get(s);
                 maxCountIp=s;
             }
         }   
         return maxCount;
     }
     public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts){
         int maxCount=mostNumberVisitsByIP(counts);
         ArrayList<String> IpList=new ArrayList<String>();
         for(String s: counts.keySet()){
             if(counts.get(s)==maxCount){
                IpList.add(s);
                }
         }
         return IpList;
     }
     public HashMap<String, ArrayList<String>> iPsForDays(){
         HashMap<String, ArrayList<String>> IPsForDays= new HashMap<String,ArrayList<String>>();
         for (LogEntry le:records){
           Date d=le.getAccessTime();
           String IpAddress=le.getIpAddress();
           String dString=d.toString();
           String date=dString.substring(4,10);
           ArrayList<String> alist=new ArrayList<String>();
           if(!IPsForDays.containsKey(date)){
            alist.add(IpAddress);
            IPsForDays.put(date,alist);
           } else {
            ArrayList<String> alistExisted=IPsForDays.get(date);
            alistExisted.add(IpAddress);
            IPsForDays.put(date,alistExisted);
           }         
         }
         return IPsForDays;
     }
     
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> iPsForDays){
     int maxCount=0;
     String maxDate=null;
     for (String s : iPsForDays.keySet()){
         ArrayList ipList=iPsForDays.get(s);
         if (ipList.size()>maxCount){
            maxDate=s;
         }
     }
     return maxDate;
     }
     
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> ipMaps, String date){
         ArrayList <String> ipOneDay=ipMaps.get(date);
         HashMap<String, Integer> counts=countVisitsPerIP();
         ArrayList<String> out= iPsMostVisits(counts);
         System.out.println(out);
         return out;
         
     }
}
