package googlejam3.p229;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;




public class Battleship {
	
    public static void main( String[] args ) throws Exception {
	    	BufferedReader in = new BufferedReader(new FileReader("in.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
			String line = in.readLine();
			int t = new Integer(line);
			
			
			for (int caseNum=1; caseNum<=t; caseNum++) {
				line = in.readLine();
				String[] sa = line.split(" ");
				int r = new Integer(sa[0]);
				int c = new Integer(sa[1]);
				int w = new Integer(sa[2]);
				
				int answer = ((c/w)+(Math.min(c%w, 1)))+w-1;
				
				if (c/w == 1) answer= Math.min(c, w+1);
				
				if (r>1) answer+=(c/w)*(r-1);

				
				out.write("Case #"+caseNum+": "+answer+"\n");

			}
			
			
			in.close();
			out.flush();
			out.close();

		}



}

