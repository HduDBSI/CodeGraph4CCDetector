package googlejam6.p607;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RankFile {

	public static void main(String[]args)
	{
		try
		{
			Scanner sc = new Scanner(new FileReader("B-large (1).in"));
			FileWriter fw = new FileWriter(new File("Output.txt"));
			PrintWriter pw = new PrintWriter(fw);
				
			int t = sc.nextInt();
			sc.nextLine();
				
			for(int r = 1; r <= t; r++)
			{
				int n = sc.nextInt();
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int i = 0; i < 2*n-1; i++)
				{
					for(int j = 0; j<n; j++)
					{
						int temp = sc.nextInt();
						boolean add = true;
						for (int k = 0; k < list.size();k++)
						{
							if(temp == list.get(k))
							{
								list.remove(k);
								add = false;
								break;
							}
						}
						if(add)
							list.add(temp);
					}
				}
				Collections.sort(list);
				
				pw.print("Case #" + r + ":");
				for(int i = 0; i < n; i++ )
				{
					pw.print(" "+list.get(i));
				}
				pw.println();
			}
			pw.flush();	
			pw.close();
		}
			catch(IOException ioe)
			{
				System.out.print(ioe);
			}

	}

}
