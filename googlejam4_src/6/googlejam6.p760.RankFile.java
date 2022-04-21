package googlejam6.p760;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;


public class RankFile {
	 public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 //Scanner in = new Scanner(System.in);
		    int loops = in.nextInt();
		    //String line = in.nextLine();
		    for (int loop = 1; loop <= loops; ++loop) {
		       int n = in.nextInt();
		       //ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
		       TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		       
		       for (int i = 0; i < 2*n - 1; i++) { 
		    	   //lines.add(new ArrayList<Integer>());
		    	   for (int j = 0; j < n; j++) {
		    		   int temp = in.nextInt();
		    		   if (!map.containsKey(temp)) 
		    			   map.put(temp, 0);
		    		   int value = map.get(temp);
		    		   map.put(temp, value+1);
		    		   //lines.get(i).add(temp);
		    	   }
		       }
		       
		       TreeSet<Integer> set = new TreeSet<Integer>();
		       for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
		    	   if (entry.getValue() % 2 == 1)
		    		   set.add(entry.getKey());
		       }
		       
		       //lines.sort(Comparator.comparing(k -> k.get(0)));
		       
		       StringBuilder builder = new StringBuilder();
		       for (int value : set) {
		    	   builder.append(" " + value);
		       }
		     
			       String out = String.format("Case #%1$s:%2$s", loop, builder.toString());
			       System.out.println(out);
		    }
		    in.close();
	 }
}
