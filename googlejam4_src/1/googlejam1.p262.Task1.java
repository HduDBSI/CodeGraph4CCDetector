package googlejam1.p262;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("D:/Development/Competitions/GoogleCodeJam/GoogleCodeJam2015/data/A-large.in");
		PrintStream out = new PrintStream(new FileOutputStream("D:/Development/Competitions/GoogleCodeJam/GoogleCodeJam2015/data/A-large.out"));
		System.setOut(out);
		
		Scanner sc = new Scanner(file);
		int T = sc.nextInt();
		int[] result1 = new int[T];
		int[] result2 = new int[T];
		
		for (int i = 0; i < T; ++i)
		{
			int N = sc.nextInt();
			result2[1] = 0;
			result2[i] = 0;
			int eatTempo = 0;
			int[] pieces = new int[N];
			pieces[0] = sc.nextInt();
			for (int j = 1; j < N; ++j)
			{
				pieces[j] = sc.nextInt();
				result1[i] += Math.max(0, pieces[j - 1] - pieces[j]);
				eatTempo = Math.max(eatTempo, pieces[j - 1] - pieces[j]);
			}
			
			for (int j = 0; j < N - 1; ++j)
				result2[i] += Math.min(eatTempo, pieces[j]);
		}
		sc.close();
		
		for (int i = 0; i < T; ++i)
			System.out.println(String.format("Case #%d: %d %d", i + 1, result1[i], result2[i]));
	}
}


/*
Problem


*/