package googlejam8.p319;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SenateEvacuation {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("/Users/alexpeptan/Desktop/Eclipse Workspace/Google Code Jam 2016/src/round1C_Problem1/1C1.out", "UTF-8");
		Scanner scanner = new Scanner(new File("/Users/alexpeptan/Desktop/Eclipse Workspace/Google Code Jam 2016/src/round1C_Problem1/1C1.in"));
		
		int t = scanner.nextInt();
		
		int max = 0;
		
		for(int k=0; k<t; k++){
			int n = scanner.nextInt();
			char[] names = new char[n];
			for(int i=0; i<n; i++){
				names[i] = (char)('A' + i);
			}
			
			int[] cnt = new int[n];
			
			for(int i=0; i<n; i++){
				cnt[i] = scanner.nextInt();
			}
			
			// sort
			for(int i=0; i<n-1; i++){
				for(int j=i+1; j<n; j++){
					if(cnt[i] > cnt[j]){
						int aux = cnt[i];
						cnt[i] = cnt[j];
						cnt[j] = aux;
						aux = names[i];
						names[i] = names[j];
						names[j] = (char)aux;
					}
				}
			}
			
			writer.print("Case #" + (k+1) + ":");
			
			int delta = cnt[n-1] - cnt[n-2];
			for(int i=0; i<delta; i++){
				writer.print(" " + names[n-1]);
			}
			
			for(int party = 0; party <= n-3; party++){
				for(int j=0; j<cnt[party]; j++){
					writer.print(" " + names[party]);
				}
			}
			
			for(int i=0; i<cnt[n-2]; i++){
				writer.print(" " + names[n-2] + names[n-1]);
			}
			
			writer.println();
		}
		writer.close();
	}

}
