package googlejam3.p323;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;


public class Brattleship {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//System.setIn(new FileInputStream("a.in"));
		//System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("a_s.out")), true));
				
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int totalCaseNumber = Integer.parseInt( reader.readLine() );
		for(int caseNo=1 ; caseNo<=totalCaseNumber ; caseNo++ ) {
			String line = reader.readLine();
			String[] parts = line.split(" "); 
			int R = Integer.parseInt(parts[0]);
			int C = Integer.parseInt(parts[1]);
			int W = Integer.parseInt(parts[2]);
			
			int res = (C / W)*R + (C%W == 0 ? W-1 : W);
			
			System.out.println("Case #" + caseNo + ": " + res );
		}
		reader.close();
	}
}
