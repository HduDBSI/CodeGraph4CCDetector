package googlejam1.p063;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MushroomMonster {

    static int n;
    static int[] a;

    public static void main(String[] args) throws FileNotFoundException {
        //        Scanner cin = new Scanner(new File("A-small-attempt1.in"));
        //        PrintStream cout = new PrintStream("A-small-attempt1.out");
        Scanner cin = new Scanner(new File("A-large.in"));
        PrintStream cout = new PrintStream("A-large.out");
        //                Scanner cin = new Scanner(System.in);
        //                PrintStream cout = System.out;

        int _case = 0;
        for (int T = cin.nextInt(); T > 0; T--) {
            _case++;
            n = cin.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = cin.nextInt();

            int one = 0;
            int two = 0;
            int maxGap = 0;
            for (int i = 1; i < n; i++)
                if (a[i] < a[i - 1]) {
                    one += a[i - 1] - a[i];
                    maxGap = Math.max(maxGap, a[i - 1] - a[i]);
                }

            for (int i = 1; i < n; i++)
                two += Math.min(a[i - 1], maxGap);

            cout.printf("Case #%d: %d %d%n", _case, one, two);
        }

        cin.close();
        cout.close();
    }

}
