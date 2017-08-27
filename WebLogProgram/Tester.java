
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("shorttest_log");
        la.printAll();
        // complete method
    }
    public void testUniqueIP(){
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("short-test_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are "+uniqueIPs+"IPs.");
    
    }
    public void testprintAllHigherThanNum(){
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAllHigherThanNum(100);
    
    }
    public void testuniqueIPVisitsOnDay(){
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("weblog-short_log");
        la.uniqueIPVisitsOnDay("Sep 30");
        
    }
      public void testcountUniqueIPsInRange(){
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("short-test_log");
        la.countUniqueIPsInRange(300,399);
    
    }
    public void testcountVisitsPerIP(){
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("short-test_log");
        la.countVisitsPerIP();
    }
    public void testmostNumberVisitsByIP(){
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String, Integer> counts=la.countVisitsPerIP();
        System.out.println(la.mostNumberVisitsByIP(counts));
    }
    public void testiPsMostVisits(){
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String, Integer> counts=la.countVisitsPerIP();
        System.out.println(la.iPsMostVisits(counts));       
    }  
    public void testiPsForDays(){
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("weblog3-short_log");
        System.out.println(la.iPsForDays());
        //HashMap<String, ArrayList<String>> IPsForDays =la.iPsForDays();
        //for (String s:IPsForDays.keySet()){
            //System.out.println(IPsForDays.get(s));
        //}        
    }
    public void testdayWithMostIPVisits(){
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String,ArrayList<String>> ipHashMap=la.iPsForDays();
        System.out.println(la.dayWithMostIPVisits(ipHashMap));
    }
    public void testiPsWithMostVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String,ArrayList<String>> ipMaps=la.iPsForDays();
        la.iPsWithMostVisitsOnDay(ipMaps,"Sep 30");
    }
}
