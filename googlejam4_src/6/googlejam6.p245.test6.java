package googlejam6.p245;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class test6 {
	
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    Long t = in.nextLong();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int line = in.nextInt();
	      System.out.print("Case #" + i + ":");
	      int[] result = new int[line];
	      HashSet<Integer> hs = new HashSet<Integer>();
	      for (int j = 1; j <= line * 2 - 1; j++) {
	    	  for (int k = 1; k <= line; k++) {
	    		  int number = in.nextInt();
	    		  if (hs.contains(number)) {
	    			  hs.remove(number);
	    		  } else {
	    			  hs.add(number);
	    		  }
	    	  }
	      }
	      int j = 0;
	      for (Integer ele : hs) {
	    	  result[j] = ele;
	    	  j++;
	      }
	      Arrays.sort(result);
	      for (Integer ele : result) {
	    	  System.out.print(" " + ele);
	      }
	      System.out.println();
	    }
	}
}
