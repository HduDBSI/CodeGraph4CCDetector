package googlejam6.p513;

import java.io.*;
import java.util.*;

public class rankandfile {


	  public static void main (String [] args) throws IOException {
	    // Use BufferedReader rather than RandomAccessFile; it's much faster
	    BufferedReader f = new BufferedReader(new FileReader("B-large(1).in"));
	                                                  // input file name goes above
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rankandfile.out")));
	    // Use StringTokenizer vs. readLine/split -- lots faster
	    StringTokenizer st = new StringTokenizer(f.readLine());
							  // Get line, break into tokens
	    
	   //enter program here
	    int cases = Integer.parseInt(st.nextToken());
	    for (int i = 0; i<cases; i++){
	    	st = new StringTokenizer(f.readLine());
	    	int n = Integer.parseInt(st.nextToken());
	    	LinkedList<int[]> vals = new LinkedList<int[]>();
	    	for (int j = 0 ; j<2*n-1; j++){
	    		st = new StringTokenizer(f.readLine());
	    		int[] holder = new int[n];
	    		for (int k = 0; k<n; k++){
	    			holder[k] =(Integer.parseInt(st.nextToken()));
	    		}
	    		
	    		vals.add(holder);
	    		
	    		
	    	}
	    	/**
	    	for (int j = 0; j<vals.size(); j++){
	    		for (int k = 0; k<n; k++){
	    			System.out.print(vals.get(j)[k]+" ");
	    		}System.out.println();
	    	}**/
	    	
    		LinkedList<int[]> store1 = new LinkedList<int[]>();
    		LinkedList<int[]> store2 = new LinkedList<int[]>();
	    	int index = 0;
	    	int missing = -1;
    		while (index<n){
	    		
	    		int min = Integer.MAX_VALUE;
	    		for (int j = 0; j<vals.size(); j++){
	    			if (vals.get(j)[index]<min){
	    				min = vals.get(j)[index];
	    			}
	    		}
	    		
	    		int count = 0;
	    		for (int j = 0; j<vals.size(); j++){
	    			//System.out.println(count+" "+j+" "+vals.size());

	    			if (vals.get(j)[index]==min){
	    				if (count == 0) store1.add(Arrays.copyOf(vals.get(j),n));
	    				if (count == 1) store2.add(Arrays.copyOf(vals.get(j),n));
	    				vals.remove(j); j-=1;
	    					    				count++;
	    			}
	    			
	    		}
	    		
	    		int[] holder = {};
    			if (count<2) store2.add(holder);
	    		if (count<2) missing = index;
	    		
	    		index++;
	    	}
	    	
    		String ans = "";
    		for (int j = 0; j<n; j++){
    			if (j==missing) ans+= store1.get(missing)[missing]+" ";
    			else if (store1.get(j)[missing] == store1.get(missing)[j]) ans+=store2.get(j)[missing]+" ";
    			else ans+= store1.get(j)[missing]+" ";
    			//System.out.println(ans);
    		}
	    	System.out.println("Case #"+(i+1)+": "+ans.trim());
	    	out.println("Case #"+(i+1)+": "+ans.trim());
	    }
	
	    
	    // answer output

    	out.close();	    
	    System.exit(0);                               // don't omit this!
	  }

}