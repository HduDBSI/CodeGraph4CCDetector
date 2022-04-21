package googlejam9.p102;


import java.util.Scanner;

/**
 * Created by LevinLMKwong on 8/5/16.
 */
public class B {
    public static void main(String[] args) {
        long[] max = new long[51];
        max[0] = 0; max[1] = 0; max[2] = 1;
        for (int i = 3; i <= 50; i++) {
            max[i] = max[i-1] * 2;
        }
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            int B = in.nextInt();
            long M = in.nextLong();
            if (M > max[B]) {
                System.out.format("Case #%d: IMPOSSIBLE\n", t);
            } else {
                System.out.format("Case #%d: POSSIBLE\n", t);
                if (M == max[B]) {
                    for (int i = 0; i < B; i++) {
                        for (int j = 0; j < B; j++) {
                            if (j>i) System.out.print('1');
                            else System.out.print('0');
                        }
                        System.out.println();
                    }
                } else {
                    String binaryB = Long.toBinaryString(M);
                    binaryB = '0' + binaryB + '0';
                    while (binaryB.length() < B) {
                        binaryB = '0' + binaryB;
                    }
                    System.out.println(binaryB);
                    boolean flag = false;
                    for (int i = 1; i < B; i++) {
                        if (binaryB.charAt(i) == '1') {
                            flag = true;
                        }
                        for (int j = 0; j < B; j++) {
                            if (flag && j>i) System.out.print('1');
                            else System.out.print('0');
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
