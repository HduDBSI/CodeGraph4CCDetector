package googlejam1.p667;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class MushroomMonster {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		FileReader fileReader = new FileReader("C:/Users/Lakjeewa/Desktop/A-large.in");

		BufferedReader br = new BufferedReader(fileReader);

		String line = br.readLine();

		int cases = Integer.parseInt(line);
		
		PrintWriter writer = new PrintWriter(
				"C:/Users/Lakjeewa/Desktop/A.out", "UTF-8");

		for (int i = 0; i < cases; i++) {

			int N = Integer.parseInt(br.readLine());

			String[] array = br.readLine().split(" ");
			int[] nums = new int[N];

			for (int j = 0; j < N; j++) {
				nums[j] = Integer.parseInt(array[j]);
			}

			int min = 0;
			int maxDif = 0;



			for (int j = 0; j < N - 1; j++) {

				int diff = nums[j] - nums[j + 1];

				if (diff > 0) {
					min = min + diff;
				}
				
				if(maxDif < diff){
					maxDif = diff;
				}
			}

			int total = 0;
			//double rate = maxDif * 1.0 / 10;
			
			int eaten = 0;

			for (int j = 0; j < N-1; j++) {
				
				int v = nums[j] - maxDif;
				if(v > 0){
					eaten = eaten + maxDif;
				}else{
					eaten = eaten + nums[j];
				}
			}
			
			

			//System.out.println("Case #" + (i + 1) + ": " + min + " " + eaten);
			writer.println("Case #" + (i + 1) + ": " + min + " " + eaten);
		}

		br.close();
		writer.close();
	}
}
