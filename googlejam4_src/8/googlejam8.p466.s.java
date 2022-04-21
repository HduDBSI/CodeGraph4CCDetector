package googlejam8.p466;
import java.util.*;
import java.io.*;

public class s{
	public static void main(String args[]){
		Scanner in = new Scanner (new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int re[] = new int[27];
		int n = 0;
		int max1 = 0;
		int maxf1 = 0;
		int max2 = 0;
		int maxf2 = 0;
		int sum = 0;
		int temp = 'A' - 1;
		for (int i = 1; i <= t; i++){
			n = in.nextInt();
			Arrays.fill(re, 0);
			max1 = 0;
			maxf1 = 0;
			max2 = 0;
			maxf2 = 0;
			sum = 0;
			System.out.print("Case #" + i +": ");
			for (int j = 1; j <= n; j++){
				re[j] = in.nextInt();
				sum += re[j];
				if (max1 <= re[j]) {
					max2 = max1;
					maxf2 = maxf1;
					max1 = re[j];
					maxf1 = j;
				}
			}
			if (maxf1 == 1){
				for (int j = 2; j <= n; j++){
				if (max2 <= re[j]) {
					max2 = re[j];
					maxf2 = j;
				}
			}
			}
			while(sum != 0){
				if (sum != 3){
					re[maxf1]--;
					max1--;
					System.out.printf("%c" ,(maxf1 + temp));
					if (max1 >= max2){
						re[maxf1]--;
						max1--;
						System.out.printf("%c ",(maxf1 + temp));
						}
					else{
						re[maxf2]--;
						max2--;
						System.out.printf("%c ", (maxf2 + temp));
					}
					sum -= 2;
				}
				else {sum--;
					re[maxf1]--;
					max1--;
					System.out.printf("%c ", (maxf1 + temp));
				}
				for (int j = 1; j <= n; j++){
					if (max1 <= re[j] && maxf1 != j) {
					max2 = max1;
					maxf2 = maxf1;
					max1 = re[j];
					maxf1 = j;
					}
				}
			}
			System.out.println();
		}
	}	
}