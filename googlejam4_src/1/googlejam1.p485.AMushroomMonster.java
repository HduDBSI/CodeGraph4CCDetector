package googlejam1.p485;


import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by adarsh.sharma on 18/04/15.
 */
public class AMushroomMonster {
    public static void main(String[] args) {
        Scanner scanner = null;
        PrintWriter out = null;
        try {
            String inputFile = "/Users/adarsh.sharma/Documents/coding/java/src/com/google/code/jam/OneA/A-large.in";
            scanner = new Scanner(new FileReader(inputFile));
            String outFile = "/Users/adarsh.sharma/Documents/coding/java/src/com/google/code/jam/OneA/A-large.out";
            out = new PrintWriter(outFile);
//            scanner = new Scanner(new InputStreamReader(System.in));
//            out = new PrintWriter(System.out);

            int T = scanner.nextInt();
            for (int t = 1; t <= T; t++) {
                int N = scanner.nextInt();
                List<Integer> A = new ArrayList<Integer>();
                for (int n = 0; n < N; n++) {
                    A.add(scanner.nextInt());
                }

                int X = 0;
                for(int n=1; n<N; n++){
                    X +=max(A.get(n-1)-A.get(n),0);
                }

                int minRate = 0;
                for(int n=1; n<N; n++){
                    minRate = max(A.get(n-1)-A.get(n),minRate);
                }

                int Y = 0;
                for(int n=1; n<N; n++){
                    Y+=min(A.get(n-1),minRate);
                }

                out.println("Case #" + t + ": " + X + " " + Y);
//                out.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
            out.close();
        }
    }

}
