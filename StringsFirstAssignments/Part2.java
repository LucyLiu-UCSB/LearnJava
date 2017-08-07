
/**
 * Upper case and Lower case modification.
 * Lucy
 */
public class Part2 {
        public String findSimpleGene (String dna,String startCodon, String stopCodon){
            String temp=dna.toUpperCase();
        String result="";
        int startIndex = temp.indexOf("ATG");
        if (startIndex == -1) {
            return ""; 
        }
        int stopIndex = temp.indexOf("TAA",startIndex+3);
        if (stopIndex == -1){
            return "";
        }
        if ((stopIndex-startIndex) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex+3);
        } else{
            return "";}

            return result;
    }
    public void testSimpleGene (){
        //             v  v  v  v  v
        String dna = "aatgcgttaataatgg";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna,"a","b");
        System.out.println("Gene is " + gene);
        //       v  v  v  v  v  v  v  v
        dna = "CGATGGTTGAGTAAGCCTAAGCTATAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna,"a","b");
        System.out.println("Gene is " + gene);
        //       v  v  v  v  v  v  v  v
        dna = "CGATGGTTGATAAGCCTAAGCTAAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna,"a","b");
        System.out.println("Gene is " + gene);
    }

}
