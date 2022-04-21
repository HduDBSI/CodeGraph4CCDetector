package googlejam1.p684;
import java.io.BufferedReader;
import java.io.FileReader;

public class A {
	public static void main( String[] args ) throws Exception {
		FileReader fr = new FileReader( "a.txt" );
		BufferedReader br = new BufferedReader( fr );

		int cases = Integer.parseInt( br.readLine() );

		for (int c = 1; c <= cases; c++) {
			int n = Integer.parseInt( br.readLine() );
			int[] m = new int[n];
			
			int counter = 0;
			for(String s : br.readLine().split(" ")) {
				m[counter++] = Integer.parseInt(s);
			}
			
			int method1 = 0;
			int maxInterval = 0;
			for(int i = 0; i < m.length - 1; i++) {
				if(m[i] > m[i+1]) {
					int interval = m[i] - m[i+1];
					method1 += interval;
					if(interval > maxInterval) maxInterval = interval;
				}
			}
			
			int method2 = 0;
			for(int i = 0; i < m.length - 1; i++) {
				method2 += Math.min(m[i], maxInterval);
			}

			System.out.printf("Case #%d: %d %d\n", c, method1, method2);
		}

		fr.close();
	}
}
