package googlejam6.p238;

//count_sheep
import java.util.*;
import java.io.*;
public class rank_and_file {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int num = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    
    for (int i = 1 ; i<= num; i++){
    	int N = in.nextInt();
    	HashSet<Integer> set = new HashSet<Integer>();
    	for (int j=0; j<2*N-1; j++){
    		for (int k = 0; k < N; k ++){
    			int cur = in.nextInt();
    			if (set.contains(cur)){
    				set.remove(cur);
    			}
    			else {
    				set.add(cur);
    			}
    		}
    	}
    	int[] rst = new int[set.size()];
    	int index = 0;
    	for (int j : set){
    		rst[index] = j;
    		index++;
    	}
    	Arrays.sort(rst);
    	StringBuilder sb = new StringBuilder();
    	for (int j = 0; j < rst.length; j++){
    		sb.append(rst[j] + " ");
    	}
		System.out.println("Case #" + i + ": " + sb.toString().trim());	
    	
    }
    
  }
}