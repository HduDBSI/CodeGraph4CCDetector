package googlejam9.p051;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		/*
		BigInteger[] ways = new BigInteger[50];
		for(int i =0; i<50; i++){
			ways[i] = new BigInteger("0");
		}
		ways[0] = new BigInteger("1");
		for(int i = 1; i<50; i++){
			for(int j =0; j<i; j++){
				ways[i]=ways[i].add(ways[j]);
			}
			System.out.println(ways[i].toString());
		}
		*/
		Scanner in = new Scanner(System.in);
		long max = (1L<<48);
		int cases=in.nextInt();
		for(int q=1; q<=cases;q++){
			int builds = in.nextInt();
			long ways = in.nextLong();
			long max2 = (1L<<(builds-2));
			if(ways>max2){
				System.out.println("Case #"+q+": IMPOSSIBLE");
			}
			else{
				System.out.println("Case #"+q+": POSSIBLE");
				String[] strings = new String[builds];
				Arrays.fill(strings, "");
				for(int i =0; i<builds;i++){
					for(int j = 0;j<=i;j++){
						strings[i]+="0";
					}
					for(int j = i+1;j+1<builds;j++){
						strings[i]+="1";
					}
				}
				for(int i = builds-2;i>=0;i--){
					long can = 1;
					if(i>0){
						can = (1L<<i-1);
					}
					if(can<=ways){
						ways-=can;
						strings[i]+="1";
					}
					else{
						strings[i]+="0";
					}
				}
				for(int i =0;i<builds; i++){
					System.out.println(strings[i]);
				}
			}
		}
	}
}
