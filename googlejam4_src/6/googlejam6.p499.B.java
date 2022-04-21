package googlejam6.p499;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

		private static String path = "C:\\Users\\m.omodei\\Downloads\\Round 1A\\";
		private static String file = "large"; //"small-attempt0"; //"Test"; //  
		
		public static void main(String[] args) throws FileNotFoundException {
			
			long start = System.nanoTime();
			Scanner in = new Scanner(new File(path + B.class.getSimpleName() + "-" + file + ".in"));
			PrintWriter out = new PrintWriter(path + B.class.getSimpleName() + "-" + file + ".out");
			int T = in.nextInt();
			for(int i = 1; i <= T; i++) {
				int N = in.nextInt();
				int[] heightCount = new int[2500];
				for(int j = 0; j < 2 * N - 1; j++) {
					for(int k = 0; k < N; k++)
						heightCount[in.nextInt() - 1]++;
				}
				System.out.print("Case #" + i + ":");
				out.print("Case #" + i + ":");
				for(int j = 0; j < 2500; j++) {
					if(heightCount[j] % 2 != 0) {
						System.out.print(" " + (j + 1));
						out.print(" " + (j + 1));
					}
				}
				System.out.println();
				out.println();
		    }
		    in.close();
		    out.close();
		    System.out.println("Elapsed time: " + (System.nanoTime() - start) / 1000000000.0 + " seconds");

		}

	}
