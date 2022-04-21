package googlejam1.p156;
import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("A.in"));
		PrintStream out = new PrintStream("A.out");

		int t = Integer.parseInt(in.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(in.readLine());
			String[] arr = in.readLine().split(" ");
			int[] a = new int[n];
			for(int j = 0; j < n; j++) {
				a[j] = Integer.parseInt(arr[j]);
			}
			int tot = 0;
			int max = 0;
			for(int j = 0; j < n - 1; j++) {
				if(a[j] > a[j + 1]) {
					tot += a[j] - a[j + 1];
				}
				max = Math.max(max, a[j] - a[j + 1]);
			}
			long tot2 = Long.MAX_VALUE >> 1;
			for(int j = 0; j <= 100000; j++) {
				boolean works = true;
				long temptot = 0;
				for(int k = 0; k < n - 1; k++) {
					if(a[k] <= j) {
						temptot += a[k];
					} else {
						temptot += j;
					}
					if(j < a[k] - a[k + 1]) {
						works = false;
					}
				}
				if(works) {
					tot2 = Math.min(tot2, temptot);
				}
			}
			out.println("Case #" + (i + 1) + ": " + tot + " " + tot2);
		}
	}
}