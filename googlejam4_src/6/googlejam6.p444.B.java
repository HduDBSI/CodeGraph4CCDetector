package googlejam6.p444;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );

		Integer t = input.nextInt();

		for( int testCase = 0; testCase < t; testCase++ ) {
			int n = input.nextInt();

			int[] heights = new int[2500];
			Arrays.fill( heights, 0 );

			for( int i = 0; i < n * 2 - 1; i++ ) {
				for( int j = 0; j < n; j++ ) {
					int h = input.nextInt();
	
					heights[h - 1]++;
				}
			}

			List<Integer> missingRow = new ArrayList<Integer>(n);
			for( int i = 0; i < heights.length; i++ ) {
				if( heights[i] % 2 != 0 ) {
					missingRow.add( i );
				}
			}

			Collections.sort( missingRow );

			System.out.print( "Case #" + ( testCase + 1 ) + ":" );
			for( Integer i : missingRow ) {
				System.out.print( " " + ( i + 1 ) );
			}
			System.out.println();
		}

		input.close();
	}

}
