import java.io.*;
import java.util.*;
import java.util.stream.*;

// XXX: https://www.hackerrank.com/contests/code-leader/challenges/string-counter/submissions/code/1308577835

class Triplet{
    String word;
    Integer firstOcur;
    Integer freq;
    
    public Triplet(String word){
        this.word=word;
        this.firstOcur=-1;
        this.freq=0;
    }
    
    public Integer compareTo(Triplet other){
        Integer r=0;
        
        r=other.freq-this.freq;
        
        if(r==0){
            r=this.firstOcur-other.firstOcur;
        }
        
        return r;
    }
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // XXX: https://stackoverflow.com/questions/11842091/read-input-line-by-line
        Scanner input = new Scanner(System.in);
        Map<String,Triplet> counts=new HashMap<String,Triplet>();
        while (input.hasNextLine()){
            // XXX: https://stackoverflow.com/questions/9856916/java-string-split-regex
            String w[]=input.nextLine().split("[^A-Za-z]+");
            Integer i=0;
            for(String cw:w){
                Triplet t;
                
                cw=cw.replaceAll("[^a-zA-Z]","");
                
                if(cw.length()==0){
                    continue;
                }
                
                if(counts.containsKey(cw)){
                    t=counts.get(cw);
                }
                else{
                    t=new Triplet(cw);
                    t.firstOcur=i;
                    counts.put(cw,t);
                }
                
                t.freq++;
                i++;
            }
            
            List<Triplet> r=counts.entrySet().stream().filter(t->t.getValue().freq>1 && t.getValue().word.length()>0).sorted((t1,t2)->t1.getValue().compareTo(t2.getValue())).map(t->t.getValue()).collect(Collectors.toList());
            
            if(r.isEmpty()){
                System.out.println("0");
            }
            for(Triplet t:r){
                System.out.println(t.freq+" "+t.word);
            }
            
        }
    }
}
