package googlejam6.p417;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RankFile {
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new File("largeout.txt"));
		int t = in.nextInt();
		for(int i = 0;i<t;i++){
			int n = in.nextInt();
			int[] tracker = new int[2501];
			int end = (2*n-1)*n;
			int k;
			for(int j = 0;j<end;j++){
				k = in.nextInt();
				tracker[k] = (++tracker[k])%2;
			}
			out.print("Case #" + (i+1) + ":");
			for(int j = 0;j<2501;j++){
				if(tracker[j]!=0){
					out.print(" " + j);
				}
			}
			out.print("\n");
		}
		out.close();
	}
}
