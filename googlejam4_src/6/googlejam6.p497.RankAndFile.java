package googlejam6.p497;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class RankAndFile {
//	static private final String INPUT = "G:/C-competitions/CodeJam/2016/Round 1A/Problem 2/sample_input.txt";
//	static private final String OUTPUT = "G:/C-competitions/CodeJam/2016/Round 1A/Problem 2/sample_output.txt";

//	static private final String INPUT = "G:/C-competitions/CodeJam/2016/Round 1A/Problem 2/s_input_attempt0.in";
//	static private final String OUTPUT = "G:/C-competitions/CodeJam/2016/Round 1A/Problem 2/s_output_attempt0.txt";
	
	static private final String INPUT = "G:/C-competitions/CodeJam/2016/Round 1A/Problem 2/b_input.in";
	static private final String OUTPUT = "G:/C-competitions/CodeJam/2016/Round 1A/Problem 2/b_output.txt";
	
	static private Scanner in;
	
	public static void main(String[] args) {
		FileInputStream instream = null;  
	      PrintStream outstream = null;  
	     
	      try {  
	          instream = new FileInputStream(INPUT);  
	          outstream = new PrintStream(new FileOutputStream(OUTPUT));  
	          System.setIn(instream);  
	          System.setOut(outstream);  
	      } catch (Exception e) {  
	          System.err.println("Error Occurred.");  
	      }  
	     
	      in = new Scanner(System.in);  
	      int T=in.nextInt();
	      
	      for (int t=1;t<=T;t++) {  
	    	  System.out.print("Case #"+t+":");
	    	  int N=in.nextInt();
			int[] flags=new int[2502];
			for(int i=0;i<N*(2*N-1);i++) {
				int x=in.nextInt();
				flags[x]++;
			}
			for(int i=1;i<2501;i++) {
				if((flags[i]%2)!=0)
					System.out.print(" "+i);
			}
			System.out.println();	         	              	    
	      }
	      System.err.println("done.");
	      in.close();
	      return;
	}

}
