package googlejam1.p050;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("Round1A2015/A-l.in"));
		System.setOut(new PrintStream("src/Round1A2015/A-l.out"));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t= 1 ; t <= T; t++){
			int N = Integer.parseInt(br.readLine());
			String tmp[] = br.readLine().trim().split("\\s+");
			int m[] = new int[N];
			for (int i = 0 ; i < N ;i++){
				m[i] = Integer.parseInt(tmp[i]);
			}
			
			long sum = 0;
			int max = 0;
			for (int i = 1; i < N ;i++){
				int d = m[i-1] - m[i];
				if (d > 0) {
					sum += d;
					if (d > max) max = d;
				}
			}
			
			long sum2 = 0;
			for (int i = 0; i < N-1 ;i++){
				if (m[i] > max) {
					sum2 += max;
				} else sum2+= m[i];
			}
			
			System.out.print(String.format("Case #%d: %d %d\n",t,sum,sum2));
		}

	}

}
