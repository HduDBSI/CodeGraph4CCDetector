package googlejam6.p551;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class google_rankandfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

try{
			
			BufferedReader br = new BufferedReader(new FileReader("B-large0.in"));
			int l=0;
			String line="";
			int t = Integer.parseInt(br.readLine());
			String[] s = new String[t];
			/*while ((line = br.readLine()) != null) {
				//System.out.println(line);
				
				s[l] = line;
				l++;
			}*/
			
			for(int i=0;i<t;i++)
			{
				int N = Integer.parseInt(br.readLine());
				//System.out.println(N);
				List<String> matrix =new ArrayList<String>();
				Map<String,Integer> hm = new HashMap<String,Integer>();
				//System.out.println(N);
				int lines = 2*N-1;
				for(int j=0;j<lines;j++)
				{
					matrix.add(br.readLine());
				//	System.out.println(matrix.get(j));
					String[] temp = matrix.get(j).split(" ");
					for(int k=0;k<temp.length;k++)
					{
						if(!hm.containsKey(temp[k]))
						{
							//System.out.println("arr: "+temp[k]);
							hm.put(temp[k],1);
							//System.out.println("hm: "+hm.get(arr[i][j]));
						}
						else
						{
							hm.put(temp[k], hm.get(temp[k])+1);
						}
					
					}
				}
				
				// System.out.println(matrix.get(j));
				
				 
				List<String> res = new ArrayList<String>();
				//System.out.println("key: "+1+" value: "+hm.get(1));
				for(String k : hm.keySet())
				{
					//System.out.println("key: "+k+" value: "+hm.get(k));
					if(hm.get(k)%2!=0)
					{
						res.add(k);
					}
				}
				List<Integer> res1 = new ArrayList<Integer>();
				for(int z=0;z<res.size();z++)
				{
					res1.add(Integer.parseInt(res.get(z)));
				}
				Collections.sort(res1);
				System.out.print("Case #"+(i+1)+": "); // change case number
				for(int p=0;p<res1.size();p++)
				{
					System.out.print(res1.get(p)+" ");
				}
				System.out.println();

				//char[] 
				
				//System.out.println("Case #"+(i+1)+": "+count);
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		/*
		int arr[][] = {{1,2,3},{2,3,5},{3,5,6},{2,3,4},{1,2,3}};
		
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				if(!hm.containsKey(arr[i][j]))
				{
					//System.out.println("arr: "+arr[i][j]);
					hm.put(arr[i][j],1);
					//System.out.println("hm: "+hm.get(arr[i][j]));
				}
				else
				{
					hm.put(arr[i][j], hm.get(arr[i][j])+1);
				}
			}
		}
		
		List<Integer> res = new ArrayList<Integer>();
		//System.out.println("key: "+1+" value: "+hm.get(1));
		for(Integer k : hm.keySet())
		{
			//System.out.println("key: "+k+" value: "+hm.get(k));
			if(hm.get(k)%2!=0)
			{
				res.add(k);
			}
		}
		
		Collections.sort(res);
		System.out.print("Case #"+(1)+": "); // change case number
		for(int i=0;i<res.size();i++)
		{
			System.out.print(res.get(i)+" ");
		}
		*/
	}

}
