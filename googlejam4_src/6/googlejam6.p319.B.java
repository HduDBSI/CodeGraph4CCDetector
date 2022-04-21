package googlejam6.p319;
import java.util.*;

public class B
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++)
        {
            String res = "";
            int N = sc.nextInt();
            int d[] = new int[2500];
            List<Integer> r = new ArrayList<>();

            for(int j = 0; j < (2*N-1)*N; j++)
            {
                d[sc.nextInt()-1]++;
            }
            for(int j = 0; j < 2500; j++)
            {
                if(d[j]%2 != 0) r.add(j+1);
            }
            Collections.sort(r);
            res += r.get(0);
            for(int j = 1; j < r.size(); j++) res += " "+r.get(j);

            System.out.println("Case #"+(i+1)+": "+res);
        }
    }
}
