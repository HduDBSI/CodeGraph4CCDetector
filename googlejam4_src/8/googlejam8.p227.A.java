package googlejam8.p227;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class A
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
		{
			int nb_cases = Integer.parseInt(in.readLine());
			
			for(int icase = 0; icase < nb_cases; icase++)
			{
				// read input
				int N = Integer.parseInt(in.readLine());
				String[] P_str = in.readLine().split(" ");
				int[] P = new int[N];
				for(int i = 0; i < N; i++)
					P[i] = Integer.parseInt(P_str[i]);
				
				// solve
				LinkedList<String> y = new LinkedList<String>();
				
				int S = 0;
				for(int p = 0; p < N; p++)
					S += P[p];
				
				while(true)
				{
					String res = "";
					
					{
						int pmax = 0;
						for(int p = 1; p < N; p++)
							if(P[p] > P[pmax])
								pmax = p;

						if(P[pmax] == 0)
							break;
						P[pmax]--;
						S--;
						res = res + (char)('A' + pmax);
					}

					{
						int pmax = 0;
						for(int p = 1; p < N; p++)
							if(P[p] > P[pmax])
								pmax = p;

						if(P[pmax] > 0)
						{
							P[pmax]--;
							S--;
							
							int newpmax = 0;
							for(int p = 1; p < N; p++)
								if(P[p] > P[newpmax])
									newpmax = p;
							if(P[newpmax] > S/2)
							{
								P[pmax]++;
								S++;
							}
							else
								res = res + (char)('A' + pmax);
						}
					}
					y.add(res);
				}
				
				// write output
				out.write("Case #"+(icase+1)+":");
				for(String ye : y)
					out.write(" "+ye);
				out.write("\n");
			}
		}
		out.close();
		in.close();
	}
}
