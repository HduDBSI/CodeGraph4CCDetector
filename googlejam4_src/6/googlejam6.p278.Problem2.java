package googlejam6.p278;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Problem2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int i = 0;
    int cases = Integer.parseInt(sc.nextLine());

    while (i < cases) {

      String line = sc.nextLine();
      int qtd = Integer.parseInt(line);

      String[] lines = new String[(qtd*2)-1];
      for (int j = 0; j < (qtd*2)-1; j++) lines[j] = sc.nextLine();
	int[] qtds = new int[2500];
	
	for (String line1 : lines) {
	
	  String[] values = line1.split(" ");
	
	  for (String value : values) {
	
	    int val = Integer.parseInt(value);
	    qtds[val-1]++;
	
	  }
	
	}
	
	ArrayList<Integer> results = new ArrayList<>();
	
	for (int i2 = 0; i2 < qtds.length; i2++) {
	
	  if (qtds[i2]%2 != 0) {
	
	    results.add(i2+1);
	
	  }
	
	}
	
	Object[] ints = results.toArray();
	Arrays.sort(ints);
	
	String result1 = "";
	for (int i1 = 0; i1 < results.size(); i1++) {
	
	  if (i1 != 0) result1 = result1 + " ";
	  result1 = result1 + ints[i1];
	
	}

      String result = result1;
      i++;

      System.out.println("Case #" + i + ": " + result);

    }

  }

}
