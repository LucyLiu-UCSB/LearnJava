
/**
 * Write a description of Practice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Practice {

public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
            //System.out.println(index);
           System.out.println(found);
           index = input.indexOf("abc",index+3);
           //System.out.println(index);
       }
   }

   public void test(){
       //findAbc("abcd");
       findAbc("abcabcabcabca");
   }

}
