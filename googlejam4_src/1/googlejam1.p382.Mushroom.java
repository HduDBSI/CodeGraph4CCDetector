package googlejam1.p382;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Mushroom {
	 public static void main(String ... orange) throws Exception
	    {
	        Scanner input = new Scanner(System.in);
	        int numCases = input.nextInt();
	        for (int n = 0; n < numCases; n++)
	        {
	            int N = input.nextInt();
	            int[] ps = new int[N];
	            for (int i = 0; i < N; i++)
	                ps[i] = input.nextInt();

	            int maxDiff = -1; int sum1= 0,sum2=0;
	            for(int i=0; i< (N-1);i++){
	            	int diff = ps[i]- ps[i+1];
	            	if(diff > 0) sum1 += diff;
	            	if(diff > maxDiff) maxDiff = diff;	
	            }
	            
	            for(int i=0; i< (N-1);i++){
	            	if(ps[i] < maxDiff) sum2+=ps[i];
	            	else sum2+= maxDiff;
	            }
	            
	            System.out.printf("Case #%d: %d %d\n", n + 1, sum1,sum2);
	        }
	    }

}
