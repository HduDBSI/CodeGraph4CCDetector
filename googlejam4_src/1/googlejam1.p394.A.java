package googlejam1.p394;
import java.util.*;

public class A
{
    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int noCase = sc.nextInt();
        for(int ind =1; ind<=noCase; ind++)
        {
            int M = sc.nextInt();
            long [] arr = new long[M];
            for(int i=0; i<M; i++)
                arr[i] = sc.nextLong();
			long soln = 0L;
			for(int i=0; i<arr.length-1; i++)
			    if(arr[i]>arr[i+1])
			        soln+=arr[i]-arr[i+1];
            long m1 = soln;
			long soln1 = 0L;
			long maxD = 0L;
			for(int i=0; i<arr.length-1; i++)
			    maxD = Math.max(arr[i]-arr[i+1], maxD);
			for(int i=0; i<arr.length-1; i++)
			    soln1+=Math.min(maxD, arr[i]);
            long m2 = soln1;
            System.out.printf("Case #%d: %d %d\n", ind, m1, m2);
        }
    }

}
