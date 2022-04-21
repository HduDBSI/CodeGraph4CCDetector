package googlejam8.p222;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class GCJR1 {

	public static void main(String[] args) throws Exception {
		Scanner cin = new Scanner(new FileInputStream("A-large (3).in"));
		PrintWriter cout = new PrintWriter(new FileOutputStream("output.txt"));
		int T = cin.nextInt();
		for (int t = 0; t < T; ++t) {
			int N = cin.nextInt();
			int[] a = new int[N];
			int sum = 0;
			for (int i = 0; i < N; ++i)
				sum += a[i] = cin.nextInt();
			int ind1 = -1, ind2 = -1;
			cout.print("Case #" + (t + 1) + ": ");
			while (sum > 0) {
				if (ind1 == -1) {
					int m1 = 0;
					for (int i1 = 1; i1 < a.length; ++i1)
						if (a[m1] < a[i1])
							m1 = i1;
					int m = m1;
					for (int i = 0; i < N; ++i)
						if (i != m && a[i] == a[m]) {
							ind1 = i;
							ind2 = m;
							break;
						}
				}
				if (ind1 != -1) {
					int fnd = -1;
					for (int i = 0; i < N; ++i)
						if (i != ind1 && i != ind2 && a[i] > 0) {
							fnd = i;
							break;
						}
					if (fnd != -1) {
						cout.print((char) ('A' + fnd) + " ");
						a[fnd]--;
						sum--;
					} else {
						cout.print((char) ('A' + ind1) + "" + (char) ('A' + ind2) + " ");
						sum -= 2;
						a[ind1]--;
						a[ind2]--;
					}
				} else {
					int m1 = 0;
					for (int i = 1; i < a.length; ++i)
						if (a[m1] < a[i])
							m1 = i;
					int m = m1;
					cout.print((char) ('A' + m) + " ");
					sum--;
					a[m]--;
				}
			}
			cout.println();
		}
		cout.flush();
	}

}
