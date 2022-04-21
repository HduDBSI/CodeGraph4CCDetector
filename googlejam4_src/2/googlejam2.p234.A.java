package googlejam2.p234;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A {

	static Scanner reader;
	static PrintWriter writer;
	
	public static void main(String[] args) throws IOException {
		reader = new Scanner(new FileReader("input"));
		writer = new PrintWriter(new FileWriter("output"));
		int nt = reader.nextInt();
		for(int tc = 1; tc <= nt; tc++) {
			int n = reader.nextInt();
			Queue<Integer> Q = new LinkedList<>();
			Q.add(0);
			int[] d = new int[n + 1];
			Arrays.fill(d, Integer.MAX_VALUE);
			d[0] = 0;
			while(d[n] == Integer.MAX_VALUE) {
				int cur = Q.poll();
				if(cur + 1 <= n && d[cur + 1] == Integer.MAX_VALUE) {
					d[cur + 1] = 1 + d[cur];
					Q.add(cur + 1);
				}
				StringBuilder sb = new StringBuilder();
				sb.append(cur);
				sb = sb.reverse();
				int r = Integer.parseInt(sb.toString());
				if(r <= n && d[r] == Integer.MAX_VALUE) {
					d[r] = 1 + d[cur];
					Q.add(r);
				}
			}
			writer.printf("Case #%d: %d\n", tc, d[n]);
		}
		writer.close();
		reader.close();
	}
	
}
