package googlejam1.p038;
import java.util.*;

public class A
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for(int ca=1;ca <= T;ca++)
        {
            int N = scan.nextInt();
            int[] a = new int[N];
            for(int i=0;i < N;i++)
                a[i] = scan.nextInt();

            int y = 0;
            for(int i=1;i < N;i++)
                if(a[i] < a[i-1])
                    y += a[i-1] - a[i];
            
            int r = 0;
            for(int i=1;i < N;i++)
                r = Math.max(r, a[i-1] - a[i]);

            int z = 0;
            for(int i=0;i < N-1;i++)
                z += Math.min(a[i], r);


            System.out.println("Case #" + ca + ": " + y + " " + z);
        }
    }
}