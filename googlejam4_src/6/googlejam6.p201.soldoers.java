package googlejam6.p201;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class soldoers {
	public static void main( String args[]) throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\manas\\Downloads\\blrg.in"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\manas\\Documents\\google code jams\\second_large.txt"));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int a=1;
		while(t>0)
		{

			int n=Integer.parseInt(br.readLine());
			HashMap<Integer,Integer> count=new HashMap<Integer,Integer>();
			ArrayList<Integer> list=new ArrayList<Integer>();
			for(int i=0;i<2*n-1;i++)
			{
				String[] nums=br.readLine().split(" ");
				for(String n1:nums)
				{
					int val=Integer.parseInt(n1);
					if(count.containsKey(val))
						count.put(val, count.get(val)+1);
					else
						count.put(val,1);
					if(count.get(val)%2==1)
						list.add(val);
					else
						list.remove(new Integer(val));
					
				}
				
			}
			Collections.sort(list);
			

			bw.write("Case #"+a+": ");
			System.out.print("Case #"+a+": ");
			for(int a1:list)
			{
				bw.write(a1+" ");
				System.out.print(a1+" ");
			}
			System.out.println();
			a++;

			bw.newLine();
			t--;
		}
		bw.close();
	}

}
