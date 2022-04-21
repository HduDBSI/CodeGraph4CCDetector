package googlejam7.p092;


import java.util.Scanner;

/**
 * Created by LevinLMKwong on 1/5/16.
 */
public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] ten = new long[19];
        ten[0] = 1; ten[1] = 10;
        for (int i = 2; i <= 18; i++) {
            ten[i] = ten[i-1]*10;
        }
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            String input = in.next();
            String C = "";
            for (int i = 0; i < input.length(); i++) {
                C += input.charAt(input.length()-i-1);
            }
            input = in.next();
            String J = "";
            for (int i = 0; i < input.length(); i++) {
                J += input.charAt(input.length()-i-1);
            }
            // 0 : C small , 1 : equal , 2 : C large
            long[][] f = new long[C.length()][3];
            String[][] ans_c = new String[C.length()][3];
            String[][] ans_j = new String[C.length()][3];
            for (int i = 0; i < C.length(); i++) {
                boolean[] a = new boolean[3];
                for (int c = 0; c <= 9; c++) {
                    if (C.charAt(i) != '?' && C.charAt(i) != ('0'+c)) {
                        continue;
                    }
                    for (int j = 0; j <= 9; j++) {
                        if (J.charAt(i) != '?' && J.charAt(i) != ('0'+j)) {
                            continue;
                        }
                        long small = 0, equal = 0, large = 0;
                        String ans_small_c = "", ans_equal_c = "", ans_large_c = "";
                        String ans_small_j = "", ans_equal_j = "", ans_large_j = "";
                        long temp = (c-j)*ten[i];
                        if (c > j) {
                            small = temp + ((i>0)? f[i-1][0] : 0);
                            ans_small_c = (i>0)? ans_c[i-1][0] : ""; ans_small_j = (i>0)? ans_j[i-1][0] : "";
                            equal = temp + ((i>0)? f[i-1][0] : 0);
                            ans_equal_c = (i>0)? ans_c[i-1][0] : ""; ans_equal_j = (i>0)? ans_j[i-1][0] : "";
                            large = temp + ((i>0)? f[i-1][2] : 0);
                            ans_large_c = (i>0)? ans_c[i-1][2] : ""; ans_large_j = (i>0)? ans_j[i-1][2] : "";
                        }
                        if (c == j) {
                            small = (i>0)? f[i-1][0] : 0;
                            ans_small_c = (i>0)? ans_c[i-1][0] : ""; ans_small_j = (i>0)? ans_j[i-1][0] : "";
                            equal = (i>0)? f[i-1][1] : 0;
                            ans_equal_c = (i>0)? ans_c[i-1][1] : ""; ans_equal_j = (i>0)? ans_j[i-1][1] : "";
                            large = (i>0)? f[i-1][2] : 0;
                            ans_large_c = (i>0)? ans_c[i-1][2] : ""; ans_large_j = (i>0)? ans_j[i-1][2] : "";
                        }
                        if (c < j) {
                            small = temp + ((i>0)? f[i-1][0] : 0);
                            ans_small_c = (i>0)? ans_c[i-1][0] : ""; ans_small_j = (i>0)? ans_j[i-1][0] : "";
                            equal = temp + ((i>0)? f[i-1][2] : 0);
                            ans_equal_c = (i>0)? ans_c[i-1][2] : ""; ans_equal_j = (i>0)? ans_j[i-1][2] : "";
                            large = temp + ((i>0)? f[i-1][2] : 0);
                            ans_large_c = (i>0)? ans_c[i-1][2] : ""; ans_large_j = (i>0)? ans_j[i-1][2] : "";
                        }
                        if (!a[0] || small < f[i][0]) {
                            f[i][0] = small; a[0] = true;
                            ans_c[i][0] = (char) (c+'0') + ans_small_c;
                            ans_j[i][0] = (char) (j+'0') + ans_small_j;
                        }
                        if (!a[1] || Math.abs(equal) < Math.abs(f[i][1])) {
                            f[i][1] = equal; a[1] = true;
                            ans_c[i][1] = (char) (c+'0') + ans_equal_c;
                            ans_j[i][1] = (char) (j+'0') + ans_equal_j;
                        }
                        if (!a[2] || large > f[i][2]) {
                            f[i][2] = large; a[2] = true;
                            ans_c[i][2] = (char) (c+'0') + ans_large_c;
                            ans_j[i][2] = (char) (j+'0') + ans_large_j;
                        }
                    }
                }
            }
            System.out.format("Case #%d: %s %s\n", t, ans_c[C.length()-1][1], ans_j[C.length()-1][1]);
        }
    }
}
