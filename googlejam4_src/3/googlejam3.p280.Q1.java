package googlejam3.p280;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Q1 {

	public static void main(String[] args) throws Exception {
		String directory = "D:\\Work\\eclipse\\workspace\\CodeJam2015\\src\\round1c\\q1\\";
		String fileName = "A-large";
		//String fileName = "testA";
		File file = new File(directory + fileName + ".in");
		File outFile = new File(directory + fileName + ".out");
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
		int testCases = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCases; t++) {
			/*
			 * Your code here
			 */
			String input1 = br.readLine();
			String[] arr1 = input1.split(" ");
			
			R = Integer.parseInt(arr1[0]);
			C = Integer.parseInt(arr1[1]);
			W = Integer.parseInt(arr1[2]);
			
			int fmove = C / W;
			int smove = W;
			if (C % W == 0) {
				smove--;
			}
			
			int bmove = (C / W) * (R - 1);
			int total = bmove + fmove + smove;
			String answer = total + "";

			String response = "Case #" + t + ": " + answer + "\n";
			bw.write(response);

			//System.out.println(input1 + "//");
			//System.out.println(response);
		}
		br.close();
		bw.close();
	}

	static int R;
	static int C;
	static int W;
}
