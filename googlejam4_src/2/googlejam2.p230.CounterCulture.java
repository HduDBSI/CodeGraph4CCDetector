package googlejam2.p230;

import java.util.Scanner;

public class CounterCulture {

    static int[] min;


    

//    static int next(int x, int N, int max) {
//        if (x == N) {
//            return 0;
//        }
//        if (x >= limit || max <= 0) {
//            return Integer.MAX_VALUE;
//        }
//        
//        if (max > N - x) {
//            max = N - x;
//        }
//        
//        int a = next(x + 1, N, max - 1);
//        int b = next(reverse(x), N, max - 1);
//        int result;
//        if (a <= b) {
//            result = a;
//        } else {
//            result = b;
//        }
//        if (result == Integer.MAX_VALUE) {
//            return Integer.MAX_VALUE;
//        }
//        return result + 1;
//    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int N = s.nextInt();
            min = new int[N + 1];
            for (int j = N - 1; j >= 0; j--) {
                min[j] = min[j + 1] + 1;
				int x = j;
				int result = 0;
				while (x != 0) {
				    result *= 10;
				    result += x % 10;
				    x /= 10;
				}
                int r = result;
                if (r > j && r <= N && min[r] + 1 < min[j]) {
                    min[j] = min[r] + 1;
                }
            }
            
            System.out.println("Case #" + i + ": " + min[0]);
        }
    }

}
