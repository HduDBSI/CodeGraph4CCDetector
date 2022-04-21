package googlejam11.p042;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class R2_B {

	public static void main(String args[]) throws IOException {
	
		
		FileInputStream in = null;
		PrintWriter out = null;

	    try {
	         in = new FileInputStream("B-large.in");
	         out = new PrintWriter( "B-large.output" );
	        	    
	        	    
	         Scanner sc = new Scanner (in);
	         String line = sc.nextLine();
	           
	         int T = Integer.parseInt(line);
        	 
             for(int t=1 ; t <= T ; t++) {
            	 String output = "Case #" + t + ":";
            	 
            	 line = sc.nextLine();
            	 int n = Integer.parseInt(line.split(" ")[0]);
            	 int k = Integer.parseInt(line.split(" ")[1]);
            	 
            	 Vector<Double> input = new Vector<Double>();
            	 line = sc.nextLine();
            	 for(int i=0; i<n; ++i) {
            		 input.add(Double.parseDouble(line.split(" ")[i]));
            	 }
            	 Collections.sort(input);
            	 Vector<Double> temp = new Vector<Double>();
            	 double answer = 0.0;
            	 for(int i=0; i<=k; ++i) {
            		 for (int j=0; j<i; ++j) {
            			 temp.add(input.elementAt(j));
            		 }
            		 for(int j=0; j<k-i; ++j) {
            			 temp.add(input.elementAt(n-j-1));
            		 }
            		 Vector<Vector<Double>> memo = new Vector<Vector<Double>>();
            		 for (int j=0; j<k; ++j) {
            			 Vector<Double> subMemo = new Vector<Double>();
            			 for (int jj=0; jj <= k+1; jj++) {
            				 subMemo.add(jj, 0.0);
            			 }
            			 memo.add(subMemo);
            		 }
            		 memo.elementAt(0).set(0, 1.0);
            		 for(int j=0; j<k; ++j) {
            			 for (int x = 0; x <= j+1 ; ++x) {
            				 if ( j == 0 ) {
            					 memo.elementAt(j).set(0, 1-temp.elementAt(j));
            					 memo.elementAt(j).set(1, temp.elementAt(j));
            				 } else if (x == 0 ) {
            					 double val = memo.elementAt(j).elementAt(x);
            					 val += (1-temp.elementAt(j)) * memo.elementAt(j-1).elementAt(x);
            					 memo.elementAt(j).set(x,val);
            				 } else {
            					 double val = memo.elementAt(j).elementAt(x); 
            					 val += (1-temp.elementAt(j)) * memo.elementAt(j-1).elementAt(x);
            					 val += (temp.elementAt(j) * memo.elementAt(j-1).elementAt(x-1));
            					 memo.elementAt(j).set(x, val);
            				 }	 
            			 }
            		 }
            		 temp.clear();
            		 if (answer < memo.elementAt(k-1).elementAt(k/2) )
            			 answer = memo.elementAt(k-1).elementAt(k/2);
            	 }
            	 
            	 output += " " + answer;
            	 out.println(output);
             }
         
	     }finally {
	         if (in != null) {
	            in.close();
	         }
	         if (out != null) {
	            out.close();
	         }
	      }
	}
}
