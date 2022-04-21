package googlejam1.p693;
import java.util.Scanner;


public class codjamr11 {
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int k=0;k<t;k++){
			int n=s.nextInt(),ans1=0,ans2=0,max=0;
			int a[]=new int[n];

			for(int i=0;i<n;i++){
				a[i]=s.nextInt();

			}
			for(int i=0;i<n;i++){
				if(i<n-1 && (a[i]-a[i+1])>max)
					max=a[i]-a[i+1];
			}
			//	System.out.println(max);
			for(int i=0;i<n-1;i++){
				if(a[i+1]<a[i]){
					ans1+=a[i]-a[i+1];
				}
				ans2+=Math.min(a[i],max);
			}
			//ans2-=a[n-1];
			System.out.println("Case #"+(k+1)+": "+ans1+" "+ans2);
		}
	}
}
