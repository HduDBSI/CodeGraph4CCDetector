package googlejam3.p439;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;

public class ProbA {
	private static Reader in;
	private static PrintWriter out;	
	public static final String NAME = "A-small-practice.in";		
	public static final String OUTNAME = "output.out";
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(NAME));
		BufferedWriter bw = new BufferedWriter(new FileWriter(OUTNAME));
		
		String output = "";
		int cases = Integer.valueOf(sc.nextLine());
		for (int c = 1; c <= cases; c++) {
			output += "Case #" + c + ": ";
			
			int R = sc.nextInt();
			int C = sc.nextInt();
			int W = sc.nextInt();
			
			int guess = 0;
			int totalCells = R * C;
			if (totalCells % W == 0) {
				guess = totalCells/W + (W-1);
			} else {
				guess = totalCells/W + (W);
			}
			
			output += guess + "\n";
			
			if (sc.hasNext()) sc.nextLine();
		}		
		bw.write(output);
		bw.close();
	}
}
