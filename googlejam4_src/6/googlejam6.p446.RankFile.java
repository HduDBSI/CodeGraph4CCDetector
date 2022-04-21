package googlejam6.p446;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class RankFile {

	public RankFile () {
	}

	public static void main(String [] argv) {
		RankFile t = new RankFile();
		try {
			//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("B-small-attempt0.in")));
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("B-large.in")));
			//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.in")));
			String line = br.readLine();
			int numCases = Integer.parseInt(line);
			int N = 0;
			for(int i=0; i<numCases; i++) {
				N = Integer.parseInt(br.readLine());
				int [] n = new int [2501];
				for(int j=0; j<2*N-1; j++) {
					line = br.readLine();
					String [] tokens = line.split(" "); 
					for(int k=0;k<N;k++)
						n[ Integer.parseInt(tokens[k]) ] ++;
				}
				StringBuffer sb = new StringBuffer();
				for(int k=0; k<2501; k++) {
					if(n[k] % 2 == 1)
						sb.append(Integer.toString(k) + " ");
				}
				System.out.println("Case #" + (i+1) + ": " +sb.toString().trim() );
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
