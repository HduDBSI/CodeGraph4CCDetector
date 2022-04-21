package googlejam11.p110;
/* Andy Rock
 * May 23, 2016
 * 
 * Round 2 2016: Problem B. 
 */

import java.io.*;
import java.math.*;
import java.util.*;

public class B
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in  = new BufferedReader(new FileReader("B.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("B.out"));

		int T = Integer.parseInt(in.readLine());
		for(int t=1;t<=T;t++)
		{
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(in.readLine());
			double[] P = new double[N];
			for(int i=0;i<N;i++)
				P[i] = Double.parseDouble(st.nextToken());

			double[][] tt = new double[N][N];
			double[][] tf = new double[N][N];
			double[][] ft = new double[N][N];
			double[][] ff = new double[N][N];
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
				{
					tt[i][j] =      P[i]  *      P[j];
					tf[i][j] =      P[i]  * (1 - P[j]);
					ft[i][j] = (1 - P[i]) *      P[j];
					ff[i][j] = (1 - P[i]) * (1 - P[j]);
				}

			double ans = 0;
			for(int i=0;i<(1 << N);i++)
			{
				int num = 0;
				for(int j=0;j<N;j++)
					if((i & (1 << j)) != 0)
						num++;

				if(num == K)
				{
					double[] prob = new double[K+1];
					prob[0] = 1;

					for(int j=0;j<N;j++)
						if((i & (1 << j)) != 0)
						{
							double[] temp = new double[K+1];
							temp[0] = prob[0] * (1 - P[j]);
							for(int a=1;a<=K;a++)
								temp[a] = prob[a] * (1-P[j]) + prob[a-1] * P[j];
							prob = temp;
						}
					ans = Math.max(ans, prob[K/2]);
				}
			}

			out.write("Case #"+t+": ");
			out.write(""+ans);
			out.write("\n");
		}

		in .close();
		out.close();
	}
}