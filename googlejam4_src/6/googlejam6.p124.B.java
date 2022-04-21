package googlejam6.p124;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fin = new FileInputStream("B-large.in.txt");
        Scanner scanner = new Scanner(fin);
        FileOutputStream fout = new FileOutputStream("B-large.out.txt");
        PrintWriter writer = new PrintWriter(fout);
        int testCount = scanner.nextInt();
        for (int testCase = 1; testCase <= testCount; ++testCase) {
            int n = scanner.nextInt();
            int[][] a = new int[2*n-1][n];
            for (int i = 0; i < 2*n-1; ++i) {
                for (int j = 0; j < n; ++j) {
                    a[i][j] = scanner.nextInt();
                }
            }
			Map<Integer, Integer> m = new HashMap<>();
			for (int[] ar : a) {
			    for (int e : ar) {
			        if (!m.containsKey(e)) {
			            m.put(e, 0);
			        }
			        m.put(e, m.get(e) + 1);
			    }
			}
			int[] res1 = new int[a[0].length];
			int i1 = 0;
			for (int e : m.keySet()) {
			    if (m.get(e) % 2 == 1) {
			        res1[i1++] = e;
			    }
			}
			Arrays.sort(res1);
            int[] res = res1;
            String out = "" + res[0];
            for (int i = 1; i < res.length; ++i) {
                out += " " + res[i];
            }
            writer.printf("Case #%d: %s\n", testCase, out);
        }
        writer.close();
    }
}
