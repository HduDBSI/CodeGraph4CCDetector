package googlejam2.p066;
import java.util.*;
public class a {
	public static void main(String[] args){
		Scanner br = new Scanner(System.in);
		int t = br.nextInt();
		for(int c = 1;c<=t;c++){
			long n = br.nextLong();
			
			int ans = 0;
			
			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			
			map.put(0l, 0);
			
			ArrayDeque<Long> qu = new ArrayDeque<Long>();
			qu.add(0l);
			
			while(qu.size() > 0){
				long cur = qu.poll();
				if(cur == n){
					ans = map.get(cur);
					break;
				}
				int dist = map.get(cur);
				
				if(!map.containsKey(cur+1)){
					map.put(cur+1, dist+1);
					qu.add(cur+1);
				}
				
				String rev = new StringBuilder(""+cur).reverse().toString();
				long next = Long.parseLong(rev);
				if(!map.containsKey(next)){
					map.put(next, dist+1);
					qu.add(next);
				}
			}
			
			System.out.println("Case #"+c+": "+ans);
		}
	}
}
