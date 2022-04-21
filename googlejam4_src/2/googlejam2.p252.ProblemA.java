package googlejam2.p252;
import java.util.*;

public class ProblemA {
    public static void main(String[] args) {
        for(int i=1; i<=11; i++) {
		    dp[i] = i;
		}
		
		//actual dp
		for(int i=1; i<dp.length - 1; i++) {
		    //fill in the one ahead
		    if(dp[i+1] == 0 || dp[i+1] > dp[i] + 1)
		        dp[i+1] = dp[i] + 1;
		    
		    //and the one reversed if needed
		    char[] number = Integer.toString(i).toCharArray();
		    for(int i1=0; i1<number.length/2; i1++) {
			    char t = number[i1];
			    number[i1] =  number[number.length - i1 - 1];
			    number[number.length - i1 - 1] = t;
			}
		    int revNo = Integer.parseInt(new String(number));
		    
		    if(revNo > i && revNo < dp.length) {
		        if(dp[revNo] == 0 || dp[revNo] > dp[i] + 1)
		            dp[revNo] = dp[i] + 1;
		    }
		}
        Scanner in = new Scanner(System.in);
        
        final int noTests = in.nextInt();
        in.nextLine();
        
        for(int test=1; test<=noTests; test++) {
            int target = in.nextInt();
            System.out.printf("Case #%d: %d%n", test, dp[target]);
        }
    }

    static int dp[] = new int[1_000_001];
    
}
