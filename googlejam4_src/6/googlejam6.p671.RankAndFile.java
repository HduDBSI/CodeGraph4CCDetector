package googlejam6.p671;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import javax.sql.rowset.CachedRowSet;

public class RankAndFile {

	public static void main(String[] args) throws NumberFormatException, IOException

	{
		
	      BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input1.txt")));

	      int test_num = Integer.parseInt(reader.readLine());
	      System.out.println(test_num);
	      BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
	     // out.write("Case #" + test_num + ":" + "\n");
	      
	      for(int i = 1; i <= test_num; i++)

	      {	  
	    	  String input = reader.readLine();
	    	  int n = Integer.parseInt(input);
	    	 // int[][] res = new int[n][n];
	    	  HashMap<Integer, Integer> numcount = new HashMap<Integer, Integer>();
	    	  int kk = 0;
	    	  while( kk < 2*n - 1){
	    		  
	    		  String curline = reader.readLine();
	    		  String[] current =  curline.split("\\s+");
	    		  
	    		
	    		  for(int j = 0; j < n; j++){
	    			  
	    			  if(!numcount.containsKey(Integer.parseInt(current[j]))){
	    			
	    				  numcount.put(Integer.parseInt(current[j]), 1);
	    			  }else{
	    				  numcount.remove(Integer.parseInt(current[j]));
	    			  }
	    		  }
	    		  kk = kk + 1;
	    		  
	    	  }
	    	  
		    	  Set<Integer> keyset = numcount.keySet();
		    	  ArrayList<Integer> res = new ArrayList<>();
		    	  res.addAll(keyset);
		    	  //String res = keyset.toString();
		   	  
		    	  Collections.sort(res);
		    	 
		    	  out.write("Case #" + String.valueOf(i) + ": ");
		    	  for(int m = 0; m < res.size();m++)
		    	  {
		    		  out.write(res.get(m).toString());
		    		  if(m != res.size() - 1)
		    		      out.write(" ");
		    	  }
		    	  out.write("\n");
		     	  //System.out.println(res.toString());
	    	  }

	      reader.close();

	      out.close();
	}
}


