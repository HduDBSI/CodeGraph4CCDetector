package googlejam1.p255;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Mushroom{
	static int[] arr = new int[1002];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for(int i = 1; i <= T; i++){
			int N = Integer.parseInt(br.readLine().trim());

			StringTokenizer st = new StringTokenizer(br.readLine());
			int maxDiff = 0;
			int methodA = 0;
			for(int j = 0; j < N; j++){
				arr[j] = Integer.parseInt(st.nextToken());
				if(j != 0 && arr[j] < arr[j-1]){
					methodA += (arr[j-1] - arr[j]);
					if(arr[j-1] - arr[j] > maxDiff)	maxDiff = arr[j-1] - arr[j];
				}
			}
			int methodB = 0;
			if(maxDiff != 0){
				for(int j = 0; j < N - 1; j++)
					methodB += Math.min(arr[j], maxDiff);
			}
			sb.append(String.format("Case #%d: %d %d\n", i, methodA, methodB));
		}

		System.out.print(sb);
		br.close();
	}



}