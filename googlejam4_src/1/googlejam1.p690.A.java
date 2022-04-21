package googlejam1.p690;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A {
	private static final String INPUT = "A-large.in";
	private static final String OUTPUT = "A-large.out";

	private Scanner scanner;
	private BufferedWriter writer;

	public static void main(String[] args) throws IOException {
		A r = new A();
		r.scanner = new Scanner(new File(A.INPUT));
		r.writer = new BufferedWriter(new FileWriter(A.OUTPUT));
		int n = r.scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int n1 = r.scanner.nextInt();
			int[] m = new int[n1];
			for (int i1 = 0; i1 < n1; i1++) {
				m[i1] = r.scanner.nextInt();
			}
			long sum = 0;
			for (int i1 = 1; i1 <m.length; i1++) {
				if (m[i1] < m[i1-1]) {
					//less mushrooms, she ate some
					sum+= m[i1-1] - m[i1];
				}
			}
			
			long first = sum;
			long sum1 = 0;
			int maxDif = Integer.MIN_VALUE;
			for (int i1 = 1; i1 < m.length; i1++) {
				maxDif = Math.max(maxDif, m[i1-1] - m[i1]);
			}
			
			for (int i2 = 0; i2 < m.length -1; i2++) {
				sum1 += Math.min(m[i2], maxDif);
			}
			long second = sum1;
			
			String line = "Case #" + (i+1) + ": " + first + " " + second;
			r.writer.write(line + "\n");
			System.out.println(line);
		}
		r.scanner.close();
		r.writer.close();
	}
}
