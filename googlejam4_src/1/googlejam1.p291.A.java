package googlejam1.p291;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class A {

    int[] input;

    static Scanner in;
    static PrintStream out;

    public static void main(String[] args) throws FileNotFoundException {
        out = new PrintStream("out.txt");
        in = new Scanner(new File(args[0]));

        int N = in.nextInt();
        in.nextLine();

        for (int i = 0; i < N; i++) {
            int N1 = in.nextInt();
			int[] mushrooms = new int[N1];
			
			for (int i1 = 0; i1 < N1; i1++) {
			    int number = in.nextInt();
			    mushrooms[i1] = number;
			}
			A r = new A(mushrooms);
			int firstSolution = 0;
			int secondSolution = 0;
			int bestRate = 0;
			
			for (int i2 = 1; i2 < r.input.length; i2++) {
			    if (r.input[i2] < r.input[i2 - 1]) {
			        firstSolution += r.input[i2 - 1] - r.input[i2];
			        bestRate = Math.max(r.input[i2 - 1] - r.input[i2], bestRate);
			    }
			}
			
			for (int i1 = 0; i1 < r.input.length - 1; i1++) {
			    secondSolution += Math.min(bestRate, r.input[i1]);
			}
			
			int[] solution = new int[]{firstSolution, secondSolution};
			
			out.printf("Case #%d: %d %d\n", i + 1 , solution[0], solution[1]);
        }
    }

    public A(int[] input) {
        this.input = input;
    }

}