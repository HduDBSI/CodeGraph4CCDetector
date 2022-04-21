package googlejam1.p293;
import java.io.BufferedInputStream;
import java.util.Scanner;


public class TaskA {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
			int[] result = new int[n];
			for (int i1 = 0; i1 < n; i1++) {
			    result[i1] = sc.nextInt();
			}
            int[] m = result;
            int answer1 = 0;
            for (int j = 1; j < n; j++) {
                if (m[j] < m[j-1]) {
                    answer1 += (m[j-1] - m[j]);
                }
            }
            int answer2 = 0;
            int maxSpeed = 0;
            for (int j = 1; j < n; j++) {
                if (m[j] < m[j-1] && m[j-1] - m[j] > maxSpeed) {
                    maxSpeed = m[j-1] - m[j];
                }
            }
            for (int j = 1; j < n; j++) {
                if (m[j-1] > maxSpeed) {
                    answer2 += maxSpeed;
                }
                else {
                    answer2 += m[j-1];
                }
            }            
            System.out.println("Case #" + (i+1) + ": " + answer1 + " " +answer2);
        }
        sc.close();
        System.err.println(System.currentTimeMillis() - time);
    }
}
