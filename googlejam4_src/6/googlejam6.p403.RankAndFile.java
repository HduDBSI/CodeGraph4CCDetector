package googlejam6.p403;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class RankAndFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fstream = new FileInputStream("B-large.in");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		File fout = new File("out.txt");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		int count = Integer.parseInt(br.readLine());
		for (int i = 1; i <= count; i++) {
			int lineNum = Integer.parseInt(br.readLine());
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < lineNum*2-1; j++) {
				Scanner scanner = new Scanner(br.readLine());
				while (scanner.hasNextInt()) {
					int height = scanner.nextInt();
					if (set.contains(height)) {
						set.remove(height);
					} else {
						set.add(height);
					}
				}
			}
			int[] arr = new int[lineNum];
			int k = 0;
			for (int height : set) {
				arr[k++] = height;
			}
			Arrays.sort(arr);
			bw.write("Case #" + i + ": ");
			for (k = 0; k < lineNum; k++) {
				bw.write(arr[k] + " ");
			}
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}
