
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size,int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }
    public void testHashMap(){
        EfficientMarkovModel emv=new EfficientMarkovModel(2);
        String st = "yes-this-is-a-thin-pretty-pink-thistle";
        emv.setRandom(42);
        emv.setTraining(st);
        emv.buildMap();
        emv.printHashMapInfo();
        //runModel(mz, st, size,seed);
    
    }
    public void compareMethods(){
        EfficientMarkovModel emv2=new EfficientMarkovModel(2);
        MarkovModel mv2 = new MarkovModel(2);
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int seed =42;
        double mv2StartTime=System.nanoTime() ;
        //runModel(mv2, st, size,seed);
        double mv2EndTime=System.nanoTime() ;
        
        double emv2StartTime=System.nanoTime() ;
        
        runModel(emv2, st, size,seed);
        
        double emv2EndTime=System.nanoTime() ;
        System.out.println("The running time for Markov model is "+ (mv2EndTime-mv2StartTime));
        System.out.println("The running time for Effective Markov model is "+ (emv2EndTime-emv2StartTime));
       
    }
         
    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int seed =1;
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size,seed);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size,seed);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size,seed);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size,seed);

    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
    
}
