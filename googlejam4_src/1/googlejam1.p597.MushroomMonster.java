package googlejam1.p597;
import java.util.*;
import java.io.*;

public class MushroomMonster {
	
	public static void main(String[] args) throws IOException {
		BufferedReader f= new BufferedReader(new FileReader("mushroom.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mushroom.out")));
		
		int T = Integer.parseInt(f.readLine());
		
		for ( int test=1; test <= T; test++ ) {
			int N = Integer.parseInt(f.readLine());
			StringTokenizer st = new StringTokenizer(f.readLine());
			int[] mushroomPieces = new int[N];
			for ( int i=0; i < N; i++ ) {
				mushroomPieces[i] = Integer.parseInt(st.nextToken());
			}
			// use method one
			int numEaten = 0;
			for ( int i=0; i < N-1; i++ ) {
				int numPieces1 = mushroomPieces[i];
				int numPieces2 = mushroomPieces[i+1];
				if ( numPieces2 < numPieces1 ) {
					numEaten += numPieces1 - numPieces2;
				}
			}
			int numEaten1 = numEaten;
			int largestDiff = 0;
			for ( int i=0; i < N-1; i++ ) {
				int numPieces1 = mushroomPieces[i];
				int numPieces2 = mushroomPieces[i+1];
				largestDiff = Math.max(largestDiff, numPieces1 - numPieces2);
			}
			int numEaten3 = 0;
			for ( int i=0; i < N-1; i++ ) {
				int numPieces = mushroomPieces[i];
				numEaten3 += Math.min(largestDiff, numPieces);
			}
			int numEaten2 = numEaten3;
			out.println(String.format("Case #%d: %d %d",test, numEaten1, numEaten2));
		}
		
		f.close();
		out.close();
	}
}
