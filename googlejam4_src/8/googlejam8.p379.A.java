package googlejam8.p379;


import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws NumberFormatException,
            IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1024 * 1024 * 2);

        int t = Integer.parseInt(br.readLine());

        long time = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int x = 1; x <= t; x++) {
            int n = Integer.valueOf(br.readLine());
			String line = br.readLine();
			int[] ret = new int[n];
			int start = 0;
			int end = line.indexOf(' ', start);
			for (int i1 = 0; i1 < n; i1++) {
			    if (end > 0)
			        ret[i1] = Integer.parseInt(line.substring(start, end));
			    else
			        ret[i1] = Integer.parseInt(line.substring(start));
			    start = end + 1;
			    end = line.indexOf(' ', start);
			}
            int vals[] = ret;

            int sum = 0;
            for ( int i = 0 ; i < n ; i ++ ) {
                sum += (vals[i]);
            }


            sb.append("Case #" + x + ": " );
            while (Arrays.stream(vals).filter(x1->x1>0).count() > 2) {
                int max = 0;
                int imax = -1;
                for (int i = 0 ;i <n ; i ++) {
                    if (max < vals[i]) {
                        max = vals[i];
                        imax = i;
                    }
                }
                int iimax = -1;
                int max2 = 0;
                for (int i = 0 ;i <n ; i ++) {
                    if (max2 < vals[i] && i != imax) {
                        max2 = vals[i];
                        iimax = i;
                    }
                }
                char c1 = (char) (imax + 'A');
                char c2 = (char) (iimax + 'A');
                if (sum % 2 == 1) {
                    sb.append(c1 + " ");
                    vals[imax] -= 1;
                    sum -= 1;
                }else {
                    if (vals[imax] > 2 && vals[imax] - 2 > (sum - 2) / 2) {
                        sb.append(c1 + "" + c1 + " ");
                        vals[imax] -= 2;
                        sum -= 2;
                    } else {
                        sb.append(c1 + "" + c2 + " ");
                        vals[imax]--;
                        vals[iimax]--;
                        sum -= 2;
                    }
                }


            }

            if (Arrays.stream(vals).filter(x2->x2>0).count() == 2) {
                int max = 0;
                int imax = -1;
                for (int i = 0 ;i <n ; i ++) {
                    if (max < vals[i]) {
                        max = vals[i];
                        imax = i;
                    }
                }
                int iimax = -1;
                int max2 = 0;
                for (int i = 0 ;i <n ; i ++) {
                    if (max2 < vals[i] && i != imax) {
                        max2 = vals[i];
                        iimax = i;
                    }
                }
                for (int i = 0 ; i<sum/2; i++) {
                    sb.append((char)('A' + imax));
                    sb.append((char)('A' + iimax));
                    sb.append(" ");
                }
            }
            sb.append("\n");

        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("ii/outAJam"));
        bw.write(sb.toString());
        bw.close();
        System.out.println(sb.toString());
        System.out.println(-time + System.currentTimeMillis());
    }
}
