package googlejam8.p933;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Sagar
 *
 */
public class GCJ16R1CA {



	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1 ; i <= t; i++){
			int n = in.nextInt();
			int a[] = new int[26];
			int p[] = new int[n];
			int total = 0;
			for(int j = 0; j<n;j++){
				p[j] = in.nextInt();
				total += p[j];
			}
			System.out.print("Case #" + i + ": ");
			while(total > 0){
				int max1 = 0;
				int max2 = 0;
				int max3 = 0;
				for(int j = 1 ;j<n;j++){
					if(p[j] >= p[max1]){
						max3 = max2;
						max2 = max1;
						max1 = j;
					} else if(p[j] >= p[max2]){
						max3 = max2;
						max2 = j;
					} else if(p[j] >= p[max3]){
						max3 = j;
					}
				}
				if((p[max1] - 2)< total/2 && p[max2] < total /2 && p[max3] < total/2){
					System.out.print("" + (char)('A' + max1) + (char)('A' + max1) + " ");
					total -= 2; 
					p[max1] -= 2;
				} else if((p[max1] - 1) < total/2 && (p[max2] - 1) < total/2 && p[max3] < total/2) {
					System.out.print("" + (char)('A' + max1) + (char)('A' + max2) + " ");
					total -= 2;
					p[max1] -= 1;
					p[max2] -= 1;
				} else if(p[max1] == p[max2] && p[max3] == p[max2] && max1 != max2 && max2 != max3) {
					System.out.print("" + (char)('A' + max3) + " ");
					total -= 1;
					p[max3] -= 1;
				} else {
					System.out.print("" + (char)('A' + max1) + (char)('A' + max2) + " ");
					total -= 2;
					p[max1] -= 1;
					p[max2] -= 1;
				}
			}
			System.out.println();
		}
		in.close();
	}

}
