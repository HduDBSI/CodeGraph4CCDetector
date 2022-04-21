package googlejam1.p737;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new FileReader("A-large.in"));
		//Scanner scan = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("A.txt")));
		int t = scan.nextInt();
		for (int q = 1; q <= t; q++) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			int ans1 = 0;
			int max = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextInt();
				if (i != 0 && (arr[i - 1] > arr[i])) {
					ans1 = ans1 + arr[i - 1] - arr[i];
					max = Math.max(max, arr[i - 1] - arr[i]);
				}
			}
			
			int ans2 = 0;
			for (int i = 0; i < n - 1; i++) {
				//pw.println(i + " " + arr[i] + " " + left + " " + ans2);
				if (arr[i] > max) {
					ans2 = ans2 + max;
				} else {
					ans2 = ans2 + arr[i];
				}
			}
			pw.write("Case #" + q + ": " + ans1 + " " + ans2 + "\n");
		}
		pw.close();
	}

}
