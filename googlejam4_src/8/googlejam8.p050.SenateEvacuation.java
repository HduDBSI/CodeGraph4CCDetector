package googlejam8.p050;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SenateEvacuation {
	public static void main(String[]args)
	{
		try
		{
			Scanner sc = new Scanner(new FileReader("A-large.in"));
			FileWriter fw = new FileWriter(new File("Output.txt"));
			PrintWriter pw = new PrintWriter(fw);
				
			int t = sc.nextInt();
			sc.nextLine();
				
			for(int r = 1; r <= t; r++)
			{
				int n = sc.nextInt();
				int [] a = new int[n];
				int total = 0;
				System.out.print("Case# " + r + ": ");
				for(int i = 0; i < n; i++ )
				{
					a[i] = sc.nextInt();
					total += a[i];
					System.out.print(a[i] + " ");
				}
				System.out.println();
				
				pw.print("Case #" + r + ": ");
				
				
				int max = 0; 
				int index = -1;
				
				boolean next = false;
				boolean first = true;
				
				while(total > 0)
				{	
					if(first && total == 3)
						{
							boolean c = true;
							for(int j = 0; j < n; j++)
							{
								if(a[j] > 1)
									c = false;
							}
							if(c)
								for(int j = 0; j < n; j++)
								{			
									if(a[j] == 1)
									{
										a[j] -= 1;
										pw.print((char)('A' + j)+ " ");
										total -= 1;
										break;
									}
								}	
						}
					
					
					max = 0;
					for(int i = 0; i < n; i++)
					{
						if(a[i] > max)
						{
							max = a[i];
							index = i;
						}
					}
					a[index] = a[index] - 1;
					pw.print((char)('A' + index));
					total -= 1;
					if(total == 0)
						break;
					if(next)
					{
						pw.print(" ");
						if(total == 3)
						{
							boolean c = true;
							for(int j = 0; j < n; j++)
							{
								if(a[j] > 1)
									c = false;
							}
							if(c)
								for(int j = 0; j < n; j++)
								{			
									if(a[j] == 1)
									{
										a[j] -= 1;
										pw.print((char)('A' + j)+ " ");
										total -= 1;
										break;
									}
								}	
						}
					}
					next = !next;
					first = false;
				}
				pw.println();
						
			}
			pw.flush();	
			pw.close();
		}
			catch(IOException ioe){System.out.print(ioe);}
	}
}
