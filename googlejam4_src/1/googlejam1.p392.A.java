package googlejam1.p392;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class A {
	public static void main(String [] args) throws IOException {
		Scanner input = new Scanner(new File("A-large.in"));
		PrintWriter write = new PrintWriter("A-large.out");
		int cases = input.nextInt();
		for(int i = 1; i <= cases; i++) {
			int steps = input.nextInt();
			int[] values = new int[steps];
			for(int j = 0; j < values.length; j++)
				values[j] = input.nextInt();
			int maxDist = 0;
			int decrTotal = 0;
			for(int j = 1; j < values.length; j++) {
				int increase = values[j] - values[j-1];
				if(increase < 0) {
					if(maxDist < -increase)
						maxDist = -increase;
					decrTotal -= increase;
				}
			}
			int secCount = 0;
			for(int j = 0; j < values.length-1; j++) {
				secCount += Math.min(values[j], maxDist);
			}
			write.printf("Case #%d: %d %d%n", i, decrTotal, secCount);
		}
		write.close();
	}
}
