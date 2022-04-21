package googlejam1.p335;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class prob1 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("input"));
		PrintWriter out = new PrintWriter(new FileWriter("output"));
		
		int cases = in.nextInt();
		for (int a=0; a<cases; a++) {
			int number = in.nextInt();
			int mushrooms[] = new int[number];
			int num1 = 0;
			int maxRate = 0;

			for (int b=0; b<number; b++) {
				mushrooms[b] = in.nextInt();
				if (b > 0) {
					if (mushrooms[b] < mushrooms[b-1]) {
						num1 = num1 + (mushrooms[b-1] - mushrooms[b]);
					}
					
					if ((mushrooms[b-1] - mushrooms[b]) > maxRate) {
						maxRate = (mushrooms[b-1] - mushrooms[b]);
					}
				}
			}
			
			int num2 = 0;
			for (int b=0; b<number-1; b++) {
				if (mushrooms[b] > maxRate) {
					num2 = num2 + maxRate;
				} else {
					num2 = num2 + mushrooms[b];
				}
			}
			
			//System.out.println(num2);
			out.print("Case #" + (a+1) + ": " + num1 + " " + num2 + "\n");
			
		}
		
		// template output:
		// out.print("Case #" + (a+1) + ": " + time + "\n");
		
		out.close();
	}
}