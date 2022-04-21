package googlejam9.p072;
import java.util.*;
import java.math.*;

/**
 *
 * @author rahuljaisingh
 */
public class cj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++)
        {
            System.out.print("Case #" + i + ": ");
            int B = sc.nextInt();
            BigInteger M = new BigInteger(sc.next());
            BigInteger two = new BigInteger("2");
            if(M.compareTo(two.pow(B-2)) == 1)
            {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            System.out.println("POSSIBLE");
			BigInteger M1 = M.subtract(BigInteger.ONE);
            int res[][] = new int[B][B];
			for(int i2 = 0; i2 < B; i2++)
			{
			    for(int j = 0; j < B; j++)
			    {
			        res[i2][j] = (j > i2) ? 1 : 0;
			    }
			}
			for(int i4 = 1; i4 < B - 1; i4++)
			{
			    res[0][i4] = 0;
			}
			BigInteger two1 = new BigInteger("2");
			for(int i1 = B - 2; i1 > 0; i1--)
			{
			    if(M1.mod(two1).equals(BigInteger.ONE))
			    {
			        res[0][i1] = 1;
			    }
			    M1 = M1.divide(two1);
			}
			for(int i3 = 0; i3 < B; i3++)
			{
			    for(int j = 0; j < B; j++)
			    {
			        System.out.print(res[i3][j]);
			    }
			    System.out.println();
			}
        }
            
    }
}
