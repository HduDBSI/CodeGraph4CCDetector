package googlejam1.p628;
import java.util.*;
import java.io.*;

public class R1Q1 {
	private static Reader in;
	private static PrintWriter out;
	public static final String NAME = "R1\\A\\A-large";
	
	private static Map<String, String> m = new HashMap<String, String>();

	public static void main(String[] args) throws IOException {	
		
		out = new PrintWriter(new BufferedWriter(new FileWriter(NAME + ".out")));
		File file = new File(NAME+".in");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    int T = Integer.parseInt(br.readLine());
		    for(int i=0; i<T; i++){
		    	int N = Integer.parseInt(br.readLine());
		    	int result1 = 0;
		    	int result2 = 0;
		    	String[] list = br.readLine().split(" ");
		    	int last = Integer.parseInt(list[N-1]);
		    	
		    	int result2_max = 0;
		    	for(int j=N-2; j>=0; j--){
		    		int first = Integer.parseInt(list[j]);
		    		if(last < first){
		    			result1 += first-last;
		    			if(result2_max < first-last){
		    				result2_max = first-last;
		    			}
		    		}
		    		last = first;
		    	}
		    	
		    	System.out.println(result2_max);
		    	
		    	for(int j=N-2; j>=0; j--){
		    		int thisD = Integer.parseInt(list[j]);
		    		if(thisD < result2_max){
		    			result2 += thisD;
		    		}else{
		    			result2 += result2_max;
		    		}
		    	}
		    	
		    	out.println("Case #" + (i+1) + ": " + result1 + " " + result2);
		    }
		    
		}
		
		out.close();
	    System.exit(0);
		
	}
	
}