package googlejam6.p565;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class RankAndFile {
	public static void main(String args[] ) throws Exception {
//		File output_file = new File("RankAndFile_test.txt");
//		File output_file = new File("RankAndFile_small.txt");
		File output_file = new File("RankAndFile_large.txt");
		FileWriter filewriter = new FileWriter(output_file);
		BufferedWriter bw = new BufferedWriter(filewriter);
		PrintWriter pw = new PrintWriter(bw);

//		File input_file = new File("B-test.txt");
//		File input_file = new File("B-small-attempt0.in.txt");
		File input_file = new File("B-large.in.txt");
		Scanner sc = new Scanner(input_file);
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int checkNumber[] = new int[2501];
			int input_number = N*(2*N-1);
					
			for (int j = 0; j < input_number; j++) {
				int target = sc.nextInt();
				checkNumber[target] += 1;
			}
			
			StringBuilder answer = new StringBuilder();
			for (int k = 1; k <= 2500; k++) {
				if (checkNumber[k] % 2 == 1) {
					String new_answer = " " + String.valueOf(k); 
					answer.append(new_answer);
				}
			}
			
			pw.println("Case #" + String.valueOf(i) + ":" + answer);
		}
		pw.close();
    }
}
