package googlejam6.p484;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("D:/xѧϰ/eclipse2/eclipseWorkSpace/GoogleCodeJam2016/src/input/roundA1/B-large.in"));
			try {
				FileWriter fw = new FileWriter(new File("D:/xѧϰ/eclipse2/eclipseWorkSpace/GoogleCodeJam2016/src/output/roundA1/B-large.out"));
				int caseNum = Integer.parseInt(input.nextLine());
				for(int i = 1; i <= caseNum; i++) {
					int N = Integer.parseInt(input.nextLine());
					int[] cnt = new int[2501];
					int total = 2 * N - 1;
					for(int j = 0; j < total; j++) {
						String list = input.nextLine();
						String[] strArray = list.split("\\s{1,}");
						for(int k = 0; k < N; k++) {
							cnt[Integer.parseInt(strArray[k])]++;
						}
					}
					int[] missingList = new int[N];
					int k = 0;
					for(int j = 1; j < 2501; j++) {
						if(cnt[j] % 2 != 0) {
							missingList[k++] = j;
						}
						if(k == N) {
							break;
						}
					}
					Arrays.sort(missingList);
					String output = "";
					for(int j = 0; j < N; j++) {
						output += missingList[j] + " ";
					}
					output = "Case #" + i + ": " + output + "\n";
					fw.write(output);
				}
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
