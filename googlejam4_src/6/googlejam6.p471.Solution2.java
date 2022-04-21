package googlejam6.p471;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for(int i=0; i<t; i++){
			int n=scanner.nextInt();
			int[] ht = new int[2501];
			for(int x=0; x<n; x++){
				for(int y=0; y<(2*n-1); y++){
					ht[scanner.nextInt()]++;
				}
			}
			System.out.print("Case #"+(i+1)+": ");
			for(int j=1; j<ht.length; j++){
				if(ht[j]<1 || ht[j]%2==0){
					continue;
				}
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
	}
}
