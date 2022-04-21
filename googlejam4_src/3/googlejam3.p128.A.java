package googlejam3.p128;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		File fin = new File("src/Round1C/A-large.in");
		Scanner scan;
		try {
			scan = new Scanner(fin);
		
			PrintWriter output = new PrintWriter("src/Round1C/A_test.out2.txt");
			int T = scan.nextInt();
			for(int i = 0; i < T; i++)
			{
				int R = scan.nextInt();
				int CC = scan.nextInt();
				int W = scan.nextInt();
				int C = CC;
				System.out.println(R + " " + C + " " + W);
				int result = 0;
				result += C / W * (R - 1);
				System.out.println(C + " > " + (2 * W + 1));
				while (C > 2 * W) {
					C -= W;
					result++;
				}
				System.out.println((W+1) + " " + result);

				if (C == W)
					result += W;
				else
					result += W + 1;
				System.out.println((W+1) + " " + result);

				output.println("Case #" + (i + 1) + ": " + result);
				System.out.println("Case #" + (i + 1) + ": " + R + " " + CC + " " + W + "\t result :" + result);
			}
			scan.close();
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
