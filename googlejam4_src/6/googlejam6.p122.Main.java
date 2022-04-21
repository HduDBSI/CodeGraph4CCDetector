package googlejam6.p122;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	static FileReader fr;
	static Scanner sc;
	static FileWriter fw;

	public static void main(String[] args) throws IOException {
		fr = new FileReader("B-large.in");
		fw = new FileWriter("output.txt");
		sc = new Scanner(fr);
		sc.useLocale(Locale.US);

		int t = sc.nextInt();
		sc.nextLine();

		for (int i=1; i<=t; i++) {
			String str = "Case #"+i+": ";
			System.out.print(str);
			fw.write(str);
			int n = sc.nextInt();
			int heights[] = new int[2501];
			
			for (int l=0; l<2*n-1; l++) {
				for (int i1=0; i1<n; i1++) {
					int height = sc.nextInt();
					heights[height]++;
				}
			}
			
			boolean first = true;
			for (int height=0; height<heights.length; height++) {
				if (heights[height] % 2 != 0) {
					if (!first) {
						System.out.print(" ");
						fw.write(" ");
					}
					String str2 = height+"";
					System.out.print(str2);
					fw.write(str2);
					first = false;
				}
			}
			String str1 = "" + "\n";
			System.out.print(str1);
			fw.write(str1);
		}

		sc.close();
		fw.close();
		fr.close();
	}
}
