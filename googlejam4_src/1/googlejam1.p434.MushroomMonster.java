package googlejam1.p434;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class MushroomMonster {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("A-large.in"));//C-small-practice.in
		PrintWriter out = new PrintWriter("out.txt");
		int T = in.nextInt();
		for(int i=1;i<=T;i++){
			int N = in.nextInt();
			int[] num = new int[N];
			for(int j=0;j<N;j++){
				num[j] = in.nextInt();
			}
			int res = 0;
			for(int i1=1;i1<num.length;i1++){
				if(num[i1]<num[i1-1]){
					res+=num[i1-1]-num[i1];
				}
			}
			int res1 = res;
			int res3 = 0;
			int speed=0;
			for(int i2=1;i2<num.length;i2++){
				speed=Math.max(speed, num[i2-1]-num[i2]);
			}
			for(int i1=1;i1<num.length;i1++){
				res3+=Math.min(speed, num[i1-1]);
			}
			int res2 = res3;
			out.println("Case #"+i+": "+res1+" "+res2);
		}
		out.close();
		in.close();
	}

}
