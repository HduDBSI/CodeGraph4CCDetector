package googlejam1.p578;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Mushroom {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//Input output files
		String inPath = args[0];
		String outPath = args[1];

		File inFile = new File(inPath);
		BufferedReader br = new BufferedReader(new FileReader(inFile));

		File outFile = new File(outPath);
		FileWriter fw = new FileWriter(outPath);
		BufferedWriter bw = new BufferedWriter(fw);

		StringTokenizer st = null;

		//Variables 
		int caseNumber = Integer.parseInt(br.readLine());

		//For each case
		for (int i = 0; i < caseNumber; i ++) {

			int numberOfInput = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int minX = 0;
			int minY = 0;
			int maxSpeed = 0;
			int[] input = new int[numberOfInput];

			//Read Itemes
			for (int n = 0; n < numberOfInput; n ++) {
				input[n] = Integer.parseInt(st.nextToken());
			}

			for (int m = 0; m < numberOfInput - 1; m ++) {
					int diff = input[m] - input[m+1];
					if (diff > 0)
						minX += diff;
					if (diff > maxSpeed)
						maxSpeed = diff;
			}

			for (int p = 0; p < numberOfInput - 1; p ++) {
				if (input[p] < maxSpeed)
					minY += input[p];
				else
					minY += maxSpeed;
			}


			//Write the result in the output file
			bw.write("Case #" + (i + 1) + ": " + minX + " " + minY);
			bw.newLine();
		}

		bw.close();
	}
}