package googlejam1.p337;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.nextLine();
		for (int i = 0; i < num; ++i) {
			int currNum = in.nextInt();
			in.nextLine();
			int[] arr = new int[currNum];
			for (int j = 0; j < currNum; ++j) arr[j] = in.nextInt();
			int first = 0;
			for (int j = 1; j < currNum; ++j) {
				if (arr[j - 1] > arr[j]) first += arr[j - 1] - arr[j];
			}
			int second = 0;
			int speed = 0;
			for (int j = 0; j < currNum - 1; ++j) speed = Math.max(speed, arr[j] - arr[j + 1]);
			for (int j = 0; j < currNum - 1; ++j) {
				if (arr[j] <= speed) second += arr[j];
				else second += speed;
			}
			System.out.println("Case #" + (i + 1) + ": " + first + " " + second);
			in.nextLine();
		}
		in.close();

	}

}
