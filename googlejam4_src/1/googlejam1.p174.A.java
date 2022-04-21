package googlejam1.p174;
import java.util.*;

class A {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int numTests = sc.nextInt();
		for (int test = 1; test <= numTests; test++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int aSum = 0;
			int maxDrop = 0;
			for (int i = 1; i < n; i++) {
				if (arr[i] < arr[i-1]) {
					aSum+= arr[i-1] - arr[i];
					maxDrop = Math.max(maxDrop, arr[i-1] - arr[i]);
				}
			}
			double rate = maxDrop / 10.0;
			double curr = arr[0];
			double bSum = 0;
			for (int i = 0; i < (n-1) * 10; i++) {
				if (i % 10 == 0) {
					curr = arr[i/10];
				}
				double newVal = Math.max(0, curr - rate);
				double delta = curr - newVal;
				curr -= delta;
				bSum += delta;
			}
			long l = Math.round(bSum);
			int intBSum = (int) l;
			// int bSum = 0;
			// int curr = arr[0] + maxDrop;
			// for (int i = 1; i < n; i++) {
			// 	System.out.println(curr-arr[i]);
			// 	bSum += curr - arr[i];
			// 	curr = arr[i] + maxDrop;
			// }
			System.out.printf("Case #%d: %d %d\n", test, aSum, intBSum);
		}
	}
}