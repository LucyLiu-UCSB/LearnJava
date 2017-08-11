
/**
 * Find all the genes (where the stop codon could be any of the three stop codons) in a strand of DNA.
 * 
 * Lucy
 */
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
            int taaIndex=findStopCodon(dna, startIndex+3,"TAA");
            int tgaIndex=findStopCodon(dna, startIndex+3,"TGA");
            int tagIndex=findStopCodon(dna, startIndex+3,"TAG");
            int minIndex = Math.min(taaIndex,Math.min(tagIndex,tgaIndex));
            if (minIndex == dna.length()){
            return "";
        } else {
        return dna.substring(startIndex,minIndex+3);}
        
        } else {
            return "";
        }
        
    }
    public void testFindStopCodon(){
        String dna = "123456TAAfabcfdedTAA";
        int dex = findStopCodon(dna,0,"TAA");
        if (dex!=6) System.out.println("error on 6");
        dex = findStopCodon(dna,4,"TAA");
       // System.out.println(dex);
        if (dex!=dna.length()) System.out.println("error on 5");
        dex = findStopCodon(dna,5,"TAA");
        //  System.out.println(dex);
        if (dex !=17) System.out.println("error on 17");
        System.out.println("test finished");
    }
    
    public void testFindGene(){
    String dna="fafagggTAA";
    String gene=findGene(dna);
    System.out.println("Testing DNA is " +dna);
    System.out.println(gene);
    
    dna="ATGTTTAAAGGGTAA";
    System.out.println("Testing DNA is " +dna);
    System.out.println(findGene(dna));
    
    dna="TATAATGGGGGGGTGATAA";
    System.out.println("Testing DNA is " +dna);
    System.out.println(findGene(dna));
    
    dna="GGGGATGGGGGGG";  
    System.out.println("Testing DNA is " +dna);
    System.out.println(findGene(dna));
    
}
        public void printAllGenes(String dna){ 
    //int startIndex = 0;
    String gene=findGene(dna);
    while (true){
        if(gene.isEmpty()){
        break;} else{
        System.out.println(gene);
        dna=dna.substring(dna.indexOf(gene)+gene.length());
        gene=findGene(dna);
    }
    }
}
    

}    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
