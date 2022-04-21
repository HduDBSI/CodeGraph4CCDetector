package googlejam6.p525;
import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        for (int thisNum = 1; thisNum <= numCases; thisNum++) {
            int numRows = in.nextInt();
            Integer[][] allRows = new Integer[numRows * 2 - 1][numRows];
            for ( int i = 0; i < numRows * 2 - 1; i++ )
            {
                Integer[] nextRow = new Integer[ numRows ];
                for ( int row = 0; row < numRows; row++ )
                    nextRow[ row ] = in.nextInt();
                allRows[ i ] = nextRow;
            }
            for ( int row = 0; row < numRows; row++ ) {
                for (int col = 0; col < numRows; col++) {
                    for ( int j = 0; j < numRows * 2 - 1; j++ ) {
                        Integer[] testRow = allRows[ j ];
                        for ( int k = 0; k < numRows * 2 - 1; k++ ) {
                            if ( k != j && allRows[ k ][row].equals( allRows[ j ][col] ) ) {
                                allRows[k][row] = -1;
                                allRows[j][col] = -1;
                            }
                        }
                    }
                }
            }

            Vector<Integer> result = new Vector<Integer>(numRows);

            for ( int j = 0; j < numRows * 2 - 1; j++ ) {
                for (int col = 0; col < numRows; col++) {
                    if ( allRows[ j ][col] != -1 )
                        result.add( allRows[ j ][ col ]);
                }
            }

            Integer[] resultArray = (Integer[]) result.toArray(new Integer[ numRows]);
            Arrays.sort( resultArray );

            String output = "";
            for (int col = 0; col < numRows; col++) {
                output += resultArray[ col ] + " ";
            }

            output = output.trim();

            // Print results
            System.out.format("Case #%d: %s\n", thisNum, output);
        }
    }

}
