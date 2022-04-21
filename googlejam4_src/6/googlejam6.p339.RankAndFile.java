package googlejam6.p339;
import java.io.*;
import java.util.*;

public class RankAndFile {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileReader(args[0]));
		PrintWriter pw = new PrintWriter(new FileWriter(args[0]+".out.txt"));

		int numOfCase = sc.nextInt();
		List<Character> list = null;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numOfCase; i++) {
			int size = sc.nextInt();
			int numOfNum = (2 * size - 1) * size;
			TreeSet<Integer> set = new TreeSet<Integer>();

			for (int j = 0; j < numOfNum; j++) {
				int height = sc.nextInt();
				if (set.contains(height)) set.remove(height);
				else set.add(height);
			}
			sb.setLength(0);
			while (!set.isEmpty()) {
				sb.append(' ');
				sb.append(set.pollFirst());
			}
			pw.println("Case #" + (i + 1) + ":" + sb.toString());
		}

		pw.flush();
		pw.close();
		sc.close();
	}
}