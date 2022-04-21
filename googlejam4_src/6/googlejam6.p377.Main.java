package googlejam6.p377;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Sagar
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1 ; i <= t; i++){
			int n = in.nextInt();
			int[] a = new int[n*(n+(n-1))];
			for(int j = 0; j < n*(n+(n-1)); j++){
				a[j] = in.nextInt();
			}
			Arrays.sort(a);
			System.out.print("Case #" + i + ": " );
			for(int j=0; j < n*(n+(n-1));){
				if((j+1) != n*(n+(n-1)) && a[j] == a[j+1]){
					j+=2;
				}else{
					System.out.print(a[j] + " ");
					j++;
				}
			}
			System.out.println();
		}
		in.close();
		
	}

}
