package googlejam6.p454;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Сô on 2016/4/16.
 */
public class RankAndFile {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("B/B-large.in");
            PrintStream ps = new PrintStream(new FileOutputStream("B/large-result.out"));
            System.setIn(fis);
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++){
            int n = in.nextInt();
            int[] height = new int[2501];
            int num = (2 * n - 1) * n;
            for (int j = 0; j < num; j++) {
                int h = in.nextInt();
                height[h]++;
            }

            out.format("Case #%d:", i);
            for (int j = 1; j < height.length; j++) {
                if (height[j] % 2 == 1) out.format(" %d", j);
            }
            out.println();
        }
    }

}
