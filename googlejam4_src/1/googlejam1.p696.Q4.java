package googlejam1.p696;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Q4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String prefix = "Case #%d: %d %d";
		
		String num = "A";
//		int time = 0;
//		String file = "E:\\downloads\\" + num + "-small-attempt" + time;
//		String file = "C-small-attempt1" + time;
		
//		String file = "E:\\downloads\\" + num + "-large";
		String file = num + "-large";
		
		BufferedReader br = new BufferedReader(new FileReader(file + ".in"));
		PrintWriter pw = new PrintWriter(file + ".out");
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int ans1 = 0;
			int ans2 = 0;
			int n = Integer.parseInt(br.readLine());
			int[] datas = new int[n];
			String[] raw = br.readLine().split(" ");
			for (int j = 0; j < datas.length; j++)
				datas[j] = Integer.parseInt(raw[j]);

			//1
			for (int j = 0; j < datas.length - 1; j++) {
				int f = datas[j];
				int s = datas[j + 1];
				
				if (s < f)
					ans1 += (f - s);
			}
			
			//2
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < datas.length - 1; j++) {
				int f = datas[j];
				int s = datas[j + 1];
				
				int c = f - s;
				if (c > max)
					max = c;
			}
			
			for (int j = 0; j < datas.length - 1; j++) {
				if (datas[j] < max)
					ans2 += datas[j];
				else
					ans2 += max;
			}
			
			pw.println(String.format(prefix, i, ans1, ans2));
		}
		
		br.close();
		pw.close();
	}
}
