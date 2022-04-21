package googlejam6.p162;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeJam2016R1AP2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int caseid=1; caseid<=T; caseid++)
		{
			int N = Integer.parseInt(br.readLine());
			int[] count = new int[2501];
			for(int i = 0; i < 2*N -1;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					int c = Integer.parseInt(st.nextToken());
					count[c]++;
				}
			}			
			System.out.print("Case #"+caseid + ":");
			int counter = 0;
			for(int i = 0; i < 2501; i++) {
				
				if(count[i] % 2 ==1) {
					counter++;
					System.out.print(" "+i);
				}
			}
			System.out.println();
			if(counter != N) System.out.println("WJDALSKDJALKSDJAS");
		}
	}

}
