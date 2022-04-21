package googlejam8.p889;
import java.io.*;
import java.util.*;

class CodeJam161CA 
{
	public static void main(String[] args) throws Exception
	{
		File file = new File("D:\\A-small.in");
		File outFile = new File("D:\\A-small.out");

		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));

		int testCases = Integer.parseInt(br.readLine());
		for(int t=1;t<=testCases;t++)
		{
			int N = Integer.parseInt(br.readLine());
			int[] Ninput = new int[N];

			//put info to array
			String input = br.readLine();
			StringTokenizer strToken = new StringTokenizer(input);
			int count = strToken.countTokens();

			for(int x = 0;x < count;x++){
				Ninput[x] = Integer.parseInt((String)strToken.nextElement());
			}
			
			System.out.println("=============");
			//System.out.println(Arrays.toString(Ninput));

			String removed = "";

			while (!areAllZero(Ninput))
			{
				String removedSen = "";

				
				int large1;
				int large2;
				
				int largeindex1;
				int largeindex2;
				int sum = Ninput[0]+Ninput[1];

				if (Ninput[0]>Ninput[1])
				{
					large1 = Ninput[0];
					large2 = Ninput[1];
					largeindex1 = 0;
					largeindex2 = 1;
				}
				else
				{
					large1 = Ninput[1];
					large2 = Ninput[0];
					largeindex1 = 1;
					largeindex2 = 0;
				}
				for(int i=2; i< Ninput.length; i++)
				{
					sum += Ninput[i];
					if(Ninput[i] >= large1)
					{
						large2 = large1;
						large1 = Ninput[i];
						largeindex2 = largeindex1;
						largeindex1 = i;
					}
					else if (Ninput[i] >= large2)
					{
						large2 = Ninput[i];
						large2 = i;
					}
				}

				if (Ninput[largeindex1]>0)
				{
					Ninput[largeindex1]--;
					removedSen += (char)(largeindex1+0x41);
				}
				if (largeindex1 != largeindex2 && sum % 2==0)
				{
					if (Ninput[largeindex2]>0)
					{
						Ninput[largeindex2]--;
						removedSen += (char)(largeindex2+0x41);
					}
				}
				//System.out.println(largeindex1+" "+largeindex2);
				//System.out.println(Arrays.toString(Ninput));
				//System.out.println(removedSen);
				removed += removedSen + " ";
			}

			bw.write("Case #" + t +": "+removed+"\n");
		}
		br.close();
		bw.close();
	}
	public static boolean areAllZero(int[] array)
	{
		for(int b : array) if(b>0) return false;
		return true;
	}
}
