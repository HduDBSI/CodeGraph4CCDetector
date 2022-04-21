package googlejam1.p629;
//package codechef;
import java.io.*;

class CodeJAM {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()), n, x, c, r, arr[];
        String s[], ss;
        for (int bv = 1; bv <= t; bv++) {
            n = Integer.parseInt(br.readLine());
            s = br.readLine().split(" ");
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int max = 0;
            for (int i = 1; i < n; i++) {
                if ((arr[i-1] - arr[i]) > max) {
                    max = arr[i -1] - arr[i];
                }
            }
            long ans = 0;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] <= max) {
                    ans = ans + (long)arr[i];
                } else {
                    ans += (long)max;
                }
            }
            long ans1 = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    ans1 += (long)(arr[i - 1] - arr[i]);
                }
            }
            System.out.println("Case #"+bv+": "+ans1+" "+ans);
        }
    }
}
