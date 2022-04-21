package googlejam1.p331;
/**
 * Created by LaiQX on 04/17/15.
 */
import java.util.*;
import java.io.*;
public class MushroomMonster {
    public static void main(String[] args) throws FileNotFoundException {

//        String input = "4\n" +
//            "4\n" +
//            "10 5 15 5\n" +
//            "2\n" +
//            "100 100\n" +
//            "8\n" +
//            "81 81 81 81 81 81 81 0\n" +
//            "6\n" +
//            "23 90 40 0 100 9";

        Scanner sc = new Scanner(System.in);
        PrintWriter wr = new PrintWriter("output2");
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i< T ; i++) {

            StringBuilder ans = new StringBuilder();
            ans.append("Case #"+(i+1)+": ");

            int N = Integer.parseInt(sc.nextLine());
            String[] ms = sc.nextLine().split(" ");
            int count_1 = 0;
            int count_2 = 0;
            int max = 0;
            for (int j = 1; j<N; j++) {
                int last = Integer.parseInt(ms[j-1]);
                int curr = Integer.parseInt(ms[j]);
                if (last>curr) {
                    count_1 = count_1 + (last-curr);
                    max = Math.max(max,last-curr);
                }
            }

            for (int j = 0; j<N-1; j++) {
                int curr = Integer.parseInt(ms[j]);
                if (curr<max) {
                    count_2 = count_2 + curr;
                } else {
                    count_2 = count_2 + max;
                }
            }

            ans.append(count_1+" ");
            ans.append(count_2);

            wr.println(ans);

        }
        wr.close();
    }
}
