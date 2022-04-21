package googlejam1.p059;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		try {
			File fin = new File("A-large.in");
			Scanner sc = new Scanner(fin);
			File fout = new File("aout.txt");
			PrintWriter pw = new PrintWriter(fout);
			//PrintWriter pw = new PrintWriter(System.out);
			int T = sc.nextInt();
			for (int cn=1; cn<=T; cn++) {
				int N = sc.nextInt();
				int[] m = new int[N];
				for (int i=0; i<N; i++) {
					m[i] = sc.nextInt();
				}
				A a = new A();
				int[] res1 = new int[2];
				int last = 0;
				int rate = 0;
				for (int y: m) {
					int dec = Math.max(0, last - y);
					res1[0] += dec;
					rate = Math.max(rate, dec);
					last = y;
				}
				for (int i=0; i+1<m.length; i++) {
					res1[1] += Math.min(m[i], rate);
				}
				int[] res = res1;
				pw.write("Case #" + cn + ": " + res[0] + " " + res[1] + "\n");
			}
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
