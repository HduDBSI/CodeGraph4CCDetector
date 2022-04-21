package googlejam6.p404;





















import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.*;
import java.text.*;

public class B {

	public static void main(String[] args) throws Exception{

		Scanner scanner = new Scanner(new File("B-large.in"));

		int cases = scanner.nextInt();

		for (int t = 0; t < cases; t++) {
			int rows = scanner.nextInt();
			int[] nums = new int[2501];
			String output = "";

			for (int r = 0; r < 2*rows - 1; r++) {
				for (int k = 0; k < rows; k++){
					int currnum = scanner.nextInt();
					nums[currnum]++;
				}
			}

			for (int i = 0; i < nums.length; i++) {
				if ((nums[i] % 2) != 0) {
					output += " " + Integer.toString(i);
				}
			}

			System.out.printf("Case #%d:%s\n", t + 1, output);
		}
	}
}