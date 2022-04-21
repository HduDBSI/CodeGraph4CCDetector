package googlejam9.p113;
import java.util.*;

public class B {

	public static void main(String[] args) {
		B b = new B();
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		for (int a=0; a<cases; a++) {
			String[] line = in.nextLine().split(" ");
			int b1 = Integer.parseInt(line[0]);
			long m = Long.parseLong(line[1]);
			boolean[][] connected = new boolean[b1][b1];
			long[] value = new long[b1];
			value[b1-1] = 1;
			value[b1-2] = 1;
			connected[b1-2][b1-1] = true;
			for (int i=b1-3; i>=0; i--) {
				int j = i+1;
				while (j < b1 && value[i] < m) {
					if (value[i] + value[j] <= m) {
						value[i] += value[j];
						connected[i][j] = true;
					}
					j++;
				}
			}
			if (value[0]==m) {
				System.out.printf("Case #%d: POSSIBLE\n",a+1);
				int b2 = connected.length;
				for (int i=0; i<b2; i++) {
					StringBuilder build = new StringBuilder();
					for (int j=0; j<b2; j++) {
						if (connected[i][j]) {
							build.append(1);
						}
						else {
							build.append(0);
						}
					}
					System.out.println(build.toString());
				}
			}
			else {
				System.out.printf("Case #%d: IMPOSSIBLE\n",a+1);
			}
		}
	}
}