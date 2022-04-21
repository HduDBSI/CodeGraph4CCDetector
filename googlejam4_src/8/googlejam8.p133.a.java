package googlejam8.p133;
import java.io.*;
import java.util.*;


public class a 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner sc = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter("output.txt");
		
		int n_case = sc.nextInt();
		for(int i=1;i<=n_case;i++)
		{
			int n = sc.nextInt();
			int sen[] = new int[n];
			int tot  = 0;
			for(int j=0;j<n;j++)
			{
				sen[j] = sc.nextInt();
				tot+=sen[j];
			}
			int tot1 = tot;
			String ris1 = new String();
			
			int max1 = -1;
			int pos1 = -1;
			int max2 = -1;
			int pos2 = -1;
			
			while(tot1 > 3)
			{
				max1 = -1;
				pos1 = -1;
				max2 = -1;
				pos2 = -1;
				for(int i2=0;i2<n;i2++)
				{
					if(sen[i2]>max1)
					{
						max2=max1;
						pos2=pos1;
						max1=sen[i2];
						pos1=i2;
					}
					else
					{
						if(sen[i2]>max2)
						{
							max2=sen[i2];
							pos2=i2;
						}
					}
				}
				
				if(pos1!=-1)
				{
					ris1+= Character.toChars(('A'+pos1))[0];
					sen[pos1]--;
					tot1--;
				}
				
				if(pos2!=-1)
				{
					ris1+=Character.toChars(('A'+pos2))[0];
					sen[pos2]--;
					tot1--;
				}
				
				ris1+=" ";
			}
			
			String last = "";
			for(int i1=0;i1<n;i1++)
			{
				if(sen[i1]!=0 && last.length()<2)
				{
					last+=Character.toChars(('A'+i1))[0];
				}
				else
				{	if(last.length()==2)
					{
						ris1+=Character.toChars(('A'+i1))[0]+" ";
					}
				}
			}
			String ris = ris1 + last;
			out.println("Case #"+i+": "+ris);
		}
		
		sc.close();
		out.close();
	}

}
