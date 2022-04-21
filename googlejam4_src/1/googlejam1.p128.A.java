package googlejam1.p128;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("A-large.in"));
//		BufferedReader in = new BufferedReader(new FileReader("A-small-attempt0.in"));
//		BufferedReader in = new BufferedReader(new FileReader("a_test.in"));
		PrintWriter pw = new PrintWriter(System.out);
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(in.readLine());
			int arr[] = new int[n];
			int  i = 0;
			for (String s : in.readLine().split(" ")) {
				arr[i++] = Integer.parseInt(s);
			}
			
			int maxDiff = 0;
			for (i = 1; i < n; i++) {
				maxDiff = Math.max(maxDiff, arr[i - 1] - arr[i]);
			}
			
			long first = 0;
			long second = 0;
			
			for (i = 1; i < n; i++) {
				first += Math.max(0, arr[i - 1] - arr[i]);
			}
			for (i = 0; i < n - 1; i++) {
				
				second += Math.min(maxDiff, arr[i]);
			}
			
			pw.format("Case #%d: %d %d\n", t, first, second);
			pw.flush();
		}
		pw.close();
		in.close();
	}

}
