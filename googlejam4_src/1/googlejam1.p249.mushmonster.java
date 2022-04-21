package googlejam1.p249;

import java.io.*;
import java.util.*;

public class mushmonster {


	  public static void main (String [] args) throws IOException {
	    // Use BufferedReader rather than RandomAccessFile; it's much faster
	    BufferedReader f = new BufferedReader(new FileReader("A-large(1).in"));
	                                                  // input file name goes above
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mush.out.txt")));
	    // Use StringTokenizer vs. readLine/split -- lots faster
	    StringTokenizer st = new StringTokenizer(f.readLine());
							  // Get line, break into tokens
	    
	   //enter program here
	    
	    String answer ="";
	    int numCases = Integer.parseInt(st.nextToken());
	    for (int i = 0; i<numCases;i++){
		   st = new StringTokenizer(f.readLine());
		   LinkedList<Integer> arr = new LinkedList();
	    	int numStacks = Integer.parseInt(st.nextToken());
	    	st = new StringTokenizer(f.readLine());
	    	int totalDrop = 0;
	    	int maxDrop = 0;
	    	int lastNum = 0;
	    	int newNum = 0;
	    	for (int j = 0;j<numStacks;j++){
	    		lastNum = newNum;
	    		newNum = Integer.parseInt(st.nextToken());
	    		arr.add(newNum);
	    		if (lastNum-newNum>maxDrop){
	    			maxDrop = lastNum-newNum;
	    		}
	    		if (lastNum-newNum>0){
	    			totalDrop +=lastNum-newNum;
	    		}
	    	}
	    	
	    	int totMaxDrop =0;
	    	for (int j = 0; j<arr.size()-1;j++){
	    		if (arr.get(j)-maxDrop<0){
	    			totMaxDrop+=arr.get(j);
	    		}else{
	    			totMaxDrop+=maxDrop;
	    		}
	    	}
	    	
	    	
	    	
	    	
	    	System.out.println("Case #"+(i+1)+": "+totalDrop+" "+totMaxDrop);
		    out.println("Case #"+(i+1)+": "+totalDrop+" "+totMaxDrop);
	    }
	    // answer output

    	out.close();	    
	    System.exit(0);                               // don't omit this!
	  }

}