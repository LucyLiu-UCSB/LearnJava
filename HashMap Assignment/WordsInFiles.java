
/**
 * Write a program to determine which words occur in the greatest number of files, and for each word, which files they occur in.
 * 
 * @Lucy 
 * 
 */
import edu.duke.*;
import java.util.*;
import java.io.*;

public class WordsInFiles {
    private HashMap< String, ArrayList<String>> fileWord;
    public WordsInFiles(){
        fileWord = new HashMap< String, ArrayList<String>>();
    }
    public void addWordsFromFile(File f){
        FileResource fr =new FileResource(f);
        for(String w:fr.words()){
            if (fileWord.containsKey(w)) {
                ArrayList<String> fn=fileWord.get(w);
                fn.add(f.getName());
                fileWord.put(w,fn);
            }else{
                ArrayList<String> wal=new ArrayList<String>();
                wal.add(f.getName());
                fileWord.put(w,wal);
            }
        }
    }
    public void buildWordFileMap(){
        fileWord.clear();
        DirectoryResource dr= new DirectoryResource();
        for (File f: dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    public int maxNumber(){
        int maxNO=0;
        for(String w:fileWord.keySet()){
            ArrayList<String> al=fileWord.get(w);
            int temp=al.size();
            if(temp>maxNO){
                maxNO=temp;
            }
        }
        return maxNO;
    }
    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> outs= new ArrayList<String>();
        for(String w:fileWord.keySet()){
            ArrayList<String> al=fileWord.get(w);
            int temp=al.size();
            if(temp==number){
            outs.add(w);
            }
            
        }
        //System.out.println(outs);
        return outs;
    }
    public void printFilesIn(String w){
        ArrayList<String> al=fileWord.get(w);
        for ( String s:al){
            System.out.println(s);
        }
        
    }

    }
