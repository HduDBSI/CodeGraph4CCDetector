package googlejam8.p181;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fin = new FileInputStream("A-large.in.txt");
        Scanner scanner = new Scanner(fin);
        FileOutputStream fout = new FileOutputStream("A-large.out.txt");
        PrintWriter writer = new PrintWriter(fout);
        int testCount = scanner.nextInt();
        for (int testCase = 1; testCase <= testCount; ++testCase) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = scanner.nextInt();
            }
            writer.printf("Case #%d: %s\n", testCase, solve(a));
        }
        writer.close();
    }

    private static String solve(int[] a) {
        int n = a.length;

        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += a[i];
        }

        String res = "";
		int n1 = a.length;
		int idx1 = -1;
		int max = 0;
		for (int i = 0; i < n1; ++i) {
		    if (a[i] > max) {
		        max = a[i];
		        idx1 = i;
		    }
		}
        int idx = idx1;
        while (true) {
            --a[idx];
            --sum;
            res += (char)('A' + idx);
            if (sum == 0) {
                break;
            }
			int n2 = a.length;
			int idx2 = -1;
			int max = 0;
			for (int i = 0; i < n2; ++i) {
			    if (a[i] > max) {
			        max = a[i];
			        idx2 = i;
			    }
			}
            idx = idx2;
            if (a[idx] * 2 <= sum) {
                res += " ";
            }
        }
        return res;
    }
}
