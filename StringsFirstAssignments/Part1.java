
/**
 * Find specific "word" in strings
 *
 * Lucy
 */
public class Part1 {
    public String findSimpleGene (String dna){
        String result="";
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return ""; 
        }
        int stopIndex = dna.indexOf("TAA",startIndex+3);
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
        String dna = "AATGCGTTAATTAATCG";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        //       v  v  v  v  v  v  v  v
        dna = "CGATGGTTGATAAGCCTAAGCTATAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        //       v  v  v  v  v  v  v  v
        dna = "CGATGGTTGATAAGCCTAAGCTAAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    }
}


























