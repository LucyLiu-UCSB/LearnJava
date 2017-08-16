
/**
 * a program to transform words from a file into another form, such as replacing vowels with an asterix.
 * 
 * @Lucy
 */
public class WordPlay {
    public String isVowel(char ch){
        String Vowel = "aeiouAEIOU";
        int chIndex=Vowel.indexOf(ch);
        if (chIndex==-1){
        return "false";
        } else{
        return "true";
        }
    }
    public void testisVowel(){
        System.out.println(isVowel('F'));
        System.out.println(isVowel('a'));
        System.out.println(isVowel('U'));
    }

    
    public String replaceVowels(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        String yOrn=null;
        for (int i=0; i<phrase.length();i+=1){
            yOrn=isVowel(phrase.charAt(i));
            if (yOrn.equals("true")) {
                sb.setCharAt(i,ch);
            }
        }
        return sb.toString();
    
    }
    
    public String emphasize(String phrase,char ch){
        StringBuilder sb = new StringBuilder(phrase);
        for (int i=0;i<phrase.length();i=i+2){
            if (sb.charAt(i) == Character.toLowerCase(ch) || sb.charAt(i)==Character.toUpperCase(ch)){
                sb.setCharAt(i,'*');
            }
        }
        for (int i=1;i<phrase.length();i=i+2){
            if (sb.charAt(i)==Character.toLowerCase(ch) || sb.charAt(i)==Character.toUpperCase(ch)){
                sb.setCharAt(i,'+');
            }
        }
        return sb.toString();
        
    }
    
    
    
}















































