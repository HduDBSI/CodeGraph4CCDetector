package googlejam6.p063;
import java.util.Arrays;
import java.util.Scanner;

public class B {
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		int n;
				
		int tmp;
		
			
		for(int i=0; i<tc; ++i){
			n = sc.nextInt();
			
			int[] hei = new int[2501];
			
			int[] row = new int[n];
			
			for(int a=0; a<2*n-1; ++a){
				for(int b=0; b<n; ++b){
					tmp = sc.nextInt();
					hei[tmp]++;
				}
			}
			
			int pos = 0;
			
			for(int a=0; a<2501; ++a){
				if(hei[a] % 2 != 0){
					row[pos] = a;
					pos++;
				}
			}
			
			Arrays.sort(row);
			
			
			System.out.printf("Case #%d: ", i+1);
			
			for(int a=0; a<n-1; ++a){
				System.out.printf("%d ", row[a]);
			}
			System.out.printf("%d%n", row[n-1]);
		}
		
		sc.close();
	}
}

