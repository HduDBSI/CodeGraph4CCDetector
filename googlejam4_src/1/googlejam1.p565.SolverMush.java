package googlejam1.p565;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SolverMush {
	static PrintWriter writer;

	public static void main(String[] args) throws NumberFormatException,
	IOException {
		writer = new PrintWriter("output");
		Scanner sc = new Scanner(new File("input"));
		int nbTest = sc.nextInt();
		for (int i = 1; i <= nbTest; i++) {
			int N = sc.nextInt();
			int[] m = new int[N];
			int res1 = 0, res2 = 0;
			int biggestDif = 0;
			int last = sc.nextInt();
			m[0] = last;
			for (int j = 1; j < N; j++) {
				m[j] = sc.nextInt();
				int diff = last - m[j];
				if (diff > 0) {
					res1 += diff;
				}
				if (diff > biggestDif) {
					biggestDif = diff;
				}
				last = m[j];
			}
			for (int j = 0; j < N - 1; j++) {
				res2 += Math.min(biggestDif, m[j]);
			}
		
			SolverMush.writer.println("Case #" + i + ": " + res1 + " " + res2);
		}
		writer.flush();
	}

}
