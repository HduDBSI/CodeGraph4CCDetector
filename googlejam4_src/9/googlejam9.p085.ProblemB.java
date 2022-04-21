package googlejam9.p085;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemB {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		in = new Scanner(new File("B-large.in"));
		
		int T = in.nextInt();
		for (int i=1; i<=T; i++) {
			int B = in.nextInt();
			long M = in.nextLong();
			
			long temp = (long)Math.pow(2, B-2);
			if (M > temp) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", i);
			} else {
				boolean[] b = new boolean[B];
				for (int j=1; j<B; j++) {
					temp /= 2;
					if (M > temp) {
						M -= temp;
						b[B-1-j] = true;
					}
				}
				StringBuilder sb = new StringBuilder();
				for (int j=0; j<B; j++) {
					sb.append('\n');
					for (int k=0; k<=j; k++) {
						sb.append('0');
					}
					for (int k=j+1; k<B; k++) {
						if (k == B-1) {
							sb.append(b[j]?'1':'0');
						} else {
							sb.append('1');
						}
					}
				}
				System.out.printf("Case #%d: POSSIBLE", i);
				System.out.println(sb.toString());
			}
		}
	}
}