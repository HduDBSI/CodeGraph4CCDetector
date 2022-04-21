package googlejam8.p274;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SeanteEvacuation {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("A-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(bf.readLine());
			int a[] = new int[n];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int sum = 0;
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				sum += a[i];
			}
			String s = "";
			while (true) {
				//out.println("hello");
				if (sum <= 0)
					break;
				int max = -1;
				int maxi = -1;
				for (int i = 0; i < n; i++)
					if (a[i] > max) {
						max = a[i];
						maxi = i;
					}
				s += " " + (char) (maxi + 'A');
				a[maxi]--;
				sum--;
				max = -1;
				maxi = -1;
				for (int i = 0; i < n; i++)
					if (a[i] > max) {
						max = a[i];
						maxi = i;
					}
				if (max > sum / 2) {
					s += (char) (maxi + 'A');
					a[maxi]--;
					sum--;
				}
			}
			out.println("Case #" + tc + ":" + s);
		}
		out.flush();
		out.close();
	}
}
