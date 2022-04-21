package googlejam9.p165;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("D:/GCJ2016/B/B-large.in"));
		FileWriter writer = new FileWriter("D:/GCJ2016/B/B-large.out", false);
		int cases = scanner.nextInt();
		for(int i=0;i<cases;i++){	
			int br = scanner.nextInt();
			long cr = scanner.nextLong();
			writer.write("Case #"+(i+1)+": ");
			long rc = br-2;
			long maximu = 1;
			while(rc>0){
				maximu *= 2;
				rc--;
			}
			if(maximu >= cr){
				writer.write("POSSIBLE");
				long needMinus = maximu-cr;
				long[][] arr = new long[br][br];
				for(int j=0;j<br;j++){
					Arrays.fill(arr[j], 0);
				}
				if(cr == 0){	
				}
				else{
					for(int j=0;j<br;j++){
						for(int k=0;k<br;k++){
							if(k>j){
								arr[j][k] = 1;
							}
						}
					}
					if(maximu == cr){
					}
					else{
						
						long[] arraywith = new long[br-2];
						Arrays.fill(arraywith, 0);
						long cn = 1;
						for(int j=br-3;j>=0;j--){
							cn*=2;
							arraywith[j] = cn/2;
						}	
						for(int l=0;l<br-2;l++){
							if(needMinus >= arraywith[l]){
								needMinus -= arraywith[l];
								arr[0][l+1] = 0;
							}
						}
					}
				}
				writer.append('\r');
				writer.append('\n');
				for(int j=0;j<br;j++){
					for(int k=0;k<br;k++){
						System.out.print(arr[j][k]+"");
						writer.write(arr[j][k]+"");
					}
					System.out.println("");
					writer.append('\r');
					writer.append('\n');
				}
			}
			else{
				writer.write("IMPOSSIBLE");
				writer.append('\r');
				writer.append('\n');
			}
		}
		scanner.close();
		writer.close();
	}
}
