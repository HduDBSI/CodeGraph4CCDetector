package googlejam1.p691;


import java.io.*;

public class DriverA {

	public static void main(String[] args) throws IOException {
		int numCases;
		
		File in = new File("A-large.in");
		FileWriter out = new FileWriter("output");
		BufferedReader reader = new BufferedReader(new FileReader(in));
		BufferedWriter writer = new BufferedWriter(out);
		
		numCases = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < numCases; i++)
		{
			int numInter = Integer.parseInt(reader.readLine());
			String[] intervals_String = reader.readLine().split(" ");
			int[] intervals = new int[numInter];
			
			for (int j = 0; j < numInter; j++)
			{
				intervals[j] = Integer.parseInt(intervals_String[j]);
			}
			int total = 0;
			int[] operate = new int[intervals.length];
			// reverse
			for (int i1 = 1; i1 <= intervals.length; i1++)
			{
				operate[intervals.length - i1] = intervals[i1 - 1];
			}
			
			for (int j = 0, k = 1; k < operate.length; j++, k++)
			{
				if(operate[j] < operate[k])
				{
					total += (operate[k] - operate[j]);
				}
			}
			
			// All done here
			
			/*
			for (int j = 0; j < numInter; j++)
			{
				System.out.print(intervals[j] + " ");
			}
			System.out.println();
			*/
			
			int x = total;
			int total1 = 0;
			int maxDif = 0;
			// find max difference
			for(int j = 0, k = 1; k < intervals.length; j++, k++)
			{
				if((intervals[j] - intervals[k]) > maxDif)
				{
					maxDif = (intervals[j] - intervals[k]);
				}
			}
			
			for(int h = 0; h < intervals.length - 1; h++)
			{
				if(maxDif > intervals[h])
				{
					total1 += intervals[h];
				}
				else
				{
					total1 += maxDif;
				}
			}
			int y = total1;
			System.out.println(x + " " + y);
			writer.write("Case #" + (i + 1) + ": " + x + " " + y + "\n");
		}
		reader.close();
		writer.close();
	}
}


/*
 while (keepGoing)
		{
			for (int k = 0; k < intervals.length; k++)
			{
				if
			}
			
			if((intervals[intervals.length - 2] - intervals[intervals.length - 1]) % rate < 10 * rate)
			{
				for(int i = 0; i < intervals.length - 1; i++)
					if((10 * rate) > intervals[i])
					{
						total += intervals[i];
					}
					else
					{
						total += (rate * 10);
					}
				keepGoing = false;
			}
			else
			{
				rate++;
			}	
		}
		*/
