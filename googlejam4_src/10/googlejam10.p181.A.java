package googlejam10.p181;
import java.io.*;
import java.util.*;

public class A {
    public static void main(String[]args) throws IOException {
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(x.readLine());
        for (int cases = 1; cases <= t; cases++) {
            StringTokenizer st = new StringTokenizer(x.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
			int num1 = 1;
			for (int i1 = 0; i1 < n; i1++) {
			    num1 *= 2;
			}
            //check possibility
            int num = num1;
            if (n % 2 == 1) num++;
            num /= 3;
            if ((r == num && s == num) || (s == num && p == num) || (r == num && p == num)) {
                if (n == 1) {
                    if (r == 0) System.out.println("Case #" + cases + ": PS");
                    if (s == 0) System.out.println("Case #" + cases + ": PR");
                    if (p == 0) System.out.println("Case #" + cases + ": RS");
                    continue;
                }
                String ans = "";
                if (n % 2 == 0) {
                    if (p != num) ans = "S";
                    if (r != num) ans = "P";
                    if (s != num) ans = "R";
                } else {
                    if (p != num) ans = "P";
                    if (r != num) ans = "R";
                    if (s != num) ans = "S";
                }
                for (int i = n - 1; i >= 0; i--) {
                    String temp = "";
                    for (int j = 0; j < ans.length(); j++) {
                        if (ans.charAt(j) == 'S') {
                            if (i % 6 == 0 || i % 6 == 1 || i % 6 == 5) {
                                temp += "PS";
                            } else {
                                temp += "SP";
                            }
                        }
                        if (ans.charAt(j) == 'P') {
                            if (i % 6 == 0 || i % 6 == 1 || i % 6 == 2) {
                                temp += "PR";
                            } else {
                                temp += "RP";
                            }
                        }
                        if (ans.charAt(j) == 'R') {
                            if (i % 6 == 0 || i % 6 == 4 || i % 6 == 5) {
                                temp += "RS";
                            } else {
                                temp += "SR";
                            }
                        }
                    }
                    ans = temp;
                }
                System.out.println("Case #" + cases + ": " + ans);
            } else {
                System.out.println("Case #" + cases + ": IMPOSSIBLE");
            }
        }
    }
}