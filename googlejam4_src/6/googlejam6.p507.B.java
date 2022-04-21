package googlejam6.p507;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class B {
	public static void main(String[] args) throws IOException {
		if (args == null || args.length == 0) {
			System.err.println("dude, I need to know the input file name");
			System.exit(-1);
		}

		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		try {
		    String input = br.readLine();
		    
		    // first line is # of cases.
		    int numCases = Integer.parseInt(input);
		    input = br.readLine();
		    for (int i = 1; i <= numCases; i++) {
		    	int n = Integer.parseInt(input); //n
		    	List<String> lists = new ArrayList<String>(2*n-1);
		    	for (int j = 1; j < 2*n; j++) {
		    		lists.add(br.readLine());
		    	}
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int i2= 0; i2< lists.size(); i2++) {
					@SuppressWarnings("resource")
					Scanner ss = new Scanner(lists.get(i2));
					for (int j = 0; j < n; j++) {
						int found = ss.nextInt();
						if (map.containsKey(found)) {
							int val = map.get(found)+1;
							map.put(found, val);
						} else {
							map.put(found, 1);
						}
					}
				}
				List<Integer> out = new ArrayList<Integer>(n);
				for (Integer in : map.keySet()) {
					if ((map.get(in).intValue()&1) != 0) out.add(in);
				}
				Collections.sort(out);
				List<Integer> missing = out;
		    	StringBuilder output = new StringBuilder("Case #");
				output.append(i).append(":");
				for (int i1 =0; i1 < missing.size(); i1++) {
					output.append(" ").append(missing.get(i1));
				}
				
				System.out.println(output.toString());
		        input = br.readLine();
		    }
		} finally {
		    br.close();
		}
	}
}
