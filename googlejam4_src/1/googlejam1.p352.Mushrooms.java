package googlejam1.p352;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Mushrooms {
	static PrintWriter writer;

	public static void main(String[] args) throws Exception {
		writer = new PrintWriter("out.txt", "UTF-8");
		Scanner sc = new Scanner(new File("in.txt"));
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			// -------------------------------------------------------------------------------------
			int N = sc.nextInt();
			int[] m = new int[N];
			for (int n = 0; n < N; n++) {
				m[n] = sc.nextInt();
			}

			// method 1
			int max = Integer.MIN_VALUE;
			int method1 = 0;
			for (int i = 0; i < N; i++) {
				if (m[i] > max) {
					max = m[i];
				} else {
					method1 += max - m[i];
					max = m[i];
				}
			}
			max = Integer.MIN_VALUE;
			for (int i = 0; i < N - 1; i++) {
				int diff = m[i] - m[i + 1];
				if (diff > max)
					max = diff;
			}
			
			int rate10 = max;
			int mushrooms =0;
			int cnt = 0;
			//System.out.println(rate10);
			for (int i = 0; i < N-1 ; i++) {
				//System.out.println("$"+mushrooms);
				mushrooms = m[i];

				if (rate10 >= mushrooms) {
					cnt += mushrooms;
					mushrooms = 0;
				} else {
					cnt += rate10;
					mushrooms -= rate10;
				}

			}
			//System.out.println(mushrooms);
			String s = "Case #" + (t + 1) + ": " + method1+" "+cnt;
			System.out.println(s);
			writer.println(s);
			// -------------------------------------------------------------------------------------
		}
		writer.flush();
		writer.close();
	}

}
