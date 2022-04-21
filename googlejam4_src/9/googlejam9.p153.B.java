package googlejam9.p153;
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
		for (int t = 1; t <= T; t++) {
			out.write("Case #"+t+": "); 
			int B  = s.nextInt();
			int M = s.nextInt();
			int magicNumber = (B*B-B)/2;
			matrix = new boolean[B][B];
			int magicLimit = 1<<magicNumber;
			boolean foundAnswer=false;
			for(int magic=0; magic<magicLimit && !foundAnswer; magic++){
				int it=0;
				for(int j=0; j<B; j++){
					for(int k=j+1; k<B; k++){
						matrix[j][k]=(magic>>it++)%2==1;
					}
				}
				
				cant = new int[B];
				cant[B-1]=1;
				for(int i=B-2; i>=0; i--){
					for(int j=0; j<B; j++){
						if(matrix[i][j])
							cant[i]+=cant[j];
					}
				}
				if(cant[0]==M){
					foundAnswer=true;
					out.write("POSSIBLE\n");
					for(int i=0; i<B; i++){
						for(int j=0; j<B; j++){
							if(matrix[i][j]){
								out.write("1");
							}else{
								out.write("0");
							}
						}
						out.write("\n");
					}
				}
			}
			if(!foundAnswer){
				out.write("IMPOSSIBLE\n");
			}
		}
		out.close();
	}
	
	static boolean[][] matrix;
	static int[] cant;
}
