package googlejam3.p182;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("D:/Development/Competitions/GoogleCodeJam/GoogleCodeJam2015/data/Round1C/A-large.in");
		PrintStream out = new PrintStream(new FileOutputStream("D:/Development/Competitions/GoogleCodeJam/GoogleCodeJam2015/data/Round1C/A-large.out"));
		System.setOut(out);
		Scanner sc = new Scanner(file);
		//Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] result = new int[T];
		
		for (int i = 0; i < T; ++i)
		{
			int R = sc.nextInt();
			int C = sc.nextInt();
			int W = sc.nextInt();
			
			int numberOfTotalMisses = (C / W) - 1;
			result[i] = numberOfTotalMisses + W;
			if (C % W != 0)
				result[i]++;
			result[i] += (R - 1) * (C / W);
		}
		sc.close();
		
		for (int i = 0; i < T; ++i)
			System.out.printf("Case #%d: %d\n", i + 1, result[i]);
	}
}


/*
Problem


*/