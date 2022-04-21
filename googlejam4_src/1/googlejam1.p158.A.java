package googlejam1.p158;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T, t, N, i, cur, maxdif, s1, s2, r10;
        double rate;
        int m[];
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt();
            m = new int[N];
            cur = 0;
            maxdif = 0;
            s1 = 0;
            s2 = 0;
            for(i = 0; i < N; i++) {
                m[i] = sc.nextInt();
                maxdif = Math.max(cur - m[i], maxdif);
                s1 += Math.max(cur - m[i], 0);
                cur = m[i];
            }
            rate = (double)maxdif / 10;
            
            r10 = (int)(rate*10);
            cur = 0;
            for(i = 0; i < N; i++) {
                s2 += Math.min(r10,cur);
                cur = m[i];
            }
                        
            System.out.println("Case #" + t + ": " + s1 + " " + s2);
        }
        sc.close();
    }
}
