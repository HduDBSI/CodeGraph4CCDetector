package googlejam1.p569;
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		File file = new File("A-large.in");
		try {
			Scanner sc = new Scanner(file);

			int numOfTests = sc.nextInt();

			for (int i = 1; i < numOfTests + 1; i++) {
				int numOfPlates = sc.nextInt();
				int[] arr = new int[numOfPlates];

				for (int j = 0; j < arr.length; j++) {
					arr[j] = sc.nextInt();
				}

				int method1 = 0;

				for (int j = 0; j < arr.length - 1; j++) {
					if (arr[j+1] < arr[j]) {
						method1 += (arr[j] - arr[j+1]);
					}
				}

				int method2 = 0;

				int slope = Integer.MIN_VALUE;

				for (int j = 0; j < arr.length - 1; j++) {
					if ((arr[j] - arr[j + 1]) > slope) {
						slope = arr[j] - arr[j+1];
					}
				}

				for (int j = 0; j < arr.length -1; j++) {
					if (arr[j] <= slope) {
						method2 += arr[j];
					} else {
						method2 += slope;
					}
				}

				System.out.println("Case #" + i + ": " + method1 + " " + method2);
			}
		} 
		catch (Exception e) {

		}
	}
}