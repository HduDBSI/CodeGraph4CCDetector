package googlejam1.p195;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Codejam {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		Scanner in = null;
		try {
			in = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e1) {
		}
		try {
			System.setOut(new PrintStream(new File("output.txt")));
		} catch (FileNotFoundException e) {
		}
		
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = in.nextInt();
			int ar[] = new int[n];
			int ma = 0;
			int f = 0;
			for (int i = 0; i < n; i++) {
				ar[i] = in.nextInt();
				if (i > 0) {
					ma = Math.max(ma, ar[i - 1] - ar[i]);
					if (ar[i] < ar[i-1]){
						f += ar[i - 1] - ar[i];
					}
				}
			}
			
			int s = 0;
			for (int i = 1; i < n; i++) {
				if (ar[i - 1] >= ma) {
					s += ma;
				} else {
					s += ar[i - 1];
				}
			}
			System.out.println("Case #" + t + ": " + f + " " + s);
		}
	}
}
