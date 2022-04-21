package googlejam9.p099;


import java.util.Scanner;

/**
 * Created by Benedek on 5/8/2016.
 */
public class CB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int B = in.nextInt();
            Long M = in.nextLong();
            String ans = "";
            if (Math.pow(2, B - 2) < M) {
                ans = "IMPOSSIBLE";
                System.out.printf("Case #%d: ", t);
                System.out.println(ans);
            } else {
                ans = "POSSIBLE";
                System.out.printf("Case #%d: ", t);
                System.out.println(ans);

                String binary = Long.toBinaryString(M-1);
                int l = binary.length();
                if (B == 2) {
                    if (M == 1) {
                        System.out.println("01");
                        System.out.println("00");
                    }
                } else {
                    for (int i = 0; i < B; i++) {
                        if (i == 0) {
                            String firstLine = "";
                            firstLine = binary + "1";
                            while (firstLine.length() < B) {
                                firstLine = "0" + firstLine;
                            }
                            System.out.print(firstLine);
                        } else {
                            for (int j = 0; j < B; j++) {
                                if (j <= i) {
                                    System.out.print("0");
                                } else {
                                    System.out.print("1");
                                }
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
