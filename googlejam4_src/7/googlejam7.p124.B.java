package googlejam7.p124;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; ++t) {
            String s1 = new StringBuilder(in.next()).reverse().toString();
            String s2 = new StringBuilder(in.next()).reverse().toString();

            String res1 = "";
            String res2 = "";
            int diff = 1000;
            int minc = 1000;
            int mino = 1000;

            for (int a1 = 0; a1 < 10; ++a1) {
                if (s1.length() == 3 && s1.charAt(2) != '?' && s1.charAt(2) != '0' + a1) continue;
                for (int a2 = 0; a2 < 10; ++a2) {
                    if (s1.length() >= 2 && s1.charAt(1) != '?' && s1.charAt(1) != '0' + a2) continue;
                    for (int a3 = 0; a3 < 10; ++a3) {
                        if (s1.charAt(0) != '?' && s1.charAt(0) != '0' + a3) continue;

                        StringBuilder ss1 = new StringBuilder();
                        ss1.append((char)('0' + a3));
                        if (s1.length() >= 2) ss1.append((char)('0' + a2));
                        if (s1.length() == 3) ss1.append((char)('0' + a1));
                        ss1.reverse();


                        for (int a4 = 0; a4 < 10; ++a4) {
                            if (s2.length() == 3 && s2.charAt(2) != '?' && s2.charAt(2) != '0' + a4) continue;
                            for (int a5 = 0; a5 < 10; ++a5) {
                                if (s2.length() >= 2 && s2.charAt(1) != '?' && s2.charAt(1) != '0' + a5) continue;
                                for (int a6 = 0; a6 < 10; ++a6) {
                                    if (s2.charAt(0) != '?' && s2.charAt(0) != '0' + a6) continue;

                                    StringBuilder ss2 = new StringBuilder();
                                    ss2.append((char)('0' + a6));
                                    if (s2.length() >= 2) ss2.append((char)('0' + a5));
                                    if (s2.length() == 3) ss2.append((char)('0' + a4));
                                    ss2.reverse();

                                    int score1 = Integer.parseInt(ss1.toString());
                                    int score2 = Integer.parseInt(ss2.toString());

                                    int curdiff = Math.abs(score1 - score2);
                                    if (curdiff < diff) {
                                        res1 = ss1.toString();
                                        res2 = ss2.toString();
                                        diff = curdiff;
                                        minc = score1;
                                        mino = score2;
                                    } else if (curdiff == diff) {
                                        if (score1 < minc || (score1 == minc && score2 < mino)) {
                                            res1 = ss1.toString();
                                            res2 = ss2.toString();
                                            diff = curdiff;
                                            minc = score1;
                                            mino = score2;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("Case #" + t + ": " + res1 + " " + res2);
        }
    }
}
