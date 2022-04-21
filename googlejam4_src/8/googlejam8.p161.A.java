package googlejam8.p161;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class A {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("a.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("a.out"));
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			out.write("Case #"+t+": "); 
			int N = s.nextInt();
			int[] parties = new int[N];
			int sum=0;
			for(int i=0; i<N; i++){
				parties[i]=s.nextInt();
				sum+=parties[i];
			}
			while(sum>0){
				int differentParties=0;
				int max=0;
				int iMax=-1;
				for(int i=0; i<N; i++){
					if(parties[i]>0)
						differentParties++;
					if(parties[i]>max){
						max=parties[i];
						iMax=i;
					}
				}
				if(differentParties==2){
					for(int i=0; i<N; i++){
						if(parties[i]>0){
							out.write(""+(char)('A'+i));
							parties[i]--;
							sum--;
						}
					}
				}else{
					out.write(""+(char)('A'+iMax));
					parties[iMax]--;
					sum--;
				}
				out.write(" ");
			}
			out.write("\n");
		}
		out.close();	
	}
}
