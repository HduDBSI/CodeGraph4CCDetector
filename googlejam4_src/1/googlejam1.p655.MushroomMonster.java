package googlejam1.p655;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class MushroomMonster {
	public static void main(String[] args) throws IOException {
		String inputFile = "src/MushroomMonster.in";
		String outputFile = "src/MushroomMonster.out";
		BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
		PrintWriter pw = new PrintWriter(new FileWriter(new File(outputFile)));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		int id = 1;
		for (int i = 0; i < N; ++i) {
			int D = Integer.parseInt(br.readLine());
			String[] lineSplit = br.readLine().split(" ");
			int[] arr = new int[D];
			for (int j = 0; j < D; ++j) {
				arr[j] = (Integer.parseInt(lineSplit[j]));
			}
			int sum = 0;
			for (int i1 = 1; i1 < arr.length; i1++) 
				if (arr[i1] < arr[i1-1]) sum += (arr[i1-1] - arr[i1]);
			int sum1 = sum;
			int diff = 0;
			for (int i1 = 1; i1 < arr.length; ++i1)
				if (arr[i1-1] - arr[i1] > diff) diff = (arr[i1-1] - arr[i1]);
			System.out.println(diff);
			int sum3 = 0;
			for (int i2 = 1; i2 < arr.length; ++i2) {
				int eat = (arr[i2-1] < diff? arr[i2-1] : diff);
				sum3 += eat;
			}
			int sum2 = sum3;
			pw.println("Case #"+id+": "+sum1 + " " + sum2);
			id++;
		}
		br.close();
		pw.close();
	}
	
}
