package googlejam8.p372;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class first_small {

	public static void main( String args[]) throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\manas\\Downloads\\A-large (1).in"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\manas\\Documents\\google code jams\\first_big.txt"));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		int a=1;
		while(t>0)
		{
			int n=Integer.parseInt(br.readLine());
			String [] p=br.readLine().split(" ");
			ArrayList<Integer> vals=new ArrayList<Integer>();
			String [] alpha={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
			HashMap<Integer,Integer> count=new HashMap<Integer,Integer>();
			for(int i=0;i<p.length;i++)
			{
				vals.add(Integer.parseInt(p[i]));
				count.put(i, vals.get(i));
			}
			int parties_done=0;
			
			System.out.print("Case #"+a+": ");
			bw.write("Case #"+a+": ");
			a++;
			while(parties_done!=n)
			{
				
				int frst_max=0;
				int second_max=0;
				int first_pos=-1;
				int second_pos=-1;
				for(int i=0;i<vals.size();i++)
				{
					if(vals.get(i)>frst_max)
					{
						frst_max=vals.get(i);
						first_pos=i;
					}
				}
				vals.set(first_pos,vals.get(first_pos)-1);
				for(int i=0;i<vals.size();i++)
				{
					if(vals.get(i)>second_max)
					{
						second_max=vals.get(i);
						second_pos=i;
					}
				}
				vals.set(second_pos,vals.get(second_pos)-1);				
				if(n-parties_done==3)
				{
					System.out.print(alpha[first_pos]+" ");
					bw.write(alpha[first_pos]+" ");
					vals.set(second_pos, vals.get(second_pos)+1);
				}
				else
				{
					if(second_pos==-1)
					{
						System.out.print(alpha[first_pos]+" ");
						bw.write(alpha[first_pos]+" ");
					}
					else
					{
						System.out.print(alpha[first_pos]+alpha[second_pos]+" ");
						bw.write(alpha[first_pos]+alpha[second_pos]+" ");
					}
				}
					
				int c=0;
				for(int i=0;i<vals.size();i++)
				{
					if(vals.get(i)==0)
						c++;
				}
				parties_done=c;
			}
			System.out.println();
			bw.newLine();
			t--;
			
			
		}
		bw.close();
		/*while(t>0)
		{
			String s=br.readLine();
			int count=0;
			char prev=s.charAt(0);
			
			for(int i=1;i<s.length();i++)
			{
				char curr=s.charAt(i);
				if(curr!=prev)
				{
					count++;
					prev=curr;
					
				}
			}
			if(s.charAt(s.length()-1)=='-')
				count++;
			
			
			
			
			bw.write("Case #"+a+": "+count);
			System.out.println("Case #"+a+": "+count);
			a++;
			
			bw.newLine();
			t--;
		}
		bw.close();*/
	}
}
