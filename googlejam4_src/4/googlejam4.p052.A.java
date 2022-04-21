package googlejam4.p052;
import java.util.*;

public class A
{
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for(int ca=1;ca <= T;ca++)
        {
            int R = scan.nextInt();
            int C = scan.nextInt();
            char[][] a = new char[R][C];
            for(int i=0;i < R;i++)
            {
                String str = scan.next();
                for(int j=0;j < C;j++)
                    a[i][j] = str.charAt(j);
            }

            int ans = 0;
            boolean poss = true;

            for(int i=0;i < R;i++)
            for(int j=0;j < C;j++)
            {
                if(a[i][j] == '.') continue;

                int dd = -1;
                switch(a[i][j])
                {
                    case '>': dd = 0; break;
                    case '^': dd = 1; break;
                    case '<': dd = 2; break;
                    case 'v': dd = 3; break;
                }

                boolean safe = false;
                for(int ddd=0;ddd < 4;ddd++)
                {
                    int r = i;
                    int c = j;
                    while(true)
                    {
                        r += dr[ddd];
                        c += dc[ddd];
                        if (r >= 0 && r < R && c >= 0 && c < C)
                        {
                            if(a[r][c] != '.')
                            {
                                safe = true;
                                break;
                            }
                        }
                        else
                        {
                            if(ddd == dd) 
                            {
                                ans++;
                            }
                            break;
                        }
                    }
                }

                poss &= safe;
            }

            System.out.println("Case #" + ca + ": " + (poss ? ans : "IMPOSSIBLE"));
        }
    }
}