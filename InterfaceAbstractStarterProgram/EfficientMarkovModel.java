
/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @Lucy
 * @version (a version number or a date)
 */
import java.util.*;
public class EfficientMarkovModel extends AbstractMarkovModel{
    private int keyLength;
    private  HashMap<String,ArrayList<String>> hashMap;
    public EfficientMarkovModel(int N) {
        hashMap = new HashMap<String,ArrayList<String>>();
        keyLength=N;
        
    }
    
    public ArrayList<String> getFollows(String key){
            int pos=myText.indexOf(key);
            String next= "";
            String subString=myText;
            ArrayList<String> res=new ArrayList<String>();
            while (pos!=-1 && pos<subString.length()-key.length()){  
                next=subString.substring(pos+key.length(),pos+key.length()+1);
                res.add(next);            
                subString=subString.substring(pos+1);
                pos=subString.indexOf(key);
            }
            return res;
    }
    
    public void buildMap(){
        String key="";
        key = myText.substring(0,0+keyLength);
        
        hashMap.put(key,getFollows(key));
        
        for (int i=1; i< myText.length()-keyLength+1;i++){
        key = myText.substring(i,i+keyLength);
        if (!hashMap.containsKey(key)){
        hashMap.put(key,getFollows(key));
           }   
            //return hashMap;
        }
    }
    public void printHashMapInfo(){
        System.out.println(hashMap);
        System.out.println("The size of hashMap is "+hashMap.size());
        String maxKey=myText.substring(0,keyLength);
        ArrayList<String> maxArrayList=hashMap.get(maxKey);
        for (String s:hashMap.keySet()){
          if(hashMap.get(s).size()>maxArrayList.size()){
              maxKey=s;
              maxArrayList=hashMap.get(maxKey);
          }
        }
        System.out.println("The maximum size of ArrarList is "+maxArrayList.size());
        System.out.println("Key, "+maxKey+", has the maximum ArrayList");
    }
    public String getRandomText(int numChars){        
        String hkey="";
        hkey = myText.substring(0,0+keyLength);
        
        hashMap.put(hkey,getFollows(hkey));
        
        for (int i=1; i< myText.length()-keyLength+1;i++){
        hkey = myText.substring(i,i+keyLength);
        if (!hashMap.containsKey(hkey)){
        hashMap.put(hkey,getFollows(hkey));
           }  
        }   
        
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-keyLength);;
        String key=myText.substring(index,index+keyLength);
        sb.append(key);
        ArrayList<String> follows= new  ArrayList<String> ();
        for(int k=0; k < numChars-keyLength; k++){
           if(hashMap.containsKey(key)){ 
               follows=hashMap.get(key);
               index=myRandom.nextInt(follows.size());
               String next=follows.get(index);
               sb.append(next);
               key=key.substring(1)+next;
           } else{
               break;
           }
          
        }
        return sb.toString();
    }
    
    
    public String toString(){        
        return "MarkovModel of order"+keyLength ;  
    }
}
