package googlejam10.p113;
/* Andy Rock
 * May 23, 2016
 * 
 * Round 2 2016: Problem A. 
 */

import java.io.*;
import java.math.*;
import java.util.*;

public class A
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in  = new BufferedReader(new FileReader("A.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("A.out"));

		int T = Integer.parseInt(in.readLine());
		for(int t=1;t<=T;t++)
		{
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			String ans = "IMPOSSIBLE";

			int[][] win = {{0, 1}, {1, 2}, {0, 2}};
			for(int i=0;i<3;i++)
			{
				String store = new String[]{"P", "R", "S"}[i];
				for(int k=0;k<N;k++)
				{
					String temp = "";
					for(char c : store.toCharArray())
						if(c == 'P')
							temp += "PR";
						else if(c == 'R')
							temp += "RS";
						else
							temp += "PS";

					store = temp;
				}

				int p = 0, r = 0, s = 0;
				for(char c : store.toCharArray())
					if(c == 'P')
						p++;
					else if(c == 'R')
						r++;
					else
						s++;

				for(int j=1;j<(1 << N);j *= 2)
					for(int k=0;k+j<(1 << N);k+=j+j)
						if(store.substring(k+j, k+2*j).compareTo(store.substring(k, k+j)) < 0)
							store = store.substring(0, k) + store.substring(k+j, k+2*j) + store.substring(k, k+j) + store.substring(k+2*j);

				if(P == p && R == r && S == s && (ans.equals("IMPOSSIBLE") || store.compareTo(ans) < 0))
					ans = store;
			}

			out.write("Case #"+t+": ");
			out.write(ans);
			out.write("\n");
		}

		in .close();
		out.close();
	}
}