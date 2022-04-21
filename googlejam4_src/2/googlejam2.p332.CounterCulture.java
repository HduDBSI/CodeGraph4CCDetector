package googlejam2.p332;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


public class CounterCulture {

	public static void main(String[] args) throws IOException {
		String inputFile = "src/CounterCulture.in";
		String outputFile = "src/CounterCulture.out";
		BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
		PrintWriter pw = new PrintWriter(new FileWriter(new File(outputFile)));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		int id = 1;
		while ((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			int[] times = new int[n+1];
			times[1] = 1;
			for (int i = 1; i <= n; ++i) {
				if (times[i] == 0) {
					times[i] = times[i-1] + 1;
				}
				else times[i] = Math.min(times[i-1] + 1, times[i]);
				int n1 = i;
				int reverse = 0;
				while( n1 != 0 ) {
				  reverse = reverse * 10;
				  reverse = reverse + n1%10;
				  n1 = n1/10;
				}
				int rev = reverse;
				if (rev > i && rev <= n) {
					times[rev] = times[i] +1;
				}
				
			}
			int num = times[n];
			pw.println("Case #"+id+": "+num);
			id++;
		}
		br.close();
		pw.close();
		// CounterCulture.minTimes(100) ;
	}
}
