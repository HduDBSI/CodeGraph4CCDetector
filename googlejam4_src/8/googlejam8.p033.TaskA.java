package googlejam8.p033;
import java.io.BufferedInputStream;
import java.util.Scanner;


public class TaskA {
    
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
			int[] result = new int[n];
			for (int i5 = 0; i5 < n; i5++) {
			    result[i5] = sc.nextInt();
			}
            int[] counts = result;
			int missing = -1;
			int maxInd1 = missing == 0 ? 1 : 0;
			for (int i3 = 1; i3 < counts.length; i3++) {
			    if (i3 != missing) {
			        if (counts[i3] > counts[maxInd1]) {
			            maxInd1 = i3;
			        }
			    }
			}
            int maxInd = maxInd1;
			int maxInd2 = maxInd == 0 ? 1 : 0;
			for (int i4 = 1; i4 < counts.length; i4++) {
			    if (i4 != maxInd) {
			        if (counts[i4] > counts[maxInd2]) {
			            maxInd2 = i4;
			        }
			    }
			}
            int secondInd = maxInd2;
            StringBuilder sb = new StringBuilder();
			int count = counts[maxInd] - counts[secondInd];
            String s1 = " " + (char) ('A' + maxInd) + (char) ('A' + maxInd);
			for (int i1 = 0; i1 < count / 2; i1++) {
			    sb.append(s1);
			}
			if (count % 2 == 1) {
			    sb.append(' ').append((char) ('A' + maxInd));
			}
            counts[maxInd] = counts[secondInd];
            for (int j = 0; j < n; j++) {
                if (j != maxInd && j != secondInd) {
                    int count1 = counts[j];
					String s2 = " " + (char) ('A' + j) + (char) ('A' + j);
					for (int i2 = 0; i2 < count1 / 2; i2++) {
					    sb.append(s2);
					}
					if (count1 % 2 == 1) {
					    sb.append(' ').append((char) ('A' + j));
					}
                }
            }
            String s = " " + (char) ('A' + maxInd) + (char) ('A' + secondInd);
            for (int j = 0; j < counts[maxInd]; j++) {
                sb.append(s);
            }
            System.out.println("Case #" + (i+1) + ":" + sb.toString());
        }
        sc.close();
        System.err.println(System.currentTimeMillis() - time);
    }

}
