package googlejam1.p431;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;



public class Mushroom {
	
    public static void main( String[] args ) throws Exception {
	    	BufferedReader in = new BufferedReader(new FileReader("in.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
			String line = in.readLine();
			int t = new Integer(line);
			
			
			for (int caseNum=1; caseNum<=t; caseNum++) {
				line = in.readLine();
				int n = new Integer(line);
				line = in.readLine();
				String[] sa = line.split(" ");
				int[] m = new int[n];
				int rate =0;
				int totalDecrease=0;
				m[0] = new Integer(sa[0]);
				
				for (int j=1; j<n; j++) {
					m[j] = new Integer(sa[j]);
					if ((m[j-1]-m[j])>rate) rate=m[j-1]-m[j];
					if ((m[j-1]>m[j])) totalDecrease+=m[j-1]-m[j];
				}
				
				int total2=0;
				for (int j=0; j<n-1; j++) {
					if (m[j]>rate) total2+=rate;
					else total2+=m[j];
				}
				
				out.write("Case #"+caseNum+": "+totalDecrease+" "+total2+"\n");


			}
			
			
			in.close();
			out.flush();
			out.close();

		}


}
