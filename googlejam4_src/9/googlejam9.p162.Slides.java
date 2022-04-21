package googlejam9.p162;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Slides {
	public static void main(String[] args) {
	    //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		Scanner in = new Scanner(System.in);
	    int loops = in.nextInt();
	 	
	    for (int loop = 1; loop <= loops; ++loop) {
	    	int b= in.nextInt(); long m = in.nextLong();
	    	long max = 1;
	    	for(int i = 2; i < b; i++) {
	    		max*=2;
	    	}
	       if (m > max) {
	    	   String line = String.format("Case #%1$s: IMPOSSIBLE", loop);
		       System.out.println(line); 
		       continue;
	       }
	    	
	       String line = String.format("Case #%1$s: POSSIBLE", loop);
	       System.out.println(line); 
	       
	       
	       long pow = max/2;
	       boolean[] linked = new boolean[b];
	       int index = b-2;
	       while (m > 1) {
	    	   if (m >= pow) {
	    		   linked[index] = true;
	    		   m -= pow;
	    	   }
	    	   pow /= 2;
	    	   index--;
	       }
	       if (m == 1) {
	    	   linked[0] = true;
    		   m -= 1;
	       }
	       
	       StringBuilder builder;
	       for (int i = 0; i < b-1; i++) {
	    	   builder = new StringBuilder();
	    	   for (int j = 0; j < i+1; j++)
	    		   builder.append(0);
	    	   for (int j = 0; j < b - i -2; j++)
	    		   builder.append(1);
	    	   builder.append(linked[i] ? 1 : 0);
	    		System.out.println(builder);
	       }
	       builder = new StringBuilder();
	       for (int j = 0; j < b; j++)
	    	   builder.append(0);
	       System.out.println(builder);
	       
	       //String line = String.format("Case #%1$s: %2$s", loop, flow);
	       //System.out.println(line);
	    }
	    in.close();
 }
}
