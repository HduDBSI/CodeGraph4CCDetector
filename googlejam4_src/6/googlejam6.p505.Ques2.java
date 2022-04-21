package googlejam6.p505;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 *
 * @author gitanshu.behal
 * Created on : 09-Apr-2016
 *
 */

public class Ques2 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(
				new FileReader("/home/local/JASPERINDIA/gitanshu.behal/Desktop/Jam/1A/Q2/input1.in"));
		BufferedWriter wr = new BufferedWriter(
				new FileWriter("/home/local/JASPERINDIA/gitanshu.behal/Desktop/Jam/1A/Q2/output1.out"));

		int testCases = Integer.parseInt(br.readLine());
		for (int I = 1; I <= testCases; I++) {

			int N = Integer.parseInt(br.readLine());
			int[] array = new int[2 * N * N];
			int[] flag = new int[3000];
			int J = 0;
			for (int i = 0; i < (2 * N - 1); i++) {
				String[] arr = br.readLine().split(" ");
				for (int j = 0; j < arr.length; j++) {
					array[J] = Integer.parseInt(arr[j]);
					if (flag[array[J]] == 0) {
						flag[array[J]] = 1;
					} else {
						flag[array[J]] = 0;
					}
					J++;
				}
			}
			Integer[] answer = new Integer[N];
			int K=0;
			for (int i = 1; i < 2501; i++) {
				if(flag[i] == 1){
					answer[K++] = i;
				}
			}
			Arrays.sort(answer);
			
			wr.write("Case #" + I + ": ");
			for(int i=0 ; i < answer.length; i++){
				wr.write(answer[i].toString() + " ");
			}
			wr.newLine();
		}
		wr.close();
	}
}
