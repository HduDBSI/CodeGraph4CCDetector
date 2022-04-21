package googlejam1.p060;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class MushroomMonster {
	public static void main(String[] args) throws Exception {
		String fileName = args[0];
		MushroomMonster obj = new MushroomMonster();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter bw = new BufferedWriter(
				new FileWriter(fileName + ".out"));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			Integer N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringTokenizer token = new StringTokenizer(str, " ");
		
			int[] m = new int[N];
			int max = 0;
			for (int j = 0; j < N; j++) {
				m[j] = Integer.parseInt(token.nextToken());
				if (j > 0 && m[j] - m[j - 1] < 0) {
					max = Math.max(max, m[j - 1] - m[j]);
				}
			}
		
			int ans_x = 0;
			int ans_y = 0;
			for (int j = 1; j < N; j++) {
				if (m[j] - m[j - 1] < 0) {
					ans_x += m[j - 1] - m[j];
				}
				if (m[j - 1] <= max) {
					ans_y += m[j - 1];
				} else {
					ans_y += max;
				}
			}
		
			bw.write("Case #" + (i + 1) + ": " + ans_x + " " + ans_y);
			bw.write("\r\n");
		}
		bw.close();
		br.close();
	}
}
