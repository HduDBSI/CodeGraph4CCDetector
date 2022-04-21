package googlejam9.p054;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Slides {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		final StringBuilder[] results = new StringBuilder[T];
		for (int testcase = 1; testcase <= T; testcase++) {

			// hahahahaha, this reduces to printing a bitstring
			// that's really weird, eh?
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int B = Integer.parseInt(st.nextToken());
			long M = Long.parseLong(st.nextToken());

			StringBuilder output = new StringBuilder();
			
			long numBits = B - 2;
			long maxValue = 1L << numBits;
			if(M <= maxValue){
				output.append("POSSIBLE");
				int[][] adjMatrix = new int[B][B];
				for(int i=1; i < B -1; i++){
					// every bit connects to the end
					adjMatrix[i][B-1] = 1;
					// every bit connects to each lower bit
					for(int j=1; j < i; j++){
						adjMatrix[i][j] = 1;
					}
				}
				
				if(M == maxValue){
					// connect everything
					for(int i=1; i < B; i++){
						adjMatrix[0][i] = 1;
					}
				} else {
					// each entry (i+1) has exactly 2^i  paths leading from it, and they add summatively
					for(int i=0; i < numBits; i++){
						if((M & (1L << i)) > 0){
							adjMatrix[0][i+1] = 1;
						}
					}
				}
				
				for(int i=0; i < B; i++){
					output.append("\n");
					for(int j=0; j < B; j++){
						output.append(adjMatrix[i][j]);
					}
				}
			} else {
				output.append("IMPOSSIBLE");
			}
			
			results[testcase - 1] = output;

		}

		for (int testcase = 1; testcase <= T; testcase++) {
			System.out.println("Case #" + testcase + ": "
					+ results[testcase - 1].toString());
		}
	}

}
