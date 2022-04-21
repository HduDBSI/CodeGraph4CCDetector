package googlejam1.p164;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("A.in")));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("A.out"))));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] M = new int[N];
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < N; i++) M[i] = Integer.parseInt(str[i]);
			int first = 0, maxdiff = 0;
			for (int i = 1; i < N; i++) {
				int diff = M[i-1]-M[i];
				if (diff > 0) {
					first += diff;
					maxdiff = Math.max(maxdiff, diff);
				}
			}
			int second = 0;
			for (int i = 0; i < N-1; i++) second += Math.min(M[i], maxdiff);
			
			pw.println("Case #"+(t+1)+": "+first+" "+second);
			pw.flush();
		}

		pw.close();
		br.close();
	}
}
