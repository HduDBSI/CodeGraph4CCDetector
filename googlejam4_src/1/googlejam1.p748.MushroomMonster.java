package googlejam1.p748;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
4
4
10 5 15 5
2
100 100
8
81 81 81 81 81 81 81 0
6
23 90 40 0 100 9
 */
public class MushroomMonster {
//	static private final String INPUT = "./input.txt";
//	static private final String OUTPUT = "./output.txt";
	static private final String INPUT = "./A-large.in";
	static private final String OUTPUT = "./A-large.out";
	
	public static void main(String args[]) {
		// open I/O files
		FileInputStream instream = null;
		PrintStream outstream = null;

		try {
			instream = new FileInputStream(INPUT);
			outstream = new PrintStream(new FileOutputStream(OUTPUT));
			System.setIn(instream);
			System.setOut(outstream);
		} catch (Exception e) {
			System.err.println("Error Occurred.");
			e.printStackTrace();
			return;
		}

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for (int t = 1; t <= T; ++t) {
			int N = in.nextInt();
			int arr [] = new int[N];
			List<Integer> arr_dif = new ArrayList<Integer>();
			int m1,m2;
			int max;
			int sum1 = 0, sum2 = 0;
			
			arr[0] = in.nextInt();
			for (int i = 1; i < N; i++) {
				arr[i] = in.nextInt();
				arr_dif.add(arr[i-1] - arr[i]);
			}
			
			max = Collections.max(arr_dif);
			
			for (int i = 0; i < N-1; i++) {
				m1 = arr[i];
				m2 = arr[i+1];
				
				if(m1 > m2)
					sum1 += m1-m2;
				
				if(m1 <= max)
					sum2 += m1;
				else
					sum2 += max;
			}
			System.out.println("Case #" + t + ": " + sum1 + " " + sum2);
		}

		in.close();
		return;
	}
}
