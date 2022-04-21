package googlejam6.p586;
import java.util.Arrays;
import java.util.Scanner;


public class round1ad {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int i=0; i<t; i++) {
			int n = s.nextInt();
			int a[] = new int[3000];
			for(int j=0; j<3000; j++) {
				a[j]=0;
			}
			for(int j=0; j<n*((2*n)-1); j++) {
				int x = s.nextInt();
				a[x]++;
			}
			int y[] = new int[n];
			int count=0;
			for(int j=0; j<3000; j++) {
				if(a[j]%2==1) {
					y[count]=j;
					count++;
				}
			}
			Arrays.sort(y);
			System.out.print("Case #" + (i+1) + ": ");
			for(int j=0; j<n; j++) {
				System.out.print(y[j] + " ");
			}
			System.out.println();
		}
	}

}
