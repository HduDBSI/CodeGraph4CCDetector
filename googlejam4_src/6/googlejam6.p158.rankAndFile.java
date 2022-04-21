package googlejam6.p158;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;

public class rankAndFile {
	
	public static void main(String[] args) throws IOException {
	FileInputStream in = null;
	PrintWriter out = null;

      try {
         in = new FileInputStream("B-large.in");
         out = new PrintWriter( "outputB-large.txt" );

         Scanner sc = new Scanner (in);
         String line = sc.nextLine();

         int T = Integer.parseInt(line);

         for(int i=1; i<=T; i++) {
        	 int N = Integer.parseInt(sc.nextLine());
        	 
        	 HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        	 
        	 for (int x=0; x < 2*N-1; x++) {
        		 line = sc.nextLine();
        		 for (int y=0; y < N; y++) {
        			 int key = Integer.parseInt(line.split(" ")[y]);
        			 if(m.containsKey(key)) {
        				 int val = m.get(key);
        				 m.put(key, ++val);
        			 } else {
        				 m.put(key, 1);
        			 }
        		 }
        	 }
        	 
        	 Vector<Integer> vector = new Vector<>();
        	 Iterator it = m.entrySet().iterator();
        	 while (it.hasNext()) {
        		Map.Entry pair = (Entry) it.next();
        		int key = (int) pair.getKey();
        		int val = (int) pair.getValue();
        		
        		if( val%2 == 1 ) {
        			vector.add(key);
        		}
        	 }
        	     	    
             Collections.sort(vector);
        	 
             String output = "Case #" + i + ":";
        	 for(int j=0; j<vector.size(); j++) {
        		 output = output + " " + vector.elementAt(j);
        	 }
        	 
        	 out.println( output );
         }
      } finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
	}
}
