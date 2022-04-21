package googlejam6.p272;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RankAndFile {
	static PrintWriter writer;

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner sc = new Scanner(new File("in.txt"));
		writer = new PrintWriter("out.txt", "UTF-8");
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 0; i < 2 * n - 1; i++) {
				for (int j = 0; j < n; j++) {
					al.add(sc.nextInt());
				}
			}
			Collections.sort(al);
			ArrayList<Integer> left = new ArrayList<>();
			for (int i = 0; i < al.size(); i++) {
				int bb = al.get(i);
				if (i == al.size() - 1) {
					left.add(bb);
					break;
				}
				int cc = al.get(i + 1);
				if (bb == cc) {
					i++;
					continue;
				} else {
					left.add(bb);
				}

			}
			String m = "";
			for (Integer g : left)
				m += g + " ";
			m=m.substring(0,m.length()-1);
			String s = "Case #" + (t+1) + ": " + m;
			writer.println(s);
			System.out.println(s);

		}
		writer.close();
	}
}
