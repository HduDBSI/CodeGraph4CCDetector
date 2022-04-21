package googlejam2.p308;
import java.util.Scanner;

public class GCJ2015A2 {
    static long n;
    static long[] result = new long[1000001];

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 1000000; i++) {
		    result[i] = i;
		}
		while (true) {
		    boolean good = true;
		    for (int i = 1; i <= 1000000; i++) {
		        StringBuilder sb = new StringBuilder("" + i);
				sb.reverse();
				int n1 = Integer.parseInt(sb.toString());
		        if (result[i] + 1 < result[n1]) {
		            result[n1] = result[i] + 1;
		            good = false;
		        }
		        if (i == 1000000) {
		            continue;
		        }
		        if (result[i] + 1 < result[i + 1]) {
		            result[i + 1] = result[i] + 1;
		            good = false;
		        }
		    }
		    if (good) {
		        break;
		    }
		}
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            n = sc.nextLong();
            System.out.println("Case #" + k + ": " + result[(int) n]);
        }
    }

}
