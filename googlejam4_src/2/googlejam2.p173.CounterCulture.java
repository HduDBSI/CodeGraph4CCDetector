package googlejam2.p173;
/**
 * Created by LaiQX on 05/02/15.
 */
import java.util.*;
import java.io.*;

public class CounterCulture {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/A-small-attempt1.in");
//        File input = new File("src/input1");
        Scanner sc = new Scanner(input);
        PrintWriter wr = new PrintWriter("output2");
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i< T ; i++) {

            StringBuilder ans = new StringBuilder();
            ans.append("Case #"+(i+1)+": ");
            int N = Integer.parseInt(sc.nextLine());
            int[] steps = new int[N+1];
            steps[0]=0;
            steps[1]=1;
            for (int j = 2; j<N+1; j++) {
                if (steps[j]==0) {
                    steps[j] = steps[j-1] + 1;
                } else {
                    steps[j] = Math.min(steps[j],steps[j-1]+1);
                }
                StringBuilder tmp = new StringBuilder(""+j);
                int reverse = Integer.parseInt(tmp.reverse().toString());
                if (reverse>j && reverse<=N) {
                    if (steps[reverse]==0) {
                        steps[reverse]=steps[j]+1;
                    } else {
                        steps[reverse] = Math.min(steps[reverse],steps[j]+1);
                    }
                }
            }

            ans.append(steps[N]);

            wr.println(ans);
            System.out.println("case # "+(i+1)+" done!");

        }
        wr.close();
    }
}
