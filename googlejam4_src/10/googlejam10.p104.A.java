package googlejam10.p104;
import java.util.Scanner;

public class A {
    static String[] r = new String[13];
    static String[] p = new String[13];
    static String[] s = new String[13];

    public static void main(String[] args) {
        r[0] = "R";
        p[0] = "P";
        s[0] = "S";
        for (int i = 0; i < 12; i++) {
            if (r[i].compareTo(p[i]) < 0) {
                p[i + 1] = r[i] + p[i];
            } else {
                p[i + 1] = p[i] + r[i];
            }

            if (r[i].compareTo(s[i]) < 0) {
                r[i + 1] = r[i] + s[i];
            } else {
                r[i + 1] = s[i] + r[i];
            }

            if (s[i].compareTo(p[i]) < 0) {
                s[i + 1] = s[i] + p[i];
            } else {
                s[i + 1] = p[i] + s[i];
            }
        }

        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int N = sc.nextInt();

            int[] R = new int[N + 1];
            R[0] = sc.nextInt();
            int[] P = new int[N + 1];
            P[0] = sc.nextInt();
            int[] S = new int[N + 1];
            S[0] = sc.nextInt();

            for (int i = 0; i < N; i++) {
                P[i + 1] = (P[i] + R[i] - S[i]) / 2;
                R[i + 1] = (R[i] + S[i] - P[i]) / 2;
                S[i + 1] = (P[i] + S[i] - R[i]) / 2;
            }

            System.out.print("Case #" + caseNum + ": ");
            boolean possible = true;
            for (int i = 0; i <= N; i++) {
                if (R[i] < 0 || P[i] < 0 || S[i] < 0) {
                    System.out.println("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            if (!possible) {
                continue;
            }
            if (R[N] == 1) {
                System.out.println(r[N]);
            } else if (P[N] == 1) {
                System.out.println(p[N]);
            } else {
                System.out.println(s[N]);
            }
        }
        sc.close();
    }
}
