package googlejam10.p160;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("A.in")));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("A.out"))));

		String[][] prs = new String[13][3];
		prs[0][0] = "P";
		prs[0][1] = "R";
		prs[0][2] = "S";
		int[][] prsp = new int[13][3];
		int[][] prsr = new int[13][3];
		int[][] prss = new int[13][3];
		prsp[0][0] = 1;
		prsr[0][1] = 1;
		prss[0][2] = 1;
		for (int n = 0; n < 12; n++) {
			prsp[n+1][0] = prsp[n][0] + prsp[n][1];
			prsp[n+1][1] = prsp[n][1] + prsp[n][2];
			prsp[n+1][2] = prsp[n][2] + prsp[n][0];
			prsr[n+1][0] = prsr[n][0] + prsr[n][1];
			prsr[n+1][1] = prsr[n][1] + prsr[n][2];
			prsr[n+1][2] = prsr[n][2] + prsr[n][0];
			prss[n+1][0] = prss[n][0] + prss[n][1];
			prss[n+1][1] = prss[n][1] + prss[n][2];
			prss[n+1][2] = prss[n][2] + prss[n][0];
			if (prs[n][0].compareTo(prs[n][1]) < 0) prs[n+1][0] = prs[n][0]+prs[n][1];
			else prs[n+1][0] = prs[n][1]+prs[n][0];
			if (prs[n][1].compareTo(prs[n][2]) < 0) prs[n+1][1] = prs[n][1]+prs[n][2];
			else prs[n+1][1] = prs[n][2]+prs[n][1];
			if (prs[n][2].compareTo(prs[n][0]) < 0) prs[n+1][2] = prs[n][2]+prs[n][0];
			else prs[n+1][2] = prs[n][0]+prs[n][2];
		}
		
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int R = Integer.parseInt(str[1]);
			int P = Integer.parseInt(str[2]);
			int S = Integer.parseInt(str[3]);
			
			String answer = "IMPOSSIBLE";
			
			if (prsp[N][0] == P && prsr[N][0] == R && prss[N][0] == S) answer = prs[N][0];
			else if (prsp[N][1] == P && prsr[N][1] == R && prss[N][1] == S) answer = prs[N][1];
			else if (prsp[N][2] == P && prsr[N][2] == R && prss[N][2] == S) answer = prs[N][2];
			
			pw.println("Case #"+(t+1)+": "+answer);
			pw.flush();
		}
		
		pw.close();
		br.close();
	}
}
