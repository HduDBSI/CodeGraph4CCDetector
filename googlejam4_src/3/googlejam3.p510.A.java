package googlejam3.p510;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {

        A algorithm = new A();

        Scanner scanner = new Scanner(System.in);

        String testCaseNumber = scanner.nextLine();

        int TEST_CASE_NUMBER = Integer.parseInt(testCaseNumber);

        for (int testNumber = 1; testNumber <= TEST_CASE_NUMBER; testNumber++) {

            String RCW = scanner.nextLine();
			
			int R = Integer.parseInt(RCW.split(" ")[0]);
			int C = Integer.parseInt(RCW.split(" ")[1]);
			int W = Integer.parseInt(RCW.split(" ")[2]);
			
			int counter = 0;
			for(int r = 0; r<R;r++) {
			    for (int c = 0; c < C; c++) {
			        if (c % W == 0) {
			            counter++;
			        }
			    }
			}
			counter = counter + W - 1;
			String answer = String.valueOf(counter);

            System.out.println("Case #" + testNumber + ": " + answer);
        }

        scanner.close();
    }

}
