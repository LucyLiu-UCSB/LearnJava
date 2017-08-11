
/**
 * Write the void method processGenes that has one parameter sr, which is a StorageResource of strings. This method processes all the strings in sr to find out information about them
 * 
 * Lucy
 */
import edu.duke.*;
public class Part3 {
     public int charaterTime(String dna, String Cha){
        int times=0;
        int startIndex=dna.indexOf(Cha);
        while(true){
            if (startIndex==-1){
            break;}
            times=times+1;
            startIndex=dna.indexOf(Cha,startIndex+1);
        }
        return times;
    }
     public float cgRatio(String dna){
        float totalCG=charaterTime(dna,"C")+charaterTime(dna,"G");
        float ratio=totalCG/dna.length();
        return ratio;
    }
    public void processGenes(StorageResource sr){
        int longTime=0;
        int cgHighTime=0;
        int lengthMax=0;
        for (String line:sr.data()) {
            if(line.length()>60){
            //System.out.println(line);
            longTime=longTime+1;
        }
        if(cgRatio(line)>0.35){
            //System.out.println(line);
            cgHighTime=cgHighTime+1;
        }
        if(lengthMax<line.length()){
            lengthMax=line.length();
        }          
        }
        System.out.println(lengthMax);
        System.out.println(longTime);
        System.out.println(cgHighTime);
    }
    
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
    public void testProcessGenes(){
        StorageResource sr=new StorageResource();
        //String str="TTTATGGCGCGCGCGCGGTAA";
        //sr=getAllGene(str);
        //processGenes(sr);
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        //System.out.println(dna.length());
        System.out.println(dna);
        dna= dna.toUpperCase();
        sr=getAllGene(dna);
        processGenes(sr);
        
    }
    

}
