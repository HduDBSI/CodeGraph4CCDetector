package googlejam6.p449;
import java.util.Scanner;

/**
 *
 * @author rahuljaisingh
 */
public class code {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++)
        {
            System.out.print("Case #" + i + ": ");
            int N = sc.nextInt();
            int max = 0;
            int C[][] = new int[2*N-1][N];
            for(int j = 0; j < 2 * N - 1; j++)
            {
                for(int k = 0; k < N; k++)
                {
                    int F = sc.nextInt();
                    if(F > max)
                    {
                        max = F;
                    }
                    C[j][k] = F;
                }
            }
            int A[] = new int[max];
            for(int j = 0; j < max; j++)
            {
                int check = j + 1;
                for(int k = 0; k < 2 * N - 1; k++)
                {
                    for(int l = 0; l < N; l++)
                    {
                        if(C[k][l] == check)
                        {
                            A[j] = A[j] + 1;
                        }
                    }
                }
            }
            for(int j = 0; j < max; j++)
            {
                if(A[j] % 2 == 1)
                {
                    System.out.print(j+1 + " ");
                }
            }
            System.out.println();
        }
    }
    
}
