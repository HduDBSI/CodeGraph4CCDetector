package googlejam8.p039;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;


public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s = r.readLine();
		int T = Integer.parseInt(s);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			sb.append("Case #" + (i+1) + ":");
			s = r.readLine();
			int N = Integer.parseInt(s);
			s = r.readLine();
			String[] parts = s.split(" ");
			int[] nrs = new int[N];
			int count = 0;
			for (int j = 0; j < N; j++) {
				nrs[j] = Integer.parseInt(parts[j]);
				count += nrs[j];
			}
			while (count != 0) {
				int max = 0;
				char[] maxP = new char[2];
				int[] takes = new int[2];
				for (int j = 0; j < N; j++) {
					if (nrs[j] > max) {
						max = nrs[j];
						takes[0] = j;
						takes[1] = -1;
						maxP[0] = (char) (((int) ('A')) + j);
						maxP[1] = 0;
					} else if (nrs[j] == max) {
						maxP[1] = (char) (((int) ('A')) + j);
						takes[1] = j;
					}
				}
				if (takes[1] != -1) {
					if (count == 3) {
						sb.append(" " + maxP[0]);
						nrs[takes[0]]--;
						count--;
					} else {
						sb.append(" " + maxP[0] + maxP[1]);
						nrs[takes[0]]--;
						nrs[takes[1]]--;
						count-=2;
					}
				} else {
					sb.append(" " + maxP[0]);
					nrs[takes[0]]--;
					count--;
				}
			}
			sb.append("\n");
		}		
		System.out.println(sb.toString());
		PrintWriter writer = new PrintWriter("Qual1C.AAA.txt", "UTF-8");
		writer.println(sb.toString());
		writer.close();
	}

}
