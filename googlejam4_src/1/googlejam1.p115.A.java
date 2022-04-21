package googlejam1.p115;
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
                int n = sc.nextInt();
                int[] m = new int[n];
                for (int i = 0; i < n; i++) {
                    m[i] = sc.nextInt();
                }

                long answer1 = 0;
                long answer2 = 0;
                long speed = 0;

                for (int i = 1; i < n; i++) {
                    if (m[i] < m[i - 1]) {
                        answer1 += m[i - 1] - m[i];
                        speed = Math.max(speed, m[i - 1] - m[i]);
                    }
                }

                for (int i = 1; i < n; i++) {
                    answer2 += Math.min(m[i - 1], speed);
                }

                String line = "Case #" + c + ": " + answer1 + " " + answer2;
                System.out.println(line);
                sb.append(line).append('\n');
            }
            Files.write(Paths.get(OUTPUT), sb.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
