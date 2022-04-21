package googlejam8.p293;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoogleCodeJamA {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(in.readLine());
        for (int t =0;t<test;t++) {
            int n = Integer.parseInt(in.readLine());
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a[] = new int [40];
            int ost = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                ost += a[i];
            }
            String ans[] = new String[1000];
            int count = 0;
            while (ost > 0) {
                int max1 = -1;
                int max2 = -1;
                int max3 = -1;
                for (int i = 0; i < n; i++) {
                    if (max1 == -1 || a[i] > a[max1]) {
                        max3 = max2;
                        max2 = max1;
                        max1 = i;
                    } else
                    if (max2 == -1 || a[i] > a[max2]) {
                        max3 = max2;
                        max2 = i;
                    } else
                    if (max3 == -1 || a[i] > a[max3]) {
                        max3 = i;
                    }
                }
                if (ost == 3) {
                    ans[count++] = (char) (max1 + 'A') + "";
                    a[max1]--;
                    ost--;
                } else
                if (ost == 1) {
                    ans[count++] = (char) (max1 + 'A') + "";
                    a[max1]--;
                    ost--;
                } else
                if (a[max1] == a[max2]) {
                    ans[count++] = (char) (max1 + 'A') + "" + (char) (max2 + 'A');
                    a[max1] --;
                    a[max2] --;
                    ost-=2;
                } else {
                    if (a[max2] > ((ost - 2) / 2)) {
                        ans[count++] = (char) (max1 + 'A') + "" + (char) (max2 + 'A');
                        a[max1] --;
                        a[max2] --;
                        ost-=2;
                    } else {
                        ans[count++] = (char) (max1 + 'A') + "" + (char) (max1 + 'A');
                        a[max1] --;
                        a[max1] --;
                        ost-=2;
                    }
                }

            }
            System.out.print("Case #"+(t+1)+":");
            for (int i =0;i<count;i++) {
                System.out.print(" "+ans[i]);
            }
            System.out.println();

        }
        in.close();
    }
}
