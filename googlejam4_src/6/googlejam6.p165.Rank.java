package googlejam6.p165;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Rank {
	public static void main (String[] args) throws IOException {
		FileReader fin = new FileReader("RankInput.txt");
		BufferedReader bin = new BufferedReader (fin);
		int t = Integer.parseInt(bin.readLine());
		FileWriter fout = new FileWriter("RankOutput.txt");
		BufferedWriter bout = new BufferedWriter(fout);
		PrintWriter pout = new PrintWriter(bout);
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bin.readLine());
			String answer = "";
			int count[] = new int[2501];
			for (int j = 0; j < 2501; j++) count[j] = 0;
			for (int j = 0; j < 2*n-1; j++) {
				String s = bin.readLine();
				StringTokenizer sb = new StringTokenizer(s);
				for (int k = 0; k < n; k++) {
					int l = Integer.parseInt(sb.nextToken());
					count[l]++;
				}
			}
			for (int j = 1; j < 2501; j++) {
				if (count[j]%2 == 1) {
					answer = answer + "" + j + " ";
				}
			}
			pout.println("Case #"+(i+1)+": "+answer.trim());
		}
		pout.close();
	}
}
