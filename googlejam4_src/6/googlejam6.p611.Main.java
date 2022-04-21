package googlejam6.p611;
import java.util.Scanner;
import java.util.Arrays;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c=1;c<=cases;c++){
			int n = sc.nextInt();
			int[] heights = new int[2501];
			for(int i=0;i<2*n-1;i++){
				for(int j=0;j<n;j++){
					heights[sc.nextInt()]++;
				}
			}
			System.out.printf("Case #%d:",c);
			for(int i=0;i<2501;i++) if(heights[i]%2!=0) System.out.print(" "+i);
			System.out.println();		
		}
	}

}