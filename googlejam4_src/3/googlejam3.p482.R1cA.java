package googlejam3.p482;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.lang.Math.*;

public class R1cA {

public static void main(String args[]) throws Exception {
		
		String inFile = "A-small-attempt0.in";// path to input file 
		String outFile =  "outputA.txt";
		
		LineNumberReader lin = new LineNumberReader(new InputStreamReader(new FileInputStream(inFile)));
		PrintWriter out = new PrintWriter(new File(outFile));
		int NCASE = Integer.parseInt(lin.readLine());
		for(int CASE = 1; CASE <= NCASE; CASE++) {
			out.print("Case #" + CASE + ": ");
			String l = lin.readLine();
			String  [] parts = l.split(" ");
			
			int R = Integer.parseInt(parts[0]);
			int C = Integer.parseInt(parts[1]);
			int W = Integer.parseInt(parts[2]);
			
			int score=0;
			int m=0;
			
			if (C%W==0) m=0; else m=1;
			
			score =  R*C/W + W - 1 + m;
			
			
			out.println(score);  // print result
		}

		lin.close();
		out.close();
	
		}		
}
