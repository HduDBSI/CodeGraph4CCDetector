package googlejam2.p121;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class A {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int[] minS = new int[2000000];
		minS[1] = 1;
		Queue<Integer> st = new LinkedList<Integer>();
		st.add(1);
		while(!st.isEmpty())
		{
			int cur = st.poll();
			if(cur+1 < minS.length && minS[cur+1]==0)
			{
				minS[cur+1] = minS[cur]+1;
				st.add(cur+1);
			}
			StringBuilder sb = new StringBuilder(""+cur);
			int rev = Integer.parseInt(sb.reverse().toString());
			if(rev < minS.length && minS[rev]==0)
			{
				minS[rev] = minS[cur]+1;
				st.add(rev);
			}
		}
		for (int cas = 1; cas <=T; cas++) {
			String s = in.readLine();
			int N = Integer.parseInt(s);
			System.out.println("Case #"+cas+": "+minS[N]);
		}
	}

}
