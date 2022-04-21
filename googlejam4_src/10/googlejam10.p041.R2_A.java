package googlejam10.p041;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class R2_A {
	
	public static void main(String args[]) throws IOException {
	
		
		FileInputStream in = null;
		PrintWriter out = null;

	    try {
	         in = new FileInputStream("A-large.in");
	         out = new PrintWriter( "A-large.output" );
	        	    
	        	    
	         Scanner sc = new Scanner (in);
	         String line = sc.nextLine();
	           
	         int T = Integer.parseInt(line);
        	 
             for(int t=1 ; t <= T ; t++) {
            	 String output = "Case #" + t + ":";
            	 
            	 line = sc.nextLine();
            	 int n = Integer.parseInt(line.split(" ")[0]);
            	 int r = Integer.parseInt(line.split(" ")[1]);
            	 int p = Integer.parseInt(line.split(" ")[2]);
            	 int s = Integer.parseInt(line.split(" ")[3]);
            	 
            	 Vector<HashMap<String, String>> memo = new Vector<HashMap<String, String>>();;
            	 HashMap<String, String> base = new HashMap<String, String>();
            	 base.put("P", "P");
            	 base.put("R", "R");
            	 base.put("S", "S");
            	 memo.add(base);
            	 
            	 for(int i=1; i<=12; ++i) {
            		 HashMap<String, String> subMemo = new HashMap<String, String>();
            		 if ( memo.elementAt(i-1).get("P").compareTo(memo.elementAt(i-1).get("R")) < 0 ) {
            			 String ss = memo.elementAt(i-1).get("P") + memo.elementAt(i-1).get("R"); 			 
            			 subMemo.put("P", ss);
            		 } else {
            			 String ss = memo.elementAt(i-1).get("R") + memo.elementAt(i-1).get("P");
            			 subMemo.put("P", ss);
            		 }
            		 if ( memo.elementAt(i-1).get("R").compareTo(memo.elementAt(i-1).get("S")) < 0  ) {
            			 String ss = memo.elementAt(i-1).get("R") + memo.elementAt(i-1).get("S");
            			 subMemo.put("R", ss);
            		 } else {
            			 String ss = memo.elementAt(i-1).get("S") + memo.elementAt(i-1).get("R");
            			 subMemo.put("R", ss);
            		 }
            		 if ( memo.elementAt(i-1).get("P").compareTo(memo.elementAt(i-1).get("S")) < 0 ) {
            			 String ss = memo.elementAt(i-1).get("P") + memo.elementAt(i-1).get("S");
            			 subMemo.put("S", ss);
            		 } else {
            			 String ss = memo.elementAt(i-1).get("S") + memo.elementAt(i-1).get("P");
            			 subMemo.put("S", ss);
            		 }
            		 memo.add(subMemo);
            	 }
            	 
            	 int flag = 0;
            	 for(String key : Arrays.asList("P", "R", "S")) {
            		 int pNum = 0, rNum = 0, sNum = 0;
            		 String currentS = memo.elementAt(n).get(key);
            		 for (int k = 0; k < currentS.length(); k++){
            			 char c = currentS.charAt(k); 
            			 if ( c == 'P' ) ++pNum;
            			 else if ( c == 'R' ) ++rNum;
            			 else if ( c == 'S' ) ++sNum;
            		 }
            		 if (pNum == p && rNum == r && sNum == s) {
            			 output += " " + memo.elementAt(n).get(key);
            			 out.println( output );
            			 flag = 1;
            		     break;
            		 }
            	 }
            	 
            	 if( flag == 0 ) {
            		 output += " " + "IMPOSSIBLE";
            		 out.println( output );
            	 }
             }
         
	     } finally {
	         if (in != null) {
	            in.close();
	         }
	         if (out != null) {
	            out.close();
	         }
	     }
	}

}
