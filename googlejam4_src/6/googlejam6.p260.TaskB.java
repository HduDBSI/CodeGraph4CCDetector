package googlejam6.p260;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;


public class TaskB {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
			int[] result = new int[2*n*n - n];
			for (int i2 = 0; i2 < 2*n*n - n; i2++) {
			    result[i2] = sc.nextInt();
			}
            int[] heights = result;
            int[] counts = new int[2501];
            for (int h : heights) {
                counts[h]++;
            }
            ArrayList<Integer> answer = new ArrayList<>(n);
            for (int j = 1; j < 2501; j++) {
                if (counts[j] % 2 == 1) {
                    answer.add(j);
                    if (answer.size() == n) {
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
			sb.append("Case #").append(i).append(":");
			for (Integer i1 : answer) {
			    sb.append(' ').append(i1);
			}
			System.out.println(sb.toString());
        }
        sc.close();
        System.err.println(System.currentTimeMillis() - time);
    }

}
