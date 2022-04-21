package googlejam12.p027;
import java.util.*;
import java.io.*;
import static lib.Util.*;

public class A
{
    static int N;

    static int ans;

    public static void main(String ... orange) throws Exception
    {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++)
        {
            char[] S = input.next().toCharArray();
            int K = S.length;
            int[][] table = new int[K + 1][K + 1];
            for (int len = 2; len <= K; len += 2)
                for (int start = 0; start + len <= K; start++)
                {
                    table[start][len] = (S[start] == S[start + len - 1] ? 10 : 5) + table[start + 1][len - 2];
                    for (int first = 2; first < len; first += 2)
                        if (table[start][first] + table[start + first][len - first] > table[start][len])
                            table[start][len] = table[start][first] + table[start + first][len - first];
                }

            System.out.printf("Case #%d: ", n + 1);
            System.out.println(table[0][K]);
        }
    }
}

