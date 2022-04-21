package googlejam8.p130;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Formatter;
import java.util.Locale;
import java.util.StringTokenizer;

public class A {

	static StringBuilder sb = new StringBuilder();
	static Formatter buf = new Formatter(sb, Locale.US);
	static int T;
	static int N; 
	static int[] P;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("A-small.in"));
		System.setOut(new PrintStream("A-small.out"));
		StringTokenizer st;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for (int c = 1; c <= T; c++) {
			N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			P = new int[N];
			for (int i = 0; i < N; i++) P[i]=Integer.parseInt(st.nextToken()); 
			buf.format("Case #%d:", c);
			String s;
			while(true){
				int su = 0;
				for (int i = 0; i < P.length; i++) {
					su = su + P[i];
				}
				if (su==3){
					int m=0;
					for (int i = 1; i < P.length; i++) {
						if (P[i]>P[m]) m=i;
					}
					if (P[m]==0) break;
					s = ""+(char)('A'+m);
					buf.format(" %s", s);
					P[m]--;
					continue;
				}
				int m=0;
				for (int i = 1; i < P.length; i++) {
					if (P[i]>P[m]) m=i;
				}
				if (P[m]==0) break;
				s = ""+(char)('A'+m);
				buf.format(" %s", s);
				P[m]--;
				m=0;
				for (int i = 1; i < P.length; i++) {
					if (P[i]>P[m]) m=i;
				}
				if (P[m]==0) break;
				s = ""+(char)('A'+m);
				P[m]--;
				buf.format("%s", s);
			}
			buf.format("\n");
		}
		System.out.print(sb.toString());
	}

}
