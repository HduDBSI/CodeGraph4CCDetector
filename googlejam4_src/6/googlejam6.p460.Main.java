package googlejam6.p460;
import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCaseNum = in.nextInt();

    for (int i = 1; i <= testCaseNum; i++) {
      int n = in.nextInt();
      TreeMap<Integer, Integer> note = new TreeMap<Integer, Integer>();
      for(int j = 0; j < 2 * n - 1; j++) {
        for (int x = 0; x < n; x++) {
          int soldier = in.nextInt();
          if (note.containsKey(soldier)) {
            note.put(soldier, note.get(soldier) + 1);
          } else {
            note.put(soldier, 1);
          }
        }
      }

      StringBuffer ret = new StringBuffer("Case #");
	ret.append(i);
	ret.append(": ");
	
	ArrayList<Integer> missing = new ArrayList<Integer>();
	for(Map.Entry<Integer, Integer> entry : note.entrySet()) {
	  if (entry.getValue() % 2 == 1) {
	    missing.add(entry.getKey());
	  }
	}
	
	Collections.sort(missing);
	
	System.out.print(ret);
	for (int i1 = 0; i1 < missing.size(); i1++) {
	  System.out.print(missing.get(i1));
	  if(i1 != missing.size() -1) System.out.print(" ");
	}
	System.out.println("");
    }
  }
}
