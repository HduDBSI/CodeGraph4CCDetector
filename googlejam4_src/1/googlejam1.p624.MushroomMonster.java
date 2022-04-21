package googlejam1.p624;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class MushroomMonster {

	public static void main(String[] args)throws IOException {
		Scanner in = new Scanner(new File("in.in"));
		PrintWriter writer = new PrintWriter(new File("out.out"));
		int t = in.nextInt();
		for (int i = 1; i <=t;i++) {
			int n = in.nextInt();
			int[] m = new int[n];
			int first = 0;
			int second = 0;
			for (int j = 0; j < n; j++)
				m[j] = in.nextInt();
			first = 0;
			int left;
			for (int j = 1; j < n; j++) {
				if (m[j] > m[j-1]) continue;
				first += Math.abs(m[j] - m[j-1]);
			}
			second = 0;
			left = m[0];
			double rate = 0;
			for (int j = 1; j < n ;j++)
				if (m[j] < m[j-1])
				rate = Math.max(rate, (double)(m[j-1] - m[j]) / 10);
			for (int j = 1; j < n ;j++ ) {
				second += Math.min(rate * 10 , left);
				left -= Math.min(rate*10, left);
				left += m[j] - left;
			}
			writer.println("Case #"+i+": "+first + " "+second);
		}
		
		in.close();
		writer.close();
	}

}
