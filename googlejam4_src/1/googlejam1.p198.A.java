package googlejam1.p198;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
			int[] m = new int[n];
			for(int i = 0; i < n; i++) {
				m[i] = reader.nextInt();
			}
			int min1 = 0;
			int maxDecrease = -1;
			for(int i = 1; i < n; i++) {
				min1 += Math.max(0, m[i - 1] - m[i]);
				maxDecrease = Math.max(maxDecrease, Math.max(0, m[i - 1] - m[i]));
			}
			int min2 = 0;
			for(int i = 0; i < n - 1; i++) {
				min2 += Math.min(m[i], maxDecrease);
				
			}
			writer.println("Case #" + tc + ": " + min1 + " " + min2);
		}
		writer.close();
		reader.close();
	}
	
}
