package googlejam8.p845;
import java.util.Scanner;

public class codejam {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp=tc;
		while(tc--!=0) {
			int n = in.nextInt();
			int a[] = new int[n];
			String s = "";
			for(int i=0;i<n;i++) {
				a[i] = in.nextInt();
			}
			while(true) {
			
			int m1=0;int m2=-1;
			for(int i=1;i<n;i++) {
				if(a[i]>a[m1]) {
					m1=i;
				}
			}
			for(int i=0;i<n;i++) {
				if(a[i]==a[m1]&&m1!=i) {
					m2=i;
				}
			}
			s=s+(char)(65+m1);
			a[m1]--;
			int count = 0;
			for(int i=0;i<n;i++) {
				if(a[i]==1) {
					count++;
				}
				if(a[i]!=1&&a[i]!=0) {
					count+=3;
				}
				
			}
			if(m2!=-1&&count==2) {
				s=s+(char)(65+m2);
				a[m2]--;
			}
			s=s+" ";
			boolean flag = true;
			for(int i=0;i<n;i++) {
				if(a[i]!=0) {flag = false; break;}
			}
			if(flag) break;
			}
			System.out.println("Case #"+(temp-tc)+": "+s);
		}
		in.close();
	}
	
}


