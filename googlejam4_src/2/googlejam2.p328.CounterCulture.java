package googlejam2.p328;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


public class CounterCulture {

	public static void main(String[] args) throws Exception {
		long[] ret = new long[1000001];
		Arrays.fill(ret, Long.MAX_VALUE);
		ret[0] = 0;
		for(int i=0; i<1000000; ++i){
			ret[i+1] = Math.min(ret[i]+1, ret[i+1]);
			int rev = Integer.valueOf(new StringBuilder(Integer.toString(i)).reverse().toString());
			if(rev <= 1000000) {
				ret[rev] = Math.min(ret[i]+1, ret[rev]);
			}
		}
		long[] smallAnswer = ret;

		Scanner s = new Scanner(new File("A-small.in"));

		int caseNum = s.nextInt();
		for (int t = 1; t <= caseNum; ++t) {
			int n = s.nextInt();

			System.out.println("Case #" + t + ": " + smallAnswer[n]);
		}
	}

}
