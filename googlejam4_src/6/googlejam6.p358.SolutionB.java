package googlejam6.p358;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionB {

	private File input;
	
	private File output;
	
	private String inputSource = "input/B/in.txt";
	
	private String outputSource = "output/B/out.txt";

	private int N;
	
	public static void main(String[] args) {
		try {
			SolutionB r = new SolutionB();
			r.input = new File(r.inputSource);
			Scanner s1 = new Scanner(r.input);
			r.N = s1.nextInt();
			Scanner s = s1;
			r.output = new File(r.outputSource);
			PrintWriter w1 = new PrintWriter(r.output);
			PrintWriter w = w1;
			for(int i = 1; i <= r.N; i++) {
				int c = s.nextInt();
				int[] p1 = new int[(2*c-1)*c+1];
				p1[0] = c;
				for(int i1=1; i1<=(2*c-1)*c;i1++) {
					p1[i1] = s.nextInt();
				}
				int[] p = p1;
				int c1 = p[0];
				int[] h = new int[2501];
				for(int j=0; j<=2500; j++) {
					h[j] = 0;
				}
				for(int i1=1; i1<p.length; i1++) {
					h[p[i1]]++;
				}
				int[] sol1 = new int[c1];
				int ind = 0;
				for(int j=0; j<=2500; j++) {
					if(h[j]%2 != 0) {
						sol1[ind] = j;
						ind++;
					}
				}
				int[] sol = sol1;
				w.print("Case #" + i + ":");
				Arrays.stream(sol).forEach(s11 -> w.print(" " + s11));
				w.println();
			}
			w.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
