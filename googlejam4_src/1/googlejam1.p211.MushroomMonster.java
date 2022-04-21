package googlejam1.p211;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MushroomMonster {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
		int cases = Integer.parseInt(br.readLine());
		for(int i =0; i<cases; i++){
			int numTimes = Integer.parseInt(br.readLine());
			String[] nums = br.readLine().split(" ");
			int[] shrooms = new int[numTimes];
			for(int j = 0; j < numTimes; j++) {
				shrooms[j] = Integer.parseInt(nums[j]);
			}
			int maxDecrease = 0;
			int case1shrooms = 0;
			int case2shrooms = 0;
			for(int j = 1; j < numTimes; j++) {
				int diff = shrooms[j-1]-shrooms[j];
//				System.out.println(diff);
				if(diff > 0) {
					case1shrooms += diff;
				}
				if(diff > maxDecrease) {
					maxDecrease = diff;
				}
			}
//			System.out.println(maxDecrease);
			for(int j = 0; j < numTimes-1; j++) {
				if(shrooms[j] < maxDecrease) {
					case2shrooms += shrooms[j];
				} else {
					case2shrooms += maxDecrease;
				}
			}
			System.out.println("Case #" + (i+1) +  ": " + case1shrooms + " " + case2shrooms);
		}
	}
}
