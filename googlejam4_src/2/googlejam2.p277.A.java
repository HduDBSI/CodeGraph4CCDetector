package googlejam2.p277;
import java.util.*;
public class A {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int z = 1; z <= t; z ++){
			int n = in.nextInt();
			int[] a = new int[n + 1];
			Arrays.fill(a, -1);
			a[1] = 1;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(1);
			while(!q.isEmpty()){
				int at = q.poll();
				if(at == n)break;
				if(at > n)continue;
				if(a[at + 1] == -1){
					a[at + 1] = a[at] + 1;
					q.add(at + 1);
				}
				long a1 = at;
				int len = 0;
				long aa = a1;
				while(aa!=0){
					aa/=10;
					len++;
				}
				len--;
				long ans = 0;
				while(a1>0){
					ans+=(a1%10)*(Math.pow(10,  len));
					len--;
					a1/=10;
				}
				int to = (int)ans;
				if(to <= at || to > n || a[to] != -1)
					continue;
				q.add(to);
				a[to] = a[at] + 1;
			}
			System.out.println("Case #" + z + ": " + a[n]);
		}
	}
}
