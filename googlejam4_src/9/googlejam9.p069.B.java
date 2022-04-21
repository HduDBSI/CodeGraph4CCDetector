package googlejam9.p069;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("inputBlarge.txt"));
        int tests = scanner.nextInt();
        for (int test=1; test<=tests; test++) {
            scanner.nextLine();
            int b = scanner.nextInt();
            long m = scanner.nextLong();
            int[][] ans = new int[b+1][b+1];

            ans[1][b] = 1;
            m--;
            if (m > 0 && 2 < b) {
                ans[2][b] = 1;
                m--;
            }

            for (int i=2; i<b; i++) {
                ans[1][i] = 1;
            }

            int next = 3;
            long add = 2L;
            while (m > 0 && next < b) {
                ans[next][b] = 1;
                for (int prev = next - 1; prev >= 2; prev--) {
                    ans[next][prev] = 1;
                }
                m -= add;
                add *= 2;
                next++;
            }
            add /= 4;
            int last = next - 1;
            int prev = last - 1;
            while (m < 0) {
                while (add > -m) {
                    prev--;
                    add /= 2;
                }
                m += add;
                ans[last][prev] = 0;
            }

            if (m > 0) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": POSSIBLE");
                for (int y=1; y<ans.length; y++) {
                    for (int x=1; x<ans[0].length; x++) {
                        System.out.print(ans[y][x]);
                    }
                    System.out.println();
                }
            }
        }

        scanner.close();
    }
}
