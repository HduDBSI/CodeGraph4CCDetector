package googlejam1.p510;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R1A2015A {
	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			
			int testCaseNum = Integer.parseInt(in.readLine());
			
			for(int i=1; i<=testCaseNum; i++) {
				int n = Integer.parseInt(in.readLine());
				String[] m_str = in.readLine().split(" ");
				int[] m = new int[n];
				for(int j=0; j<n; j++) {
					m[j] = Integer.parseInt(m_str[j]);
				}
				int sumconsumption = 0;
				int maxconsumption = 0;
				for(int j=1; j<n; j++) {
					int consumption = Math.max(m[j-1] - m[j], 0);
					sumconsumption += consumption;
					maxconsumption = Math.max(maxconsumption, consumption);
				}
				long z = 0;
				for(int j=0; j<n-1; j++) {
					z += Math.min(maxconsumption, m[j]);
				}
				
				System.out.print("Case #" + i + ": ");
				System.out.print(sumconsumption);
				System.out.print(" ");
				System.out.print(z);
				System.out.println();
			}
		}
		catch(IOException ioe) {
			throw ioe;
		}
		finally {
			if(in != null) {
				in.close();
			}
		}
	}
	
}
