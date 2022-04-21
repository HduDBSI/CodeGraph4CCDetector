package googlejam8.p574;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Senate {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(
				new FileReader(new File("/Users/vaibhav/Documents/workspace/test/data/input.txt")));
		int n = Integer.parseInt(br.readLine());
		char[] alpha = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		for (int i = 0; i < n; i++) {
			int[] list = new int[Integer.parseInt(br.readLine())];
			String[] nums = br.readLine().split(" ");
			for (int j = 0; j < nums.length; j++) {
				list[j] = Integer.parseInt(nums[j]);
			}
			
			System.out.print("Case #" + (i + 1) + ": ");
			while (true) {
				StringBuffer out = new StringBuffer();
				int index = 0;
				for (int j = 1; j < list.length; j++) {
					if (list[index] < list[j]) {
						index = j;
					}
				}
				if (list[index] < 1) {
					System.out.println();
					break;
				}
				list[index]--;
				out.append(alpha[index]);
				
				index = 0;
				for (int j = 1; j < list.length; j++) {
					if (list[index] < list[j]) {
						index = j;
					}
				}
				if (list[index] < 1) {
					System.out.println(out + " ");
					break;
				}
				if(list[index] == 1) {
					int sum = 0;
					for (int j = 0; j < list.length; j++) {
						sum = sum + list[j];
					}
					if(sum == 2) {
						System.out.print(out + " ");
						continue;
					}
				}
				list[index]--;
				out.append(alpha[index]);

				System.out.print(out + " ");
			}

		}

		br.close();

	}

}
