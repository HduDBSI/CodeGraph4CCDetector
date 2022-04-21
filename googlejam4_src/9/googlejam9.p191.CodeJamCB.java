package googlejam9.p191;
import java.math.BigInteger;
import java.util.Scanner;

public class CodeJamCB {
	public static void main(String []args){
		Scanner reader = new Scanner(System.in);
		int g = reader.nextInt();
		for(int k=0;k<g;k++){
			int b = reader.nextInt();
			long m = reader.nextLong();
			BigInteger c = new BigInteger(m+"");
			BigInteger two = new BigInteger("2");
			BigInteger rez = two.pow(b-2);
			if(rez.compareTo(c)<0){
				System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
			}
			else{
				System.out.println("Case #"+(k+1)+": POSSIBLE");
				BigInteger e = new BigInteger(m+"");
				int max = lo(m)+1;
				int [][] t = new int[b][b];
				for(int i=0;i<=max;i++){
					for(int j=i+1;j<=max;j++){
						t[i][j] = 1;
					}
				}
				
				while(m>0){
					if(m==1){
						t[0][b-1] = 1;
						m--;
					}
					else{
						int log = lo(m)+1;
						t[log][b-1] = 1;
						m-= Math.pow(2, log-1);
					}
				}
				for(int i=0;i<b;i++){
					t[b-1][i] = 0;
				}
				
				
				for(int i=0;i<t.length;i++){
					for(int j=0;j<t.length;j++){
						System.out.print(t[i][j]);
					}
					System.out.println();
				}
			}
		}
		
		
		reader.close();
	}
	public static int lo(long a){
		double c = (double) a;
		double rez = Math.log(c)/Math.log(2);
		return (int) rez;
	}
}
