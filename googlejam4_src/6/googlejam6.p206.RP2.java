package googlejam6.p206;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Collections;

public class RP2 {
public static void main(String[] args)throws IOException{
	
     try {
        
         File newTextFile = new File("/Users/classxiaoli/Downloads/output.txt");
         FileWriter fw = new FileWriter(newTextFile);
         BufferedReader reader = new BufferedReader(new FileReader("/Users/classxiaoli/Downloads/B-large.in"));
       //  BufferedReader reader = new BufferedReader(new FileReader("/Users/classxiaoli/Downloads/input.in"));
      //   BufferedReader reader = new BufferedReader(new FileReader("/Users/classxiaoli/Downloads/B-small-attempt0.in"));
         int i=0;
        
         String line;
         reader.readLine();
         
         while ((line= reader.readLine()) != null) {
        	 i++;
        	 int a =Integer.parseInt(line);
        	 Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        	 for(int j=0;j<2*a-1;j++){
        		 line= reader.readLine();
        		 for(String str:line.split(" ")){
        			 int k=Integer.parseInt(str);
        			 if(!map.containsKey(k)) map.put(k, 1);
        			 else map.put(k,map.get(k)+1);
        		 }
        	 }
        	 ArrayList<Integer> r=new ArrayList<>();
        	
        	 for(int k:map.keySet()){
        		 if(map.get(k)%2==1) r.add(k);
        	 }
        	 Collections.sort(r);
        	 String result=""+r.get(0);
        	 for(int j=1;j<r.size();j++) result+=" "+r.get(j);
            fw.write("Case #"+i+": "+result+"\n"); 
         
         }
         fw.close();
      }finally {
         
      }
}
}
