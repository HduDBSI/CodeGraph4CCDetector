package googlejam6.p156;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class B {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("b.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("b.out"));
		int T = s.nextInt();
		for (int i = 1; i <= T; i++) {
			out.write("Case #"+i+":");
			int N = s.nextInt();
			boolean[] heights = new boolean[2501];
			for(int j=0; j<2*N-1; j++){
				for(int k=0; k<N; k++){
					int h = s.nextInt();
					heights[h]=!heights[h];
				}
			}
			for(int j=0; j<2500; j++){
				if(heights[j]){
					out.write(" "+j);
				}
			}
			out.write("\n");
		}
		out.close();	
	}
}
