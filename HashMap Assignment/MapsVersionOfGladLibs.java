
/**
 * use one HashMap that maps word types to ArrayList of possible words to select.
 * 
 * @Lucy
 * 
 */
import edu.duke.*;
import java.util.*;


public class MapsVersionOfGladLibs {
    private HashMap<String,ArrayList<String>> myMap;
    private ArrayList<String> usedList;
    private Random myRandom;
    private ArrayList<String> usedCategory;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    //public GladLib(){
        //initializeFromSource(dataSourceDirectory);
        //myRandom = new Random();
    //}
    
    public MapsVersionOfGladLibs(String source){
        myMap= new HashMap<String,ArrayList<String>>();
        initializeFromSource(source);
       
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        String [] labels={"adjective","noun","color","country","name","animal","timeframe","verb","fruit",};
        for (String s: labels){
            ArrayList<String> list=readIt(source+"/"+s+".txt");
           // System.out.println(list);
            myMap.put(s,list);
        }
        usedList = new ArrayList<String> ();
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }

        return randomFrom(myMap.get(label));
    }
    
    private String processWord(String w){
        usedCategory.clear();
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        } else {
        usedCategory.add(w);
        }
        
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while (true){
            sub = getSubstitute(w.substring(first+1,last));
            if (usedList.contains(sub)==false){
                usedList.add(sub);
                break;
            }
        } 
            
        
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        usedList.clear();
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\n");
        System.out.println(usedList.size());
    }
    
    public void totalWordsInMap(){
        int num=0;
        for(String s:myMap.keySet()){
            ArrayList<String> al=myMap.get(s);
            num=num+al.size();
         }
         System.out.println(num);
    }
    public void totalWordsConsidered(){
        int num=0;
        for (String s: usedCategory){            
            ArrayList<String> al=myMap.get(s);
            num=num+al.size();
        }
        System.out.println("used lists have "+num+" words in total.");
    }


}
