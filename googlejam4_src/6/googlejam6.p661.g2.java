package googlejam6.p661;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class g2 {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	    	
	      int n = in.nextInt();
	      //System.out.println(n);
	      
	      HashMap<Integer, Integer> map=new HashMap<>();
	      for(int j=0;j<2*n-1;j++){
	    	  for(int k=0;k<n;k++){
	    		  int temp=in.nextInt();
	    		  if(!map.containsKey(temp)){
	    			  map.put(temp, 1);
	    		  }else{
	    			  map.put(temp, map.get(temp)+1);
	    		  }
	    	  }
	      }
	      
	      PriorityQueue<Integer> q=new PriorityQueue<>();
	      for(Entry<Integer, Integer> s: map.entrySet()){
	    	  if(s.getValue()%2==1){
	    		  q.add(s.getKey());
	    	  }
	      }
	      
	     
	      System.out.print("Case #" + i + ": " );  
	     
	      int temp;
	      for(temp=q.poll();!q.isEmpty();temp=q.poll()){
	    	  System.out.print(temp+" ");
	      }
	      System.out.print(temp+"\n");
	      
	    }
	  }
}
