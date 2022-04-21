package googlejam8.p261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CJ_2016_R1C_A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int nT = Integer.parseInt(in.readLine());
		for (int t = 1; t <= nT; t++) {
			System.out.printf("Case #%d: ", t);
			int p = Integer.parseInt(in.readLine());
			int[] a = new int[p];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < p; i++)
				a[i] = Integer.parseInt(st.nextToken());
			StringBuilder ans = new StringBuilder();
			int max = 0;
			int max1 = 0;
			for (int n : a)
				max1 = Math.max(max1, n);
			while ((max = max1) != 0) {
				for (int i = 0; i < p; i++)
					if (a[i] == max) {
						a[i]--;
						ans.append((char)(i + 'A'));
					}
			}
			ans.reverse();
			for (int i = 2; i < ans.length(); i += 3)
				ans.insert(i, ' ');
			ans.reverse();
			System.out.println(ans.toString());
		}
	}

}
