package googlejam8.p542;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class SenateEvacuation {

	public static void main(String[] args) 
	{
		try
		{
			String inputName = "A-large (2).in";
			BufferedReader input = new BufferedReader(new FileReader(inputName));
			BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
			//read test case number
			String line = input.readLine();
			int testNr = new Integer(line).intValue();
			
			for (int i = 0; i < testNr; i++)
			{
				SenateEvacuation test = new SenateEvacuation();
				line = input.readLine();
				int N = new Integer(line).intValue();
				line = input.readLine();
				String[] parts = line.split(" ");
				int[] P = new int[parts.length];
				int count = 0;
				for (int i2 = 0; i2 < N; i2++)
				{
					P[i2] = new Integer(parts[i2]).intValue();
					count += P[i2];
				}
				
				StringBuffer sb = new StringBuffer();
				if (N == 2)
				{
					for (int i1 = 0; i1 < P[0]; i1++)
					{
						if (i1>0) sb.append(" ");
						sb.append("AB");
					}
				}
				else
				{
					boolean first = true;
					while (count > 0)
					{
						if (count < 3)
						{
							if (!first)
							{
								sb.append(" ");
							}
							for (int i4 = 0; i4 < N; i4++)
							{
								if (P[i4] > 0) sb.append((char)('A'+i4));
							}
							count = 0;
						}
						else if (count == 3)
						{
							if (!first)
							{
								sb.append(" ");
							}
							else first = false;
							boolean found = false;
							for (int i3 = 0; !found && i3 < N; i3++)
							{
								if (P[i3] > 0)
								{
									sb.append((char)('A'+i3));
									P[i3] -= 1;
									count -= 1;
									found = true;
								}
							}
						}
						else
						{
							int max_index = 0;
							int max = P[0];
							int max_index2 = 0;
							int max2 = P[0];
							if (P[1] > P[0])
							{
								max_index = 1;
								max = P[1];
							}
							else
							{
								max_index2 = 1;
								max2 = P[1];
							}
							for (int i5 = 2; i5 < N; i5++)
							{
								if (P[i5] > max)
								{
									max2 = max;
									max_index2 = max_index;
									max = P[i5];
									max_index = i5;
								}
								else if (P[i5] > max2)
								{
									max2 = P[i5];
									max_index2 = i5;
								}
							}
							if (!first)
							{
								sb.append(" ");
							}
							else first = false;
							sb.append((char)('A'+max_index));
							sb.append((char)('A'+max_index2));
							P[max_index]-=1;
							P[max_index2]-=1;
							count -= 2;
						}
					}
				}
				String res = sb.toString();
				String toWrite = "Case #" + (i+1) + ": " + res;
				System.out.println(toWrite);
				output.write(toWrite + "\n");
			}
			output.flush();
			output.close();
			input.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
