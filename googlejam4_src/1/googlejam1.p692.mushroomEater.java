package googlejam1.p692;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class mushroomEater {
	private static Scanner sc;
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("/Users/mac/Desktop/A-large.in"));
		PrintStream out = new PrintStream(new FileOutputStream("/Users/mac/Desktop/output.txt"));
		System.setOut(out);
		int cases = Integer.parseInt(sc.nextLine());
		for (int i=1;i<=cases; i++){
			int N=sc.nextInt();
			int[] arr = new int[N];
			for(int j=0;j<N;j++){
				arr[j] = sc.nextInt();
			}
			int ans =0;
			for(int i1=1;i1<arr.length;i1++){
				
				if(arr[i1]<arr[i1-1]){
					ans = ans + (arr[i1-1]-arr[i1]);
				}
			}
			
			int mineater = ans;
			int n=arr.length;
			int rate = 0;
			for(int i2=n-1;i2>0;i2--){
				int temp = arr[i2-1]-arr[i2];
				//System.out.println(rate);
				if (temp>=0 && temp>rate)
					rate=temp;
			}
			
			int ans1 = 0;
			for (int i1=0;i1<n-1;i1++){
				
				if (arr[i1]<rate)
					ans1 = ans1 +arr[i1];
				else
					ans1 = ans1 + rate;
			}
			int constant = ans1;
			
			System.out.println("Case #" + i + ": " + mineater +" "+ constant);
		}
	
	}
	
}
