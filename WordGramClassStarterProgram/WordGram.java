
public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        // TODO: Complete this method
        if (myWords==null){
            return 0;
        }else{
            return myWords.length;
        }
    }
    
    public int hashCode(){
        String ret = "";
        for (String s:myWords){
            ret=ret+s+" ";
        }
        return ret.trim().hashCode();
    }

    public String toString(){
        String ret = "";
        for (String s:myWords){
            ret=ret+s+" ";
        }
        // TODO: Complete this method
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        // TODO: Complete this method
        if (myWords.length!=other.length()){
            return false;
        }
        for(int k =0;k<myWords.length;k++){
            if( !myWords[k].equals(other.wordAt(k))){
                return false;
            }
        }
        return true;

    }

    public WordGram shiftAdd(String word) { 
        String[] res=new String[myWords.length];
        for (int k =0;k<myWords.length-1;k++){
            res[k]=myWords[k+1];
        }
        res[myWords.length-1]=word;
        WordGram out = new WordGram(res, 0, myWords.length);
        
       
        // shift all words one towards 0 and add word at the end. 
        // you lose the first word
        // TODO: Complete this method
        return out;
    }

}