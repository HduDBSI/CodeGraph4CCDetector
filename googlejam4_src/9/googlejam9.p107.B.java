package googlejam9.p107;
import java.util.*;
import java.io.*;
import java.math.*;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // number of test cases
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String[] nums = in.nextLine().split(" ");
            int B = Integer.parseInt(nums[0]);
            BigInteger M = new BigInteger(nums[1]);
			BigInteger[] result = new BigInteger[B+1];
			result[0] = BigInteger.ZERO;
			result[1] = BigInteger.ONE;
			BigInteger runningSum = BigInteger.ONE;
			for(int i4=2; i4<=B; i4++) {
			    result[i4] = runningSum;
			    runningSum = runningSum.add(result[i4]);
			}
            // System.out.println(B + "");
            // System.out.println(M.toString());
            BigInteger[] numWays = result;
            // System.out.println(numWays[B]);
            if (numWays[B].compareTo(M) < 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");            
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");    
                int[][] matrix = new int[B][B];
				for(int i3=0; i3<B;i3++) {
				    for(int j=i3+1; j<B;j++) {
				        matrix[i3][j] = 1;
				    }    
				}
				
				BigInteger difference = numWays[B].subtract(M);
				
				while(difference.compareTo(BigInteger.ZERO) != 0) {
				    for(int i2=B-1; i2>=1; i2--){
				        if (difference.compareTo(numWays[i2]) >= 0) {
				            //System.out.println(i);
				            matrix[i2-1][B-1] = 0;
				            difference = difference.subtract(numWays[i2]);
				        }
				    }
				}
				
				for(int i1=0; i1<B;i1++) {
				    for(int j=0; j<B;j++) {
				        System.out.print(matrix[i1][j]);
				    }    
				    System.out.println("");
				}   
            }
        }
    }
}

