package googlejam9.p127;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class R1C_B_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("D:/ForPrograms/java/TESTS/B-large.in"));
		FileWriter writer = new FileWriter("D:/ForPrograms/java/TESTS/B-large.out", false);
		
		int cases = scanner.nextInt();
		
		
		for(int i=0;i<cases;i++){
			
			int b = scanner.nextInt();
			long c = scanner.nextLong();
			
			writer.write("Case #"+(i+1)+": ");
			
			long rc = b-2;
			long maxCount = 1;
			while(rc>0){
				maxCount *= 2;
				rc--;
			}
			
			
			
			
			if(maxCount >= c){
				writer.write("POSSIBLE");
				
				long needMinus = maxCount-c;
				
				long[][] arr = new long[b][b];
				for(int j=0;j<b;j++){
					Arrays.fill(arr[j], 0);
				}
				
				if(c == 0){
					
				}
				else{
					
					for(int j=0;j<b;j++){
						for(int k=0;k<b;k++){
							if(k>j){
								arr[j][k] = 1;
							}
						}
					}
					
					if(maxCount == c){
						
					}
					else{
						
						long[] arrm = new long[b-2];
						Arrays.fill(arrm, 0);
						long cn = 1;
						for(int j=b-3;j>=0;j--){
							cn*=2;
							arrm[j] = cn/2;
						}
						//arrm[b-2] = 1;
						
						
						for(int l=0;l<b-2;l++){
							if(needMinus >= arrm[l]){
								needMinus -= arrm[l];
								arr[0][l+1] = 0;
							}
						}
					
					}
					
					
					
				}
				writer.append('\r');
				writer.append('\n');
				for(int j=0;j<b;j++){
					for(int k=0;k<b;k++){
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
			
			
			
			//writer.append('\r');
			//writer.append('\n');
			
			
			/*if(i != cases-1)
				scanner.nextLine();*/
	
		}
		
		
		scanner.close();
		writer.close();
		
		
	}

}
