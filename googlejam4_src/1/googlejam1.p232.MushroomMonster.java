package googlejam1.p232;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by xuchen on 4/17/15.
 */
public class MushroomMonster {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new File("src/MushroomMonster/A-large.in"));
            PrintWriter writer = new PrintWriter(new File("src/MushroomMonster/result.txt"));

            int caseCnt = scanner.nextInt();

            for (int i = 0; i < caseCnt; i++){

                int mushRoomCnt = scanner.nextInt();
                int firstCnt = 0;
                int secondCnt = 0;

                int firstNum = scanner.nextInt();

                int[] nums = new int[mushRoomCnt];
                nums[0] = firstNum;

                int rate = 0;

                for (int j = 1; j < mushRoomCnt; j++){

                    int secondNum = scanner.nextInt();
                    nums[j] = secondNum;

                    if (firstNum >= secondNum) {
                        firstCnt += firstNum - secondNum;
                        rate = Math.max(firstNum - secondNum,rate);
                    }

                    firstNum = secondNum;
                }

                for (int j = 0; j < mushRoomCnt - 1; j++){
                    secondCnt += Math.min(rate,nums[j]);
                }

                writer.println("Case #" + (i + 1) + ": " + firstCnt + " " + secondCnt);
            }

            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
