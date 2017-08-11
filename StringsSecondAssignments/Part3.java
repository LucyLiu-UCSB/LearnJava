
/**
 * count how many genes are in a strand of DNA.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    public int countGenes(String dna){
        String gene=findGene(dna);
        int times=0;
        while (true){
        if(gene.isEmpty()){
        return times;} else{
        times=times+1;
        dna=dna.substring(dna.indexOf(gene)+gene.length());
        gene=findGene(dna);
    }
    }
}
        public void testCoundGenes(){
        String dna="ATGTAAGATGCCCTAGT";
        System.out.println(findGene(dna));
        System.out.println(countGenes(dna));
        dna="ATGTAAGATGC";
        System.out.println(countGenes(dna));
        dna="";
        
        System.out.println(countGenes(dna));
    }

}
