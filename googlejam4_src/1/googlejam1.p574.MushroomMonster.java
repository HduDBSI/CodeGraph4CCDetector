package googlejam1.p574;
import java.util.*;
import java.io.*;

public class MushroomMonster {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("A-large.in.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));
        int numberOfCases = input.nextInt();
        for(int i=0;i<numberOfCases;i++) {
            int numberOfMushroomCases = input.nextInt();
            int mushrooms[] = new int[numberOfMushroomCases];
            for(int j=0;j<numberOfMushroomCases;j++) {
                mushrooms[j] = input.nextInt();
            }
            int first = 0;
            for(int j=1;j<numberOfMushroomCases;j++) {
                if(mushrooms[j]<mushrooms[j-1]) {
                    first+=mushrooms[j-1]-mushrooms[j];
                }
            }
            int biggestDifference = 0;
            for(int j=1;j<numberOfMushroomCases;j++) {
                if(mushrooms[j-1]-mushrooms[j]>biggestDifference) {
                    biggestDifference = mushrooms[j-1]-mushrooms[j];
                }
            }
            int mushroomsPerTenSeconds = biggestDifference;
            System.out.println(biggestDifference/10.0 + " " + Math.ceil(biggestDifference/10.0) + " " + mushroomsPerTenSeconds);
            int second = 0;
            for(int j=0;j<numberOfMushroomCases-1;j++) {
                if(mushrooms[j]<=mushroomsPerTenSeconds) {
                    second+=mushrooms[j];
                }
                else {
                    second+=mushroomsPerTenSeconds;
                }
            }
            output.println("Case #" + (i+1) + ": " + first + " " + second);
        }
        input.close();
        output.close();
    }
}