package googlejam6.p212;


import java.util.*;
import java.io.*;

public class QB {
	private static Reader in;
	private static PrintWriter out;
	public static final String NAME = ".\\codeJamRound1\\B-large";

	public static void main(String[] args) throws IOException {	
		
		out = new PrintWriter(new BufferedWriter(new FileWriter(NAME + ".out")));
		File file = new File(NAME+".in");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    int T = Integer.parseInt(br.readLine());
		    String line;
		    for(int i=0; i<T; i++){
		    	int N = Integer.parseInt(br.readLine());
		    	Map<Integer, Integer> map = new HashMap<>();
		    	
		    	for(int k=0; k<2*N-1; k++){
		    		line = br.readLine();		    	
			    	String[] numStr = line.split(" ");

			    	for(int j=0; j<numStr.length; j++){
			    		int key = Integer.parseInt(numStr[j]);
			    		//System.out.println(key);
			    		//System.out.println(map);
			    		if(map.containsKey(key)){
			    			map.remove(key);
			    		}else{
			    			map.put(key, 1);
			    		}
			    	}
		    	}

		    	//System.out.println(map);
		    	
	    		List<Integer> singleNum = new ArrayList<>(map.keySet());
	    		Collections.sort(singleNum);
	    		StringBuilder result = new StringBuilder();
	    		for(int e: singleNum){
	    			result.append(" " + e);
	    		}
	    		
	    		out.println("Case #" + (i+1) + ":" + result.toString());
		    }
		    
		}
		
		out.close();
	    System.exit(0);
		
	}
}

