package googlejam6.p756;
import java.util.*;
import java.io.*;
public class RankFile {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        ArrayList<Integer> ranks = new ArrayList<Integer>();
    	for (int j = 0; j<n*(2*n-1); j++)
    	{
    		Integer rank = new Integer(in.nextInt());
    		if (ranks.contains(rank))
    			ranks.remove(rank);
    		else
    			ranks.add(rank);
    	}
    	Collections.sort(ranks);;
    	String output = "";
    	for (int rank : ranks)
    	{
    		output += rank + " ";
    	}
        System.out.println("Case #" + i + ": " + output.trim());
    }
  }
}