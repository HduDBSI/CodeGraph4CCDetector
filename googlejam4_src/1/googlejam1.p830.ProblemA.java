package googlejam1.p830;


import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Ernesto Velazquez Caballero
 * @since 18/04/2015
 */
public class ProblemA {
    private static final String FOLDER_PATH = "res\\round\\one\\a";
//    private static final String FILE_PATH = "A-small-practice.in";
//    private static final String FILE_PATH = "A-small-attempt0.in";
    private static final String FILE_PATH = "A-large.in";

    public static void main(String[] args) throws Exception {
        final FileReader fileReader = new FileReader(FOLDER_PATH + "\\" + FILE_PATH);
        final BufferedReader bufferedReader = new BufferedReader(fileReader);

        final int numberOfTests = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < numberOfTests; i ++) {
            final int n = Integer.parseInt(bufferedReader.readLine());
            final String[] m = bufferedReader.readLine().split(" ");

            int result_1 = 0;
            int result_2 = 0;
            int current = Integer.parseInt(m[0]);

            int pace = 0;

            for (int j = 0; j < m.length - 1; j ++) {
                int newPace = Integer.parseInt(m[j]) - Integer.parseInt(m[j+1]);

                if (newPace >= 0) {
                    if (newPace > pace) {
                        pace = newPace;
                    }
                }
            }

            for (int j = 1; j < m.length; j ++) {
                int mInt = Integer.parseInt(m[j]);

                if (current >= mInt) {
                    result_1 += current - mInt;
                }

                result_2 += (current < pace) ? current : pace;
                current = mInt;
            }

            System.out.println("Case #" + (i + 1) + ": " + result_1 + " " + result_2);
        }
    }
}
