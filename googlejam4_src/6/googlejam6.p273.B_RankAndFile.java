package googlejam6.p273;
import java.util.Scanner;


public class B_RankAndFile {
public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	int t,n,min ,max;
	t=sc.nextInt();
	int arr[];
	int ans[];
	for(int i=1;i<=t;i++){
		n=sc.nextInt();
		arr=new int[2501];
		min=Integer.MAX_VALUE;
		max=Integer.MIN_VALUE;
		for(int j=0;j<(2*n-1);j++){
			for(int k=0;k<n;k++){
				int x=sc.nextInt();
				arr[x]++;
				min=Math.min(min,x);	 
				max=Math.max(max,x);
			}
		}
		//System.out.println(min+" "+max);
		ans=new int[n];
		for(int k=min,l=0;k<=max;k++){
			if(arr[k]%2!=0){
				ans[l]=k;
				l++;
			}
		}
		System.out.print("Case #"+i+": ");
		for(int k=0;k<n;k++){
			System.out.print(ans[k]+" ");
		}
		System.out.println();
					
	}
	
	
	sc.close();
}
}
