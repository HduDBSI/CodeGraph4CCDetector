package googlejam3.p547;
import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yatsynych on 10/05/2015.
 */
public class A1 {
    private static String _inputPath = "c:\\temp\\competition\\A1.in";
    private static String _outputPath = "c:\\temp\\competition\\A1.out";

    public static void main(String[] args) {
        Scanner input = null;
		PrintStream output = null;
		try {
		    input = new Scanner(new File(_inputPath));
		    output = new PrintStream(_outputPath);
		
		    int numberOfTestCases = input.nextInt();
		    for (int i = 0; i < numberOfTestCases; ++i){
		        int R = input.nextInt();
		        int C = input.nextInt();
		        int W = input.nextInt();
		
		        if (W == 1) {
		            String resultString = String.format("Case #%d: %d", i + 1, R * C);
		            output.println(resultString);
		            continue;
		        }
		
		        int score = (C / W) > 1 ? (C / W * R) - 1 : 0;
		        score += ((C % W) == 0) ? W : W + 1;
		
		        String resultString = String.format("Case #%d: %d", i + 1, score);
		        output.println(resultString);
		    }
		}
		catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    if (input != null) {
		        input.close();
		    }
		
		    if (output != null) {
		        output.close();
		    }
		}
    }
}
