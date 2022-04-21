package googlejam8.p064;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SenateEvacuation {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		final StringBuilder[] results = new StringBuilder[T];
		for (int testcase = 1; testcase <= T; testcase++) {

			int N = Integer.parseInt(bf.readLine());
			int[] counts = new int[N];
			String[] line = bf.readLine().split(" ");
			int sum = 0;
			for(int i=0; i < N; i++){
				counts[i] = Integer.parseInt(line[i]);
				sum += counts[i];
			}
			
			StringBuilder output = new StringBuilder();
			// greedy
			while(sum != 3 && sum != 0){
				int firstMax = 0;
				int secondMax = 0;
				int firstMaxIdx = -1;
				int secondMaxIdx = -1;
				
				for(int i=0; i < N; i++){
					if(counts[i] > firstMax){
						firstMax = counts[i];
						firstMaxIdx = i;
					}
				}
				counts[firstMaxIdx]--;
				for(int i=0; i < N; i++){
					if(counts[i] > secondMax){
						secondMax = counts[i];
						secondMaxIdx = i;
					}
				}
				counts[secondMaxIdx]--;
				
				
				char firstChar = (char) ('A' + firstMaxIdx);
				char secondChar = (char) ('A' + secondMaxIdx);
				sum -= 2;
				output.append(firstChar + "" + secondChar + " ");
			}
			
			if(sum == 3){
				int max = 0;
				int maxIdx = -1;
				
				for(int i=0; i < N; i++){
					if(counts[i] > max){
						max = counts[i];
						maxIdx = i;
					}
				}
				
				counts[maxIdx]--;
				sum--;
				char maxChar = (char) ('A' + maxIdx);
				output.append(maxChar + " ");
				

				for(int i=0; i < N; i++){
					if(counts[i] > 0){
						char lastChar = (char)('A' + i);
						output.append(lastChar);
					}
				}
			}
			
			results[testcase - 1] = output;

		}

		for (int testcase = 1; testcase <= T; testcase++) {
			System.out.println("Case #" + testcase + ": "
					+ results[testcase - 1].toString());
		}
	}

}
