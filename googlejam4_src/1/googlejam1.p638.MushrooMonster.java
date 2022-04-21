package googlejam1.p638;
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


public class MushrooMonster {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//System.setIn(new FileInputStream("a-l.in"));
		//System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("a_l.out")), true));
				
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int totalCaseNumber = Integer.parseInt( reader.readLine() );
		for(int caseNo=1 ; caseNo<=totalCaseNumber ; caseNo++ ) {
			String line = reader.readLine();
			line = reader.readLine();
			String[] parts = line.split(" ");

			int[] m = new int[parts.length];
			for(int i=0 ; i<parts.length ; i++ ) {
				m[i] = Integer.parseInt(parts[i]);
			}
			
			int res1 = 0, res2 = 0, largeDiff = 0;
			for(int i=1 ; i<m.length ; i++ ) {
				if( m[i] < m[i-1]) {
					int diff = m[i-1] - m[i];
					res1 += diff;
					largeDiff = Math.max(largeDiff, diff);
				}
			}

			//int rate = largeDiff % 10 == 0 ? largeDiff/10 : (largeDiff/10) + 1;
			//int maxEat = rate * 10;
			for(int i=0 ; i<m.length - 1 ; i++ ) {
				if( m[i] <= largeDiff ) {
					res2 += m[i];
				} else {
					res2 += largeDiff;
				}
			}
			
			System.out.println("Case #" + caseNo + ": " + res1 + " " + res2);
		}
		reader.close();
	}
}
