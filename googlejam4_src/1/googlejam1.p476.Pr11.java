package googlejam1.p476;
import java.util.Scanner;


public class Pr11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int N, max, inc;
		long min1, min2;
		int[] m;
		for(int t=1; t<=T; t++){
			N = s.nextInt();
			m = new int[N];
			max = 0;
			min1 = 0;
			min2 = 0;
			for(int i=0; i<N; i++){
				m[i] = s.nextInt();
				if(i>0){
					if(m[i-1]>m[i]){
						min1 = min1 + m[i-1] - m[i];
						if((m[i-1]-m[i])>max) max = m[i-1] - m[i];
					}
				}
			}
			if(max == 0) System.out.println("Case #"+t+": "+min1+" 0");
			else{
				if((max%10) == 0) inc = max/10;
				else inc = max/10 +1;
				for(int i=1; i<N; i++){
					if(max>m[i-1]) min2 += m[i-1];
					else min2 += max;
				}
				System.out.println("Case #"+t+": "+min1+" "+min2);
			}
		}
	}

}
