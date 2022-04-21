package googlejam6.p582;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Timur on 16.04.2016.
 */
public class TaskB {
    public static void main(String args[]){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            int test = Integer.parseInt(in.readLine());
            int a[];
            for (int t = 1; t <= test; t++) {
                int n = Integer.parseInt(in.readLine());
                a = new int [3000];
                for (int i = 0; i < (2 * n - 1); i++) {
                    StringTokenizer st = new StringTokenizer(in.readLine());
                    for (int j =0 ;j < n; j++) {
                        int x = Integer.parseInt(st.nextToken());
                        a[x]++;
                    }
                }

                int pos = 0;
                int ans[] = new int [n];
                for (int i = 0; i < a.length; i++) {
                    if (a[i] % 2 == 1) {
                        ans[pos++] = i;
                    }
                }


                Arrays.sort(ans);
                System.out.print("Case #" + t + ": ");
                for (int i = 0; i < n; i++) {
                    System.out.print(ans[i]+" ");
                }
                System.out.println();
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
