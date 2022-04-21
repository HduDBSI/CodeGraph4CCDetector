package googlejam6.p269;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class B {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(new File("in.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.setOut(new PrintStream(new File("out.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		for (int c = 0; c < t; c++) {
			int n = s.nextInt();
			int[] good = new int[3000];
			for (int i = 0;i < 2 * n * (n-1) + n; i++) {
				int aa = s.nextInt();
				good[aa]++;
				//System.out.println(aa);
			}
			//System.out.println(Arrays.toString(good));
			StringBuilder sb = new StringBuilder();
			sb.append("Case #" + (c + 1) + ":");
			for (int i = 0;i < good.length; i++) {
				if (good[i] % 2 == 1) {
					sb.append(" " + i);
				}
			}
			System.out.println(sb);
		}
	}
}
