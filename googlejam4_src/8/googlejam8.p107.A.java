package googlejam8.p107;
import java.util.*;
import java.math.BigInteger;
//import edu.princeton.cs.algs4.*;


public class A
{
    static int [] arr;
    static int N; 
    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int nocase = sc.nextInt();
        sc.nextLine();
        for(int ind=1; ind<=nocase; ind++)
        {
            N = sc.nextInt();
            arr = new int[N];
            int total = 0;
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            for(int i=0; i<N; i++)
                total+=arr[i];
            StringBuffer sb = new StringBuffer();
            while(total>2)
            {
                int max_ind = 0;
                for(int i=1; i<N; i++)
                    if(arr[i] > arr[max_ind])
                        max_ind = i;
                
                arr[max_ind]--;
                total--;
                sb.append((char)('A'+max_ind));

                if(total==2)
                {
                    sb.append(' ');
                    break;
                }
                for(int i=0; i<N; i++)
                {
                    if(arr[i] >= (total+0.0)/2.0)
                    {
                        arr[i]--;
                        total--;
                        sb.append((char)('A'+i));
                        break;
                    }
                }
                sb.append(' ');

            }
            //last 2
            for(int i=0; i<N; i++)
                if(arr[i] >0 )
                    sb.append((char)('A'+i));
        
            String soln = sb.toString();    
            System.out.printf("Case #%d: %s\n", ind, soln);
        }
    }

}
