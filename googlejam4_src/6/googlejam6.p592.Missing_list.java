package googlejam6.p592;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Missing_list {
	private static BufferedReader fr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

static LinkedList<Integer> num_list = new LinkedList<Integer>();
static LinkedList<Integer> missing_list = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Enter File Name = ");
		String ipfile = br.readLine();
		System.out.println("File Name = "+ipfile);
		fr = new BufferedReader(new FileReader(ipfile));
		Integer cases = Integer.parseInt(fr.readLine());
		System.out.println("Cases = "+cases);
		Missing_list myvar = new Missing_list();
		String line;
		Integer cnt=1;
		for(int i=1;i<=cases;i++)
		{
			Integer nums = Integer.parseInt(fr.readLine());
			
			for(int j=0;j<(nums*2)-1;j++)
			{
				line = fr.readLine();
				Scanner s = new Scanner(line);
				for(int k=0;k<nums;k++)
				{
					Integer number = s.nextInt();
					num_list.add(number);
				}
			
			}
			
			ListIterator<Integer> it = num_list.listIterator();
			missing_list.clear();
			while(it.hasNext())
			{
				Integer curr_num = it.next();
				Integer occr = Collections.frequency(num_list,curr_num);
				if(occr % 2 != 0)
				{
					Integer dups=Collections.frequency(missing_list, curr_num);
					if(dups==0)
						missing_list.add(curr_num);
				}
				
			}
			
			Collections.sort(missing_list);	
			String res = missing_list.toString().replaceAll("[^a-zA-Z0-9 ]","").toUpperCase();
			System.out.println("Case #"+i+": "+res);
			num_list.clear();
			
	}

	
	

	

	
	}}
