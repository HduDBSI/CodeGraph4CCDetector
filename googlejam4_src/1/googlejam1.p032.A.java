package googlejam1.p032;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class A {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("A.txt"));
		PrintWriter out = new PrintWriter(new File("A.out"));
		int cases = sc.nextInt();
		for(int t=1;t<=cases;t++){
			long ans1 = 0;
			int N = sc.nextInt();
			long[] array = new long[N];
			for(int a=0;a<N;a++)array[a]=sc.nextLong();
			long largest = 0;
			long increase = 0;
			for(int a=1;a<N;a++){
				if(array[a-1]>array[a]){
					ans1+=array[a-1]-array[a];
					largest = Math.max(largest,array[a-1]-array[a]);
					increase = Math.max(increase,array[a-1]-array[a]);
				}
			}
			long ans2 = 0;
			long cur = array[0];
			for(int a=1;a<N;a++){
				ans2 += Math.min(cur,increase);
				cur -= Math.min(cur,increase);
				cur = array[a];
			}
			
			
			String answer = String.format("Case #%d: %d %d", t,ans1,ans2);
			System.out.println(answer);
			out.println(answer);
		}
		out.close();
	}

}
