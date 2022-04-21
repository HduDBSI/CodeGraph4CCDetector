package googlejam9.p049;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scan = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
		Scanner scan = new Scanner(new FileInputStream(new File("B.in")));
		PrintWriter out = new PrintWriter(new FileOutputStream(new File("B.out")));
		int T = scan.nextInt();
		for(int t=1;t<=T;t++) {
			int B = scan.nextInt();
			long M = scan.nextLong();
			boolean[][] adj = new boolean[B][B];
			long[] cnts = new long[B];
			cnts[B-1] = 1;
			for(int i=B-2;i>0;i--) {
				cnts[i] = 0;
				for(int j=B-1;j>i;j--) {
					adj[i][j] = true;
					cnts[i] += cnts[j];
				}
			}
			int ptr = 1;
			while(ptr < B && M > 0) {
				if(M >= cnts[ptr]) {
					adj[0][ptr] = true;
					M -= cnts[ptr];
				}
				ptr++;
			}
			boolean possible = M == 0;
			
			out.printf("Case #%d: %s\n", t, possible ? "POSSIBLE" : "IMPOSSIBLE");
			if(possible) {
				for(int i=0;i<B;i++) {
					for(int j=0;j<B;j++) {
						if(adj[i][j])
							out.print("1");
						else
							out.print("0");
					}
					out.println();
				}
			}
		}
		out.close();
	}
}
