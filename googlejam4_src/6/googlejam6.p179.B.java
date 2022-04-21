package googlejam6.p179;
import java.util.*;
import java.math.BigInteger;
//import edu.princeton.cs.algs4.*;


public class B
{

    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int nocase = sc.nextInt();
        sc.nextLine();
        for(int ind=1; ind<=nocase; ind++)
        {
            
            int N = sc.nextInt();
            HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
            for(int r=0; r<2*N-1; r++)
            for(int c=0; c<N; c++)
            {
                int n = sc.nextInt();
                int count = 0;
                if(hm.containsKey(n)) count = hm.get(n);
                hm.put(n, count+1);
            }

            Set<Integer> ks = hm.keySet();
            ArrayList<Integer> L = new ArrayList<Integer>();
            for(Integer n: ks)
            {
                int count = hm.get(n);
                if(count%2 != 0)
                    L.add(n);
            }
            Collections.sort(L);

            StringBuffer sb = new StringBuffer();
            for(Integer n: L)
            {
                sb.append(n);
                sb.append(' ');
            }
            String soln = sb.toString();
            System.out.printf("Case #%d: %s\n", ind, soln);
        }
    }

}
