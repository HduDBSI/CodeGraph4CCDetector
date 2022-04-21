package googlejam6.p077;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("B.in")));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("B.out"))));

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int[] count = new int[2500+1];
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N*2-1; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					count[Integer.parseInt(str[j])]++;
				}
			}
			pw.print("Case #"+(t+1)+":");
			for (int i = 1; i < count.length; i++) {
				if (count[i] % 2 > 0) pw.print(" "+i);
			}
			pw.println();
			pw.flush();
		}
		
		pw.close();
		br.close();
	}
}
