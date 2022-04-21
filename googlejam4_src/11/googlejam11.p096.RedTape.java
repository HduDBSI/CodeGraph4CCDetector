package googlejam11.p096;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class RedTape {
	public static void main(String [] args) throws IOException {
		Scanner input = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter(new File("output.txt"));
		
		int max = input.nextInt();
		for(int c = 1; c <= max; c++) {
			int size = input.nextInt();
			int comm = input.nextInt();
			
			double[] arr = new double[size];
			for(int j = 0; j < size; j++)
				arr[j] = input.nextDouble();
			Arrays.sort(arr);
			double maxV = 0;
			for(int cut = 0; cut <= comm; cut++) {
				double[] a = new double[comm];
				for(int j = 0; j < cut; j++)
					a[j] = arr[j];
				for(int j = 0; j < comm - cut; j++)
					a[j + cut] = arr[size - j - 1];
				
				double[][] prob = new double[201][201];
				int tie = 100;
				prob[0][tie-1] = a[0];
				prob[0][tie+1] = 1 - a[0];
				for(int i = 1; i < comm; i++)
					for(int j = tie - i - 1; j <= tie + i + 1; j++)
						if(j > 0 && j < 200)
							prob[i][j] = prob[i-1][j+1] * a[i] + prob[i-1][j-1] * (1 - a[i]);
				maxV = Math.max(maxV, prob[comm-1][tie]);
			}
			out.printf("Case #%d: %.10f%n", c, maxV);
		}
		out.close();
	}
}
