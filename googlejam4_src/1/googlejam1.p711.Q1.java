package googlejam1.p711;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Q1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File f = new File("A-large.in");
		PrintWriter out = new PrintWriter("out.txt");
		Scanner s = new Scanner(f);
		int T = s.nextInt();
//		s.nextLine();
		int iter = 0;
		while(T > 0) {
			T--;
			iter++;
			int N = s.nextInt();
			int N_i = N;
			int[] in = new int[N];
			int i = 0;
			while(N_i > 0) {
				N_i--;
				in[i++] = s.nextInt();
			}
			int m1 = 0;
			for(int j = 1; j < N; j++) {
				if(in[j] < in[j-1]) {
					System.out.println(m1);
					m1 += in[j-1] - in[j];
				}
			}
			int max = 0;
			int diff = 0;
			for(int j = 0; j < N-1; j++) {
				diff = in[j] - in[j+1];
				if(diff > max) {
					max = diff;
				}
			}
			int m2 = 0;
			for(int j = 0; j < N-1; j++) {
				if(in[j] <= max) {
					m2 += in[j];
				} else {
					m2 += max;
				}
			}
			out.println("Case #" + iter + ": " + m1 + " " + m2);

		}
		s.close();
		out.close();

	}

}
