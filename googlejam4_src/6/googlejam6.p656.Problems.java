package googlejam6.p656;
import java.io.*;
import java.util.*;

public class Problems {

    public static void main(String[] args) throws IOException {

        Problems r = new Problems();
		Scanner sc = null;
		PrintWriter pw = null;
		try {
			sc = new Scanner(new File("B-large.in"));
			pw = new PrintWriter(new File("output.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int t = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int soldier;
			for (int j = 0; j < n*(2*n-1); j++) {
				soldier = sc.nextInt();
				if(map.containsKey(soldier)) {
					map.put(soldier, map.get(soldier) + 1);
				} else {
					map.put(soldier, 1);
				}
			}
			Set<Integer> answer = new TreeSet<Integer>();
			Iterator it = map.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        if ((int)pair.getValue() % 2 != 0) {
		        	answer.add((int)pair.getKey());
		        }
		        it.remove();
		    }
		    pw.print("Case #" + i + ":");
		    for(int sd : answer) {
		    	pw.print(" " + sd);
		    }
		    pw.println();
		}
		
		pw.close();
    }
}