
/**
 * use a StorageResource to store the genes you find instead of printing them out
 * Lucy
 */
import edu.duke.*;
public class Part1 {
     public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currentIndex = dna.indexOf(stopCodon, startIndex+3);
        while (currentIndex != -1){
            int diff = currentIndex-startIndex;
            if (diff % 3 == 0){
                return currentIndex;
            }else{
                currentIndex = dna.indexOf(stopCodon, currentIndex+1);
            }
        }
        return dna.length();
    }
   
    public String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
       
        if (startIndex != -1) {
            int taaIndex=findStopCodon(dna, startIndex,"TAA");
            int tgaIndex=findStopCodon(dna, startIndex,"TGA");
            int tagIndex=findStopCodon(dna, startIndex,"TAG");
            int minIndex = Math.min(taaIndex,Math.min(tagIndex,tgaIndex));
            if (minIndex == dna.length()){
            return "";
        } else {
        return dna.substring(startIndex,minIndex+3);}
        
        } else {
            return "";
        }
        
    }
    public StorageResource getAllGene(String dna){
    StorageResource geneList = new StorageResource();
    String gene=findGene(dna);
    while (true){
        if (gene.isEmpty()){
        break;}
    geneList.add(gene);
    dna=dna.substring(dna.indexOf(gene)+gene.length());
    gene=findGene(dna);
    }
    return geneList;
     }
     public void test(String dna){
        System.out.println("Testing getAllGene on "+ dna);
        StorageResource genelist=getAllGene(dna);
        for (String ge:genelist.data()){
        System.out.println(ge);
    }
    }
    public void testString(){
   test("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        test("");
        test("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
}

    

}
