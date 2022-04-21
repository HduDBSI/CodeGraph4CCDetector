package googlejam1.p526;
import java.util.Scanner;

public class MushroomMonster {

    public static void main(String[] args) {

        MushroomMonster algorithm = new MushroomMonster();

        Scanner scanner = new Scanner(System.in);
        String testCaseNumber = scanner.nextLine();

        int TEST_CASE_NUMBER = Integer.parseInt(testCaseNumber);

        for (int testNumber = 1; testNumber <= TEST_CASE_NUMBER; testNumber++) {

            String maxLine = scanner.nextLine();
			
			Integer max = Integer.parseInt(maxLine);
			String mushroomsLine = scanner.nextLine();
			String[] mushroomsString = mushroomsLine.split(" ");
			int[] mushrooms = new int[max];
			
			for (int i = 0; i < max; i++) {
			    mushrooms[i] = Integer.parseInt(mushroomsString[i]);
			}
			
			int firstMethod = 0;
			// first method
			for (int i = 0; i < max - 1; i++) {
			    int temp = mushrooms[i] - mushrooms[i + 1];
			    if (temp > 0) {
			        firstMethod += temp;
			    }
			}
			
			// second method
			int eatenPerSecond = 0;
			for (int i = 0; i < max - 1; i++) {
			    int temp = mushrooms[i] - mushrooms[i + 1];
			    if (temp > eatenPerSecond) {
			        eatenPerSecond = temp;
			    }
			}
			
			int secondMethod = 0;
			for (int i = 0; i < max - 1; i++) {
			    if (mushrooms[i] - eatenPerSecond >= 0) {
			        secondMethod += eatenPerSecond;
			    } else {
			        secondMethod += mushrooms[i];
			    }
			}
			String answer = String.valueOf(firstMethod + " " + secondMethod);

            System.out.println("Case #" + testNumber + ": " + answer);
        }

        scanner.close();
    }
}
