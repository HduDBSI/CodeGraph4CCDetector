package googlejam1.p323;
import java.util.*;

public class A {
    static Scanner s;
    public static void main(String[] args) {
        s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
			int[] arr = new int[n];
			for (int i1 = 0; i1 < n; i1++) {
			    arr[i1] = s.nextInt();
			}
			// First Case
			int prev = arr[0];
			int first = 0;
			for (int i3 = 1; i3 < n; i3++) {
			    if (arr[i3] < prev) {
			        first += prev - arr[i3];
			    }
			    prev = arr[i3];
			}
			
			// Second Case
			prev = arr[0];
			int max = 0;
			for (int i2 = 1; i2 < n; i2++) {
			    if (arr[i2] < prev) {
			        if (max < prev - arr[i2]) {
			            max = prev - arr[i2];
			        }
			    }
			    prev = arr[i2];
			}
			int second = 0;
			for (int i4 = 0; i4 < n-1; i4++) {
			    second += Math.min(max, arr[i4]);
			}
			System.out.println("Case #" + (i+1) + ": " + first + " " + second);
        }
    }
}
