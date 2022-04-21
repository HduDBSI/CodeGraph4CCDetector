package googlejam2.p215;
import java.util.*;

public class Main {
	
	static long answ;
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long N;
		long n;
		String s, ss;
		StringBuilder rev;
		
		Queue<String> q = new LinkedList<String>();
		Queue<Long> c = new LinkedList<Long>();
		HashSet<String> hs = new HashSet<String>();
		for(int z = 1; z <= T; z++){
			N = in.nextLong();
			q.clear();
			c.clear();
			hs.clear();
			hs.add("1");
			q.add("1");
			c.add(1l);
			while(!q.isEmpty()){
				s = q.poll();
				answ = c.poll();
				n = Long.parseLong(s) + 1;

				if(n == N + 1){
					break;
				}
				ss = Long.toString(n);
				if(!hs.contains(ss)){
					q.add(ss);
					hs.add(ss);
					c.add(answ + 1);
				}
				rev = new StringBuilder(s);
				ss = rev.reverse().toString();
				if(!hs.contains(ss)){
					q.add(ss);
					hs.add(ss);
					c.add(answ + 1);
				}
			}
			
			
			System.out.println("Case #" + z + ": " + answ);
		}
	}
	
	
	
	
}
