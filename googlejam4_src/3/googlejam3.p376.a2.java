package googlejam3.p376;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;


class A {

	static int MB = 1 << 20;
	static BufferedReader br = new BufferedReader( new InputStreamReader(System.in, StandardCharsets.US_ASCII), 30*MB);
	static StringTokenizer st;
	
	static String NL() throws Exception {
		String line = br.readLine();
		st = new StringTokenizer(line);
		return line;
	}
	
	static String NT() {
		return st.nextToken();
	}
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(NL());
		for (int ii = 1; ii <= T; ii++) {
			NL();
			int R, C, W;
			R = Integer.parseInt(NT());
			C = Integer.parseInt(NT());
			W = Integer.parseInt(NT());
			print(ii, solve(R, C, W));
		}
	}

	private static void print(int ii, int sol) {
		System.out.printf("Case #%d: %d%n", ii, sol);
	}

	private static int solve(int R, int C, int W) {
		int res = (R-1) * singleRow(C, W);
		return res + simple(C, W);
	}

	private static int simple(int C, int W) {
        if (C == W) return C;
		return (C >= 2 * W) ? 1 + simple(C - W, W) : W+1;
	}

	private static int singleRow(int C, int W) {
		return C > W ? 1 + singleRow(C - W, W) : 1;
	}
	
}
