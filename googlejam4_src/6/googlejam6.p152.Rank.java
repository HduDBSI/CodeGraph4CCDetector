package googlejam6.p152;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Rank {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Scanner sc;
        int cases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= cases; i++) {
            System.out.print(String.format("Case #%d:", i));
            int n = Integer.parseInt(br.readLine());
			int[] counts = new int[3000];
			for (int i2 = 0; i2 < 2*n - 1; i2++) {
			    StringTokenizer st1 = new StringTokenizer(br.readLine());
				int[] arr = new int[n];
				for (int i11 = 0; i11 < n; i11++) {
				    arr[i11] = Integer.parseInt(st1.nextToken());
				}
				int[] line = arr;
			    for (int sol : line) {
			        counts[sol]++;
			    }
			}
			int[] out = new int[n];
			int j = 0;
			for (int i1 = 0; i1 < 3000; i1++) {
			    if (counts[i1] % 2 == 1) {
			        out[j++] = i1;
			    }
			}
			for (int q : out) {
			    System.out.print(" " + q);
			}
			System.out.println();
        }
    }
}
