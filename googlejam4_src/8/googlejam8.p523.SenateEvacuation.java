package googlejam8.p523;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SenateEvacuation {
	static PrintWriter writer;

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner sc = new Scanner(new File("in.txt"));
		writer = new PrintWriter("out.txt", "UTF-8");
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int[] s = new int[n];
			int count = 0;
			for (int i = 0; i < n; i++) {
				s[i] = sc.nextInt();
				count += s[i];
			}
			System.out.println(Arrays.toString(s));
			String evac = "";
			while (count > 0) {

				ArrayList<Integer> candidate = new ArrayList<>();
				// for (int i=0;i<n;i++)candidate.add(i);

				top: for (int i = 0; i < n; i++) {
					for (int k = 0; k < n; k++) {
//						System.out.println(Arrays.toString(s));
						boolean ij = false;
						boolean ik = false;
						if (s[i] > 0) {
							s[i]--;
							count--;
							ij = true;
						}
						if (s[k] > 0) {
							s[k]--;
							count--;
							ik = true;
						}
						if (!ij&&!ik)continue;
						boolean flag = true;
						for (int j = 0; j < n; j++) {
							if (s[j] > count / 2) {
								flag = false;
								break;
							}
						}
						if (flag) {
							if (ij) {
								candidate.add(i);
							}
							if (ik)
								candidate.add(k);
							break top;
						} else {
							if (ij) {
								s[i]++;
								count++;
							}
							if (ik) {
								s[k]++;
								count++;
							}
						}
					}
				}
				for (int i : candidate) {
					evac += (char) (65 + i);
					// s[i]--;
					// count--;
				}
				evac += " ";
				// System.out.println(evac);

			}

			evac = evac.substring(0, evac.length() - 1);
			String s1 = "Case #" + (t + 1) + ": " + evac;
			writer.println(s1);
			System.out.println(s1);
		}
		writer.close();
	}
}
