package googlejam2.p364;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static int[] ans = new int[10000002];

	public static void main(String[] args) throws Exception {
		Arrays.fill(ans, -1);
		ans[0] = 1;
		ans[1] = 1;
		for (int i1 = 1; i1 <= 10000000; i1++) {
			if (ans[i1 + 1] == -1)
				ans[i1 + 1] = ans[i1] + 1;
			else{
				ans[i1+1] = Math.min(ans[i1+1] , ans[i1]+1);
			}
			int n = i1;
			int reverse = 0;
			while (n != 0) {
				reverse = reverse * 10;
				reverse = reverse + n % 10;
				n = n / 10;
			}
			int rev = reverse;
			if (rev <= 10000000) {
				if (ans[rev] == -1) {
					ans[rev] = ans[i1] + 1;
				} else {
					if(ans[i1] < ans[rev])
						System.out.println(i1 + ": " + ans[i1] + "  " + ans[rev]);
					ans[rev] = Math.min(ans[i1] + 1, ans[rev]);
				}
			}
		}
		System.out.println("end");
		PrintWriter printer = new PrintWriter("ans.txt", "UTF-8");
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int input = sc.nextInt();
			printer.println("Case #" + i + ": " + ans[input]);
		}
		printer.close();
		sc.close();
	}

}
