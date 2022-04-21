package googlejam1.p525;
import java.util.*;
import java.io.*;
public class A {
	public static void main(String... args) throws Exception{
		//System.out.println(Arrays.toString(args));
		//System.out.println(Arrays.toString(args));
		Scanner sinput = new Scanner(new File("A-large.in"));
		//Scanner input = new Scanner(new File(args[0]));
		//Scanner input = new Scanner(System.in);
		int numCases = sinput.nextInt();
		//System.out.printf("num=%d\n",numCases);
		//Scanner sinput = new Scanner(System.in);
		System.setOut(new PrintStream("alarge.out"));//System.out.printの出力先をファイルに変える
		for (int n = 0; n < numCases; n++) {
			int N = sinput.nextInt();
			//System.out.printf("N=%d\n",N);
			int[] ps = new int[N];
			for (int i = 0; i < N; i++){
				ps[i] = sinput.nextInt();
				//System.out.printf("ps[i]=%d\n",ps[i]);
			}
			int a=0;
			int b=0;
			int dif=0;
			for(int i=1;i<N;i++){
				if(dif<ps[i-1]-ps[i]) dif=ps[i-1]-ps[i];	
			}
			for(int i=1;i<N;i++){
				if(ps[i]<ps[i-1]) a+=ps[i-1]-ps[i];
				if(ps[i-1]<dif) b+=ps[i-1];
				else b+=dif;
			}
			System.out.printf("Case #%d: %d %d\n", n + 1, a,b);
		}
	}
}
