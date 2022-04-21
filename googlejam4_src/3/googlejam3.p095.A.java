package googlejam3.p095;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class A {

    private static final String INPUT = "A-large.in";
    private static final String OUTPUT = "A-large.out";

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(Paths.get(INPUT));
            StringBuilder sb = new StringBuilder();
            int cases = sc.nextInt();
            for (int c = 1; c < cases + 1; c++) {
                int R = sc.nextInt();
                int C = sc.nextInt();
                int W = sc.nextInt();

                String line = "Case #" + c + ": " + solve(R, C, W);
                System.out.println(line);
                sb.append(line).append('\n');
            }
            Files.write(Paths.get(OUTPUT), sb.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int solve(int R, int C, int W) {
        int tryRows = (int) Math.floor((C / W) * 1.0);
        int ret = W + (int) Math.ceil((C - W) * 1.0 / W);
        return tryRows * (R - 1) + ret;
    }
}