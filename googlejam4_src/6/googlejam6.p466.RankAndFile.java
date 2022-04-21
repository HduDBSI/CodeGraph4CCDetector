package googlejam6.p466;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by FengZH on 4/15/16.
 */
public class RankAndFile {

    public static void main(String[] args) {
        File input = new File("B-large.in copy.txt");
		try {
		    Scanner in = new Scanner(input);
		    int total = in.nextInt();
		    Writer writer = new BufferedWriter(new OutputStreamWriter(
		            new FileOutputStream("RankAndFileLargeOutput.out"), "utf-8"));
		    for (int i = 1; i <= total; i++) {
		        int N = in.nextInt();
		        int[][] reminderList = new int[2 * N - 1][N];
		        for (int j = 0; j < 2 * N - 1; j++) {
		            for (int k = 0; k < N; k++) {
		                reminderList[j][k] = in.nextInt();
		            }
		        }
				int[] missing = new int[N];
				int[] height = new int[2500]; // default:0
				for (int i1 = 0; i1 < 2500; i1++) {
				    height[i1] = 0;
				}
				int missIndex = 0;
				for (int j1 = 0; j1 < 2 * N - 1; j1++) {
				    for (int k = 0; k < N; k++) {
				        height[reminderList[j1][k] - 1]++;
				    }
				}
				for (int i2 = 0; i2 < 2500; i2++) {
				    if (height[i2] % 2 != 0) {
				        missing[missIndex] = i2 + 1;
				        missIndex++;
				    }
				}
				System.out.println(Arrays.toString(missing));
		        int[] missingList = missing;
		        String temp = String.format("Case #%d:", i);
		        writer.write(temp);
		        for (int j = 0; j < N; j++) {
		            temp = String.format(" %d", missingList[j]);
		            writer.write(temp);
		        }
		        temp = String.format("%n");
		        writer.write(temp);
		    }
		    writer.close();
		    in.close();
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
    }
}
