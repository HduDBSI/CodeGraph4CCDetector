package googlejam6.p456;
import java.util.*;
import java.io.*;

import javax.swing.text.TableView;

public class P2{

   public static void main(String[] args){
	   
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int T=in.nextInt();
      
      
      for(int i=0;i<T;i++){
    	  int N=in.nextInt();
    	  HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();   
    	  HashSet<Integer> numbers=new HashSet<Integer>();
    	  int index0=0;
    	  for(int j=0;j<2*N-1;j++){
    		  for(int k=0;k<N;k++){
    			  int s=in.nextInt();
    			  if(hm.containsKey(s)){
    				  int number=hm.get(s)+1;
    				  hm.remove(s);
    				  hm.put(s, number);
    			  }
    			  else{
    				  hm.put(s, 1);
    				  numbers.add(s);
    			  }
    			      
    		  }
    	  }
    	  
    	  
    	  int[] missing=new int[N];
    	  int index=0;
    	  for(int num:numbers){
    		  int value=hm.get(num);
    		  if(value%2==1){
    			  missing[index]=num;
    			  index+=1;
    		  }
    	  }
    	 
    	 java.util.Arrays.sort(missing);
    	 
    	 String out="";
    	 for(int missed:missing){
    		 out=out+missed+" ";
    	 }
    	  
    	 System.out.println("Case #"+(i+1)+": "+out);
      }

      in.close();
      
   }
}
