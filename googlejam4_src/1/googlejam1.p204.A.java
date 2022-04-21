package googlejam1.p204;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class A {
	static final Boolean SAMPLE = false;
	static final String PROBLEM = "A";
	static final String INPUT = "large";
	static final String ID = "0";
	static final String PATH = "/Users/wangkai/Documents/codejam-commandline-1.2-beta1/source/";

	public static void main(String[] args) throws Throwable {
		Scanner in = SAMPLE ? new Scanner(System.in) : new Scanner(new File(
				PATH + PROBLEM + "-" + INPUT + "-" + ID + ".in"));
		PrintStream out = SAMPLE ? System.out : new PrintStream(PATH + PROBLEM
				+ "-" + INPUT + "-" + ID + ".out");

		int test = in.nextInt();
		for (int t = 1; t <= test; t++) {
			out.print("Case #" + t + ": ");

			int N = in.nextInt();
			int[] mushrooms = new int[N];
			for (int i = 0; i < mushrooms.length; i++) {
				mushrooms[i] = in.nextInt();
			}

			int minEat1 = 0;
			for (int i = 0; i < mushrooms.length - 1; i++) {
				minEat1 += Math.max(0, mushrooms[i] - mushrooms[i + 1]);
			}

			int maxSingleEat = 0;
			for (int i = 0; i < mushrooms.length - 1; i++) {
				maxSingleEat = Math.max(maxSingleEat,
						Math.max(0, mushrooms[i] - mushrooms[i + 1]));
			}

			int minEat2 = 0;
			for (int i = 1; i < mushrooms.length; i++) {
				minEat2 += Math.min(maxSingleEat, mushrooms[i - 1]);
			}

			out.println(minEat1 + " " + minEat2);
		}

		out.close();
		in.close();

		System.out.println("finish!");
	}
}
