package googlejam8.p170;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Evacuation {
	public static void main(String[] args) {
		//Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	 Scanner in = new Scanner(System.in);
	    int loops = in.nextInt();
	 	
	    for (int loop = 1; loop <= loops; ++loop) {
	    	int n = in.nextInt();
	    	int[] parties = new int[n];
	    	int sum = 0;
	    	for(int i = 0; i < n; i++) {
	    		parties[i] = in.nextInt();
	    		sum += parties[i];
	    	}
	       
	    	int[] evac1 = new int[(sum/2)+ 1];
	    	int[] evac2 = new int[(sum/2) + 1];
	    	int evac = 0;
	    	int original = sum;
	    	
	    	while (sum > 0) {
	    		int max = (parties[0] > parties[1] ? 0 : 1);
		    	int second = (parties[0] > parties[1] ? 1 : 0);
		    	for (int i = 2; i < n; i++) {
		    		if (parties[i] > max) {
		    			second = max;
		    			max = i;
		    		}
		    		else if (parties[i] > second) {
		    			second = i;
		    		}
		    	}
		    	if (sum%2 == 1) {
		    		evac1[evac] = max;
		    		evac2[evac] = -1;
		    		parties[max] -= 1;
		    		sum -= 1;
		    	}
		    	else {
		    		evac1[evac] = max;
		    		evac2[evac] = second;
		    		parties[max] -= 1;
		    		parties[second] -= 1;
		    		sum -= 2;
		    	}
		    	evac++;
	    	}
	    	
	       StringBuilder builder = new StringBuilder();
	       builder.append(String.format("Case #%1$s:", loop));
	       for (int i = 0; i < (original/2) + (original%2 == 1? 1:0); i++) {
	    	   builder.append(' ');
	    	   builder.append((char)('A' + evac1[i]));
	    	   if (evac2[i] != -1)
	    		   builder.append((char)('A' + evac2[i]));
	       }	
	       System.out.println(builder.toString());
	       //String line = String.format("Case #%1$s: %2$s", loop, flow);
	       //System.out.println(line);
	    }
	    in.close();
 }
}
