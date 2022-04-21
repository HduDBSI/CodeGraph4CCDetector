package googlejam8.p157;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class R2016_1C_A {
	
	private final static String CASE = "Case #%d: ";
	
	private int t;
	
	public static void main(final String[] args) {
		R2016_1C_A r = new R2016_1C_A();
		final File directory = new File(r.getClass().getSimpleName() + "_cases");
		final File inDirectory = new File(r.getClass().getSimpleName() + "_cases" + "/in");
		final File outDirectory = new File(r.getClass().getSimpleName() + "_cases" + "/out");
		
		if (!directory.isDirectory()) {
			directory.mkdir();
		}
		if (!outDirectory.isDirectory()) {
			outDirectory.mkdir();
		}
		if (!inDirectory.isDirectory()) {
			inDirectory.mkdir();
		}
		
		for (final String in : inDirectory.list()) {
			final String fileNameCore = in.replace(".in", "");
			final String outFileName = fileNameCore + ".out";
			
			final File inFile = new File(r.getClass().getSimpleName() + "_cases" + "/in" + "/" + in);
			final File outFile = new File(r.getClass().getSimpleName() + "_cases" + "/out" + "/" + outFileName);
			try (final PrintStream ps =  new PrintStream(outFile);
					final Scanner s = new Scanner(inFile)){
				r.t = s.nextInt();
				for (int i = 0; i < r.t; i++) {
					final int n = i;
					ps.print(String.format(R2016_1C_A.CASE, n + 1));
					r.N = s.nextInt();
					r.P = new int[r.N];
					
					for (int i1 = 0; i1 < r.N; i1++) {
						r.P[i1] = s.nextInt();
					}
					r.solution = new ArrayList<>();
					
					int sum = 0;
					for (int i3 = 0; i3 < r.N; i3++) {
						sum += r.P[i3];
					}
					
					while(sum > 2) {
						int m = 0;
						int x = 0;
						int x2 = 0;
						for (int i1 = 0; i1 < r.N; i1++) {
							if (r.P[i1] >= m) {
								m = r.P[i1];
								x2 = x;
								x = i1;
							}
						}
					
						if (r.P[x2] * 2 > sum - 1) {
							r.solution.add("" + (char)('A' + x) + (char)('A' + x2));
							r.P[x] --;
							r.P[x2]--;
							sum -= 2;
						} else {
							r.solution.add("" + (char)('A' + x));
							r.P[x]--;
							sum--;
						}
					}
					
					String s1 = "";
					for (int i2 = 0; i2 < r.N; i2++) {
						if (r.P[i2] != 0) {
							s1 += (char)('A' + i2);
						}
					}
					
					r.solution.add(s1);
					for (int i1 = 0; i1 < r.solution.size() - 1; i1++) {
						ps.print(r.solution.get(i1) + " ");
					}
					ps.print(r.solution.get(r.solution.size() - 1));
					ps.println();
				}
			} catch (final IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	int N;
	int[] P;
	
	List<String> solution;
}
