package googlejam10.p153;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;


public class Showdown {
	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new FileWriter("showdown.out"));
		//PrintStream out = System.out;
		int [][][] solutions = new int[13][3][3];
		solutions[0][0][0] = 1; // p
		solutions[0][1][1] = 1; // r
		solutions[0][2][2] = 1; // s
		
		String[][] answers = new String[13][3];
		answers[0][0] = "P"; // p
		answers[0][1] = "R"; // r
		answers[0][2] = "S"; // s
		
		for (int i=1; i <= 12; i++) {
			for (int j=0; j < 3; j++) {
				solutions[i][j][0] = solutions[i-1][j][0] + solutions[i-1][j][2];
				solutions[i][j][1] = solutions[i-1][j][1] + solutions[i-1][j][0];
				solutions[i][j][2] = solutions[i-1][j][2] + solutions[i-1][j][1];
				
				
			}
			answers[i][0] = minString(answers[i-1][0], answers[i-1][1]);
			answers[i][1] = minString(answers[i-1][1], answers[i-1][2]);
			answers[i][2] = minString(answers[i-1][2], answers[i-1][0]);
		}
		
		int cases = kb.nextInt();
		for(int n=0; n < cases; n++) {
			out.print("Case #" + (n + 1) + ": ");
			
			int N = kb.nextInt();
			int r = kb.nextInt();
			int p = kb.nextInt();
			int s = kb.nextInt();
			
			boolean found = false;
			for (int j=0; j < 3; j++) {
				if (solutions[N][j][0] == p && solutions[N][j][1] == r && solutions[N][j][2] == s) {
					out.print(answers[N][j]);
					found = true;
				}
			}
			if (!found)
				out.print("IMPOSSIBLE");
			
			
			out.println();
		}
		out.close();
	}
	
	public static String minString (String a, String b) {
		if (a.compareTo(b) < 0) return a + b;
		return b + a;
	}
}
