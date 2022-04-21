package googlejam1.p257;
import java.util.*;
public class cj_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int t=0;
		while(t<n){
			t++;
			long result=0;
			long result2=0;
			long maxDis=0;
			int n1=sc.nextInt();
			long[] a=new long[n1];
			for(int i=0;i<n1;i++)
				a[i]=sc.nextInt();
			for(int i=1;i<n1;i++)
				if(a[i]<a[i-1])
					result+=a[i-1]-a[i];
			for(int i=0;i<n1-1;i++)
				maxDis=Math.max(a[i]-a[i+1],maxDis);
			for(int i=0;i<n1-1;i++)
				result2+=Math.min(maxDis, a[i]);
			System.out.println("Case #"+t+": "+result+" "+result2);
		}
	}

}
