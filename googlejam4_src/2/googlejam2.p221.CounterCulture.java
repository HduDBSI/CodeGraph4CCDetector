package googlejam2.p221;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class CounterCulture {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		CounterCulture instance = new CounterCulture();
		BufferedReader br = new BufferedReader(new FileReader("in.txt"));
		PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
		
		
		int MAX = 1000001;
		
		int[] res = new int[MAX];
		
		res[1] = 1;
		
		for(int i=2;i<MAX;++i) {
			int r = Integer.parseInt(new StringBuffer(new Integer(i).toString()).reverse().toString());
			int r_r = Integer.parseInt(new StringBuffer(new Integer(r).toString()).reverse().toString());
			if(r<i && i == r_r) {
				res[i] = Math.min(res[i-1], res[r])+1;
			}
			else
				res[i] = res[i-1]+1;
		}
		
		
		
		try {
		    String line = br.readLine();
		    
		    int t = Integer.parseInt(line);
		    
		    for(int i=1;i<=t;++i) {
		    	int n = Integer.parseInt(br.readLine());
		    	
		    	writer.print("Case #" + new Integer(i).toString() + ": " + res[n]);
		    	
		    	if(i<t)
		    		writer.println();
		    }
		} finally {
		    br.close();
		    writer.close();
		}
	}

}
