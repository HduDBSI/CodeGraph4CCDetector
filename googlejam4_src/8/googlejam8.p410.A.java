package googlejam8.p410;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PrintWriter out = new PrintWriter(System.out);
		for (int caze = 1; caze <= T; caze++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] sens = new int[n];
			int m = 0;
			for (int i = 0; i < n; i++) {
				sens[i] = Integer.parseInt(st.nextToken());
				m += sens[i];
			}
			List<Character> ret = new ArrayList<Character>();
			boolean started = false;
			StringBuilder sb = new StringBuilder();
			while (m > 0) {
				if (!started) {
					started = true;
				} else {
					sb.append(" ");
				}
				int max1 = Integer.MIN_VALUE;
				int min1 = -1;
				int min2 = -1;
				int max2 = Integer.MIN_VALUE;
				for (int i = 0; i < sens.length; i++) {
					if (sens[i] > max1) {
						min1 = i;
						max1 = sens[i];
					}
				}
				for (int i = 0; i < sens.length; i++)
					if (i != min1) {
						if (sens[i] > max2) {
							min2 = i;
							max2 = sens[i];
						}
					}
				sens[min1]--;
				m--;
				sb.append(Character.toChars('A' + min1)[0]);
				if (m > 0 && m != 2) {
					sens[min2]--;
					m--;
					sb.append(Character.toChars('A' + min2)[0]);
				}
			}
			out.write(String.format("Case #%d: %s", caze, sb.toString()));
			out.write('\n');
		}
		out.close();
	}

}
