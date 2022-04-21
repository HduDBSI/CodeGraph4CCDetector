package googlejam4.p076;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P1
{
	public static void main( String[] args ) throws Exception
	{
		File inputFile = new File( "inputfiles/round2/P1/input.txt" );
		FileReader fr = new FileReader( inputFile );
		BufferedReader br = new BufferedReader( fr );
		
		int numOfTestCases = Integer.parseInt( br.readLine() );
		
		File outputFile = new File( "inputfiles/round2/P1/output.txt" );
		outputFile.delete();
		outputFile.createNewFile();
		FileWriter fw = new FileWriter( outputFile );
		BufferedWriter bw = new BufferedWriter( fw );
		
		for ( int i = 0; i < numOfTestCases; i++ )
		{
			String[] rc = br.readLine().split( " " );
			int R = Integer.parseInt( rc[0] );
			int C = Integer.parseInt( rc[1] );
			
			char[][] grid = new char[R][C];
			
			for ( int j = 0; j < R; j++ )
			{
				String row = br.readLine();
				for ( int k = 0; k < row.length(); k++ )
					grid[j][k] = row.charAt( k );
			}
			
			int changeNum = 0;
			boolean possible = true;
			
			main: for ( int i1 = 0; i1 < R; i1++ )
				for ( int j = 0; j < C; j++ )
				{
					char field = grid[i1][j];
					if ( field == '.' )
						continue;
					
					boolean isArrowUp = false;
					for ( int k = 0; k < i1; k++ )
						if ( grid[k][j] != '.' )
						{
							isArrowUp = true;
							break;
						}
					
					boolean isArrowDown = false;
					for ( int k = i1+1; k < R; k++ )
						if ( grid[k][j] != '.' )
						{
							isArrowDown = true;
							break;
						}
					
					boolean isArrowLeft = false;
					for ( int k = 0; k < j; k++ )
						if ( grid[i1][k] != '.' )
						{
							isArrowLeft = true;
							break;
						}
					
					boolean isArrowRight = false;
					for ( int k = j+1; k < C; k++ )
						if ( grid[i1][k] != '.' )
						{
							isArrowRight = true;
							break;
						}
					
					if ( !isArrowUp && !isArrowDown && !isArrowLeft && !isArrowRight )
					{
						possible = false;
						break main;
					}
					
					if ( field == '^' && !isArrowUp )
						changeNum++;
					
					if ( field == 'v' && !isArrowDown )
						changeNum++;
					
					if ( field == '>' && !isArrowRight )
						changeNum++;
					
					if ( field == '<' && !isArrowLeft )
						changeNum++;
				}
			
			String s = "Case #" + (i+1) + ": " + ( possible ? changeNum : "IMPOSSIBLE" ) + "\n";
			bw.append( s );
			bw.flush();
		}
		
		bw.flush();
		fw.flush();
		
		bw.close();
		fw.close();
	}
}
