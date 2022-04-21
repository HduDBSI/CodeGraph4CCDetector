package googlejam8.p058;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Senate
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; ++t)
		{
			int N = Integer.parseInt(in.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i) pq.add(Integer.parseInt(st.nextToken())*100+i);
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("Case #%d:", t+1));
			while (!pq.isEmpty())
			{
				int a = pq.poll();
				if (a/100 == 1 && pq.size() > 1)
				{
					sb.append(' ').append((char)(a%100+'A'));
					continue;
				}
				int b = pq.poll();
				int ca = a/100, pa = a%100;
				int cb = b/100, pb = b%100;
				sb.append(' ').append((char)(pa+'A')).append((char)(pb+'A'));
				if (ca > 1) pq.add(a-100);
				if (cb > 1) pq.add(b-100);
			}
			System.out.println(sb.toString());
		}
	}
}
