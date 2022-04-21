package googlejam6.p074;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class RankAndFile {


    public static void main(String[] args) throws FileNotFoundException {
//        Scanner cin = new Scanner(new File("B-small-attempt1.in"));
//        PrintStream cout = new PrintStream("B-small-attempt1.out.1");
        Scanner cin = new Scanner(new File("B-large.in"));
        PrintStream cout = new PrintStream("B-large.out");
//        Scanner cin = new Scanner(System.in);
//        PrintStream cout = System.out;

        int _case = 0;
        for (int T = cin.nextInt(); T > 0; T--) {
            _case++;
            StringBuilder ans = new StringBuilder();

            int n = cin.nextInt();
            int[] cnt = new int[10000];
            for (int i=0; i<2*n-1; i++)
                for (int j=0; j<n; j++)
                    cnt[cin.nextInt()]++;
            for (int i=0; i<cnt.length; i++)
                if (cnt[i] %2 == 1) {
                    ans.append(" ");
                    ans.append(i);
                }

            cout.printf("Case #%d:%s%n", _case, ans.toString());
        }

        cin.close();
        cout.close();
    }
}
