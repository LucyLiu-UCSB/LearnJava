
/**
 * Write a program to find out how many times each codon occurs in a strand of DNA based on reading frames.
 * 
 * @Lucy
 * 
 */
import edu.duke.*;
import java.util.*;


public class CodonCount {
    private HashMap<String, Integer> mymap;
    public CodonCount(){
        mymap = new HashMap<String,Integer>();
    }
    public void buildCodonMap(int start, String dna){
        mymap.clear();
        //System.out.println(mymap);
        String DNA=dna.toUpperCase();
        //System.out.println(DNA);
        String codon="";
        for(int k=start;(k+2)<dna.length();k=k+3){
            codon=DNA.substring(k,k+3);
            
            if ( !mymap.containsKey(codon) ){
                mymap.put(codon,1);
            }
            else {
                mymap.put(codon,mymap.get(codon)+1);
            }            
        }
    }
    public String getMostCommonCodon(){
        int maxCount=0;
        String codon="";
        for(String s: mymap.keySet()){
            if (mymap.get(s)>maxCount){
            maxCount=mymap.get(s);
            codon=s;
            }
        }
        return codon;
    }
    public void printCodonCounts(int start, int end){
        for (String s :mymap.keySet()){
            if(mymap.get(s)>=start && mymap.get(s)<=end){
                System.out.println(s+"\t"+mymap.get(s));
            }
         }
    }
    public void tester(){
        FileResource fr = new FileResource();
        String dna=fr.asString();
        String DNA=dna.trim();
        int start=1;
        int end =5;
        buildCodonMap(0,DNA);
         
        int read0=mymap.size();
        String most0=getMostCommonCodon(); 
        System.out.println("Reading frame starting with 0 results in "+ read0+ "unique codons");
        System.out.println("and most common codon is "+ most0+" with count "+mymap.get(most0));
        System.out.println("Counts of codons between" +start+" and "+end+" inclusive are:");
        printCodonCounts(1,5);
        
        buildCodonMap(1,DNA);
        int read1=mymap.size();
        String most1=getMostCommonCodon(); 
        System.out.println("Reading frame starting with 1 results in "+ read1+ "unique codons");
        System.out.println("and most common codon is "+ most1+" with count "+mymap.get(most1));
        System.out.println("Counts of codons between" +start+" and "+end+" inclusive are:");
        printCodonCounts(1,5);
        
        buildCodonMap(2,DNA);
        int read2=mymap.size();
        String most2=getMostCommonCodon(); 
        System.out.println("Reading frame starting with 2 results in "+ read2+ "unique codons");
        System.out.println("and most common codon is "+ most2+" with count "+mymap.get(most2));
        System.out.println("Counts of codons between" +start+" and "+end+" inclusive are:");
        printCodonCounts(1,5);
    }

     }
