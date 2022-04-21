package googlejam6.p547;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        final String FILE = "B-large";
        PrintWriter outPrinter = new PrintWriter(new File("C:\\Users\\ivo.correia\\Downloads\\" + FILE  + ".out"));

        Scanner scanIn = new Scanner(new File("C:\\Users\\ivo.correia\\Downloads\\" + FILE + ".in"));
        final int T = Integer.parseInt(scanIn.nextLine());

        for (int entry = 0; entry < T; entry++) {
            final int N = Integer.parseInt(scanIn.nextLine());

            int[] numbers = new int[2501];

            for (int lines = 0; lines < N*2 -1; lines++)  {
                String[] rawIn = scanIn.nextLine().split(" ");
                for (int i = 0; i < N; i++) {
                    int number = Integer.parseInt(rawIn[i]);
                    numbers[number] = numbers[number] + 1;
                }
            }

            outPrinter.write("Case #" + (entry + 1) + ":");
            for (int i = 0; i < 2501; i++) {
                if (numbers[i] > 0 && numbers[i] % 2 == 1) {
                    outPrinter.write(" " + i);
                }
            }

            outPrinter.write("\n");
        }

        outPrinter.close();
        scanIn.close();
    }

}
