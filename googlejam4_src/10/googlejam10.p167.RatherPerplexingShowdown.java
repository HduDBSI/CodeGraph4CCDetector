package googlejam10.p167;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class RatherPerplexingShowdown {
	
	static final String IMPOSSIBLE = "IMPOSSIBLE";
		
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new BufferedReader(new FileReader(new File("A-large.in")), 256 << 10));
			BufferedWriter out = new BufferedWriter(new FileWriter(new File("output.txt")), 256 << 10);

			int testsNumber = in.nextInt();
			for (int testId = 1; testId <= testsNumber; testId++) {
				int rounds = in.nextInt();
				int n = 1 << rounds;
				int r = in.nextInt();
				int p = in.nextInt();
				int s = in.nextInt();
				
				String[] pp = new String[rounds+1];
				String[] rr = new String[rounds+1];
				String[] ss = new String[rounds+1];

				pp[0] = "P";
				rr[0] = "R";
				ss[0] = "S";
				
				for (int i = 1; i <= rounds; i++) {
					if (pp[i-1].compareTo(rr[i-1]) < 0)
						pp[i] =  pp[i-1] + rr[i-1];
					else 
						pp[i] =  rr[i-1] + pp[i-1];
					
					if (rr[i-1].compareTo(ss[i-1]) < 0)
						rr[i] =  rr[i-1] + ss[i-1];
					else 
						rr[i] =  ss[i-1] + rr[i-1];
					
					if (pp[i-1].compareTo(ss[i-1]) < 0)
						ss[i] =  pp[i-1] + ss[i-1];
					else 
						ss[i] =  ss[i-1] + pp[i-1];
				}
				
				String result = null;
				int ar = 0, ap = 0, as = 0;
				for (int i = 0; i < pp[rounds].length(); i++) {
					char ch = pp[rounds].charAt(i);
					if (ch == 'P')
						ap++;
					else if (ch == 'R')
						ar++;
					else if (ch == 'S')
						as++;
				}
				if (ar == r & as == s & ap == p) {
					if (result == null || result.compareTo(pp[rounds]) > 0)
						result = pp[rounds];
				}

				ar = 0; ap = 0; as = 0;
				for (int i = 0; i < rr[rounds].length(); i++) {
					char ch = rr[rounds].charAt(i);
					if (ch == 'P')
						ap++;
					else if (ch == 'R')
						ar++;
					else if (ch == 'S')
						as++;
				}
				if (ar == r & as == s & ap == p) {
					if (result == null || result.compareTo(rr[rounds]) > 0)
						result = rr[rounds];
				}
				
				ar = 0; ap = 0; as = 0;
				for (int i = 0; i < ss[rounds].length(); i++) {
					char ch = ss[rounds].charAt(i);
					if (ch == 'P')
						ap++;
					else if (ch == 'R')
						ar++;
					else if (ch == 'S')
						as++;
				}
				if (ar == r & as == s & ap == p) {
					if (result == null || result.compareTo(ss[rounds]) > 0)
						result = ss[rounds];
				}

				if (result == null)
					result = IMPOSSIBLE;
				out.append("Case #" + testId + ": " + result);
				
				out.append("\n");
			}
			in.close();
			out.close();
		}
		catch (RuntimeException rte) {
			throw rte;
		}
		catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}
	}
}
