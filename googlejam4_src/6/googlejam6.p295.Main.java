package googlejam6.p295;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		PrintWriter writer = new PrintWriter("output", "UTF-8");
		int T = input.nextInt();
		for(int i = 1; i <= T; i++){
			int N = input.nextInt();
			// read each line
			boolean line[] = new boolean[2501];
			for(int j = 0; j < line.length; j++) line[j] = true;// true means even
			for(int j = 0; j < 2 * N - 1; j++){
				// read each int
				for(int k = 0; k < N; k++){
					int n = input.nextInt();
					line[n] = (line[n] == false);// flip the value
				}
				
			}
			writer.print("Case #" + i + ":");
			for(int j = 1; j < line.length; j++){
				if(line[j] == false) writer.print(" " + j);
			}
			writer.println();
		}
		input.close();
		writer.close();
	}
}
