package googlejam1.p502;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;

public class A {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;
	
	public static void main(String[] args) throws IOException {
		File inf = new File ("/Users/Kang/Documents/workspace/CodeJamRound1/src/A.in");
		File outf = new File("/Users/Kang/Documents/workspace/CodeJamRound1/src/A.out");
		in = new BufferedReader(new FileReader(inf));
		out = new PrintWriter(outf);
		int cases = Integer.parseInt(in.readLine());
		for (int i = 0; i < cases; i++) {
			tok = new StringTokenizer(in.readLine());
			int method1 = 0;
			int method2 = 0;
			int len = Integer.parseInt(tok.nextToken());
			tok = new StringTokenizer(in.readLine());
			int[] mushrooms = new int[len];
			int max = 0;
			for (int j = 0; j < len; j++) {
				mushrooms[j] = Integer.parseInt(tok.nextToken());
			}
			for (int j = 1; j < len; j++) {
				if (mushrooms[j] < mushrooms[j-1]) method1 += mushrooms[j-1] - mushrooms[j];
				max = Math.max(max, mushrooms[j-1] - mushrooms[j]);
			}
			for (int j = 0; j < len-1; j++) {
				method2 += Math.min(max, mushrooms[j]);
			}
			method2 = method2;
			out.print("Case #" + "" + (i+1) + ": " + method1 + " " + method2 + "\n");
		}
		in.close();
		out.close();
	}
}
