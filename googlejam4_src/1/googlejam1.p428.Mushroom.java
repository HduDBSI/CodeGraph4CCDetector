package googlejam1.p428;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mushroom {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("mushroom.in"));
		PrintWriter out = new PrintWriter(new FileWriter("C:/Users/David/Desktop/mushroom.txt"));
		StringTokenizer t = new StringTokenizer(f.readLine());
		int testCases = Integer.parseInt(t.nextToken());
		for (int i = 1; i <= testCases; i++)
		{
			t = new StringTokenizer(f.readLine());
			int N = Integer.parseInt(t.nextToken());
			int[] M = new int[N];
			t = new StringTokenizer(f.readLine());
			for (int j = 0; j < N; j++)
				M[j] = Integer.parseInt(t.nextToken());
			
			//Method 1
			int method1 = 0;
			for (int j = 1; j < N; j++)
				if (M[j] < M[j-1]) method1 += M[j-1] - M[j];
			
			//method 2
			int delta_X_Per_Ten = 0;
			for (int j = 1; j < N; j++)
				if (M[j] < M[j-1] && M[j-1] - M[j] > delta_X_Per_Ten)
					delta_X_Per_Ten=M[j-1] - M[j];
			
			int method2 = 0;
			for (int j = 0; j < N - 1; j++)
				method2 += Math.min(delta_X_Per_Ten, M[j]);
			
			String ans = "Case #" + i + ": " + method1 + " " + method2;
			out.println(ans);
		}

		out.close(); f.close(); System.exit(0);
	}

}

