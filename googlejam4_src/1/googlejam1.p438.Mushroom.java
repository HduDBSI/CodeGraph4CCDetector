package googlejam1.p438;
import java.io.*;

/**
 * Created by danie_000 on 4/17/2015.
 */
public class Mushroom {

    public static void main (String[] args) {
        BufferedReader br;
        BufferedWriter bw;
        try {
            br = new BufferedReader(new FileReader("A-large.in"));
            bw = new BufferedWriter(new FileWriter("A-large.out"));
            int t = Integer.parseInt(br.readLine());
            for (int iii = 1; iii <= t; iii++) {
                bw.write("Case #" + iii + ": ");
                int n = Integer.parseInt(br.readLine());
                String[] splits = br.readLine().split(" ");

                int[] mushrooms = new int[n];
                for (int jjj = 0; jjj < n; jjj++) {
                    mushrooms[jjj] = Integer.parseInt(splits[jjj]);
                }
                int previous = mushrooms[0];
                int case1 = 0;
                int case2 = 0;
                int max = 0;
                for (int jjj = 1; jjj < n; jjj++) {
                    int current = mushrooms[jjj];
                    if (current < previous) {
                        int temp = previous - current;
                        case1 += temp;
                        if (temp > max) {
                            max = temp;
                        }
                    }
                    previous = current;
                }

                for (int jjj = 0; jjj < n - 1; jjj++) {
                    int current = mushrooms[jjj];
                    if (current > max) {
                        case2 += max;
                    } else {
                        case2 += current;
                    }
                }
                bw.write(case1 + " " + case2);
                bw.newLine();
            }
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
