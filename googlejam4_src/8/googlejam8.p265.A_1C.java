package googlejam8.p265;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class A_1C {

	public static void main(String args[]) throws IOException {
		FileReader fileReader = new FileReader(
				"/home/parikh/Downloads/A-largeC.in");
		BufferedReader obj = new BufferedReader(fileReader);
		PrintWriter write = new PrintWriter(new File("/home/parikh/output.txt"));
		String l = obj.readLine();
		int t = Integer.parseInt(l);
		for (int k = 1; k <= t; k++) {

			String inp = obj.readLine();
			int n = Integer.parseInt(inp);
			int arr[] = new int[n];
			inp = obj.readLine();
			String sp[] = inp.split(" ");
			int sum = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(sp[i]);
				sum += arr[i];

			}
			StringBuilder str = new StringBuilder("");
			while (true) {

				int m1 = -1;
				int m2 = -1;
				int max = -1;
				for (int j = 0; j < n; j++) {
					if (arr[j] > max) {
						max = arr[j];
						m1 = j;

					}
				}
				arr[m1]--;
				str.append((char) (m1 + 'A'));
				if (sum % 2 == 1) {
					sum -= 1;
					str.append(" ");
					continue;
				}
				max = -1;
				for (int j = 0; j < n; j++) {
					if (j != m1 && arr[j] > max) {
						max = arr[j];
						m2 = j;

					}
				}
				arr[m2]--;
				str.append((char) (m2 + 'A'));
				str.append(" ");
				sum -= 2;
				if (sum == 0)
					break;

			}
			System.out.println(str);
			write.println("Case #" + k + ": " + str.toString());

		}
		write.close();
	}

}
