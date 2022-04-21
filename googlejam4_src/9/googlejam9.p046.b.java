package googlejam9.p046;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class b {

	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		PrintWriter out = null;

	      try {
	         in = new FileInputStream("B-large.in");
	         out = new PrintWriter( "outputB-large.txt" );

	         Scanner sc = new Scanner (in);
	         String line = sc.nextLine();

	         int T = Integer.parseInt(line);

	         for(int t=1; t<=T; t++) {
	        	 line = sc.nextLine();
	        	 
	        	 int B = Integer.parseInt(line.split(" ")[0]);
	        	 long M = Long.parseLong(line.split(" ")[1]);
	        	 
	        	 String output = "Case #" + t + ": ";
	        	 
	        	 if((1L << (B-2)) < M ) {
	        		 output += "IMPOSSIBLE\n";
	        		 out.print( output );
	        		 continue;
	        	 }
	        	 output += "POSSIBLE\n";
	        	 for (int i=0; i<B; i++) {
	        	      for (int j=0; j<B; j++) {
	        	        int k = 0;
	        	        if (i < j) {
	        	          if (i != 0) k = 1;
	        	          else if (j == B-1) k = 1;
	        	          else if ( ((1L << (B-j-2)) & (M-1)) != 0 ) k = 1;
	        	        }
	        	        output += k;
	        	      }
	        	      output += "\n";
	        	 }
	        	 out.print( output );
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
	