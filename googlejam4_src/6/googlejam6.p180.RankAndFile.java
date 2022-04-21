package googlejam6.p180;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RankAndFile {

	private static final int MAX_HEIGHT = 2501;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			boolean[] odd = new boolean[MAX_HEIGHT]; 
			for(int j = 0; j < 2*n-1; j++){
				for(int k = 0; k < n; k++){
					int h = in.nextInt();
					odd[h] = !odd[h];
				}
			}
			
			String answer = "";
			
			for(int j = 1; j < MAX_HEIGHT; j++){
				if(odd[j]){
					answer+=j+" ";
				}
			}
			System.out.println("Case #" + i + ": "+answer.substring(0, answer.length()-1));
		}

		in.close();
	}
	
}
