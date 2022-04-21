package googlejam1.p217;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		
		for (int i = 1; i <= t; i++) {
			
			int n = Integer.parseInt(in.readLine());
			String[] next = in.readLine().split(" ");
			int[] mushrooms = new int[n];
			for (int j = 0; j < n; j++) {
				mushrooms[j] = Integer.parseInt(next[j]);
			}

			int[] diffs = new int[n-1];
			for (int j = 1; j < n; j++) {
				diffs[j-1] = mushrooms[j] - mushrooms[j-1];
			}
			
			int first = 0;
			int second = 0;
			
			int smallestD = 9999999;
			for (int j = 0; j < n - 1; j++) {
				if (diffs[j] < 0) first += Math.abs(diffs[j]);
			}
			
			for (int j = 0; j < n - 1; j++) {
				smallestD = Math.min(smallestD, diffs[j]);
			}
			smallestD = Math.abs(smallestD);
			
			for (int j = 0; j < n - 1; j++) { 
				second += Math.min(mushrooms[j], smallestD);
			}
			
			System.out.format("Case #%d: %d %d\n", i, first, second);
		}
	}
}
