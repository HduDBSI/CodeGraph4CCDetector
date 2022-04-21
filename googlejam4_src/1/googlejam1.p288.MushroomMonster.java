package googlejam1.p288;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class MushroomMonster {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/e/Downloads/A-large.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("/home/e/Documents/MushroomMonster.out"));
		int times = Integer.parseInt(br.readLine());
		for(int t = 1; t <= times; t++) {
			int[] mushrooms = new int[Integer.parseInt(br.readLine())];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;  i < mushrooms.length; i++) {
				mushrooms[i] = Integer.parseInt(st.nextToken());
			}
			int firstComputation = 0;
			for(int i = 0; i < mushrooms.length-1; i++) {
				if(mushrooms[i+1] < mushrooms[i]) {
					firstComputation += mushrooms[i] - mushrooms[i+1];
				}
			}
			int secondComputation = 0;
			int largestGap = 0;
			for(int i = 0; i < mushrooms.length-1; i++) {
				if(mushrooms[i] - mushrooms[i+1] > largestGap) {
					largestGap = mushrooms[i]-mushrooms[i+1];
				}
			}
			for(int i = 0; i < mushrooms.length-1; i++) {
				if(mushrooms[i] > largestGap) {
					secondComputation += largestGap;
				}
				else {
					secondComputation += mushrooms[i];
				}
			}
			bw.write("Case #" + t + ": " + firstComputation + " " + secondComputation + "\n");
		}
		br.close();
		bw.close();
	}
}
