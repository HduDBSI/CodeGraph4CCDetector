package googlejam1.p056;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class P1
{
	public static void main( String[] args ) throws Exception
	{
		File inputFile = new File( "inputfiles/round1a/P1/input.txt" );
		FileReader fr = new FileReader( inputFile );
		BufferedReader br = new BufferedReader( fr );
		
		int numOfTestCases = Integer.parseInt( br.readLine() );
		
		File outputFile = new File( "inputfiles/round1a/P1/output.txt" );
		outputFile.delete();
		outputFile.createNewFile();
		FileWriter fw = new FileWriter( outputFile );
		BufferedWriter bw = new BufferedWriter( fw );
		
		for ( int i = 0; i < numOfTestCases; i++ )
		{
			int N = Integer.parseInt( br.readLine() );
			
			int[] m = new int[N];
			
			String[] data = br.readLine().split( " " );
			
			for ( int j = 0; j < N; j++ )
				m[j] = Integer.parseInt( data[j] );
			
			int minEat1 = 0;
			int minEat2 = 0;
			int maxEat = 0;
			for ( int i2 = 1; i2 < N; i2++ )
				if ( m[i2-1] > m[i2] )
				{
					int eat = m[i2-1] - m[i2];
					minEat1 += eat;
					maxEat = Math.max( maxEat, eat );
				}
			
			for ( int i1 = 0; i1 < N-1; i1++ )
				minEat2 += Math.min( maxEat, m[i1] );
			
			bw.append( "Case #"+(i+1)+": " + minEat1 + " " + minEat2 + "\n" );
			bw.flush();
		}
		
		bw.flush();
		fw.flush();
		
		bw.close();
		fw.close();
	}
}
