package googlejam6.p528;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;


public class Rank {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\manju\\Downloads\\B-large.in.txt");
	    File outFile = new File("C:\\Users\\manju\\Downloads\\B-large.out.txt");
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
	    int testCases = Integer.parseInt(br.readLine());
	    for(int t=1;t<=testCases;t++)
	    {
	        String line = br.readLine().trim();
	        Integer n = Integer.parseInt(line);
	        int endIn = 2*n-1;
			int a[][] = new int [n][n];
			List<List<Integer>> inList = new ArrayList<List<Integer>>();
			Set<Integer> out = new TreeSet<Integer>();
			//Set<String> stList = new TreeSet<String>();
			Map<Integer, Integer> itMap = new HashMap<Integer, Integer>();
	        for(int i=0; i< endIn;i++)
	        {
	        	line = br.readLine().trim();
	        	String[] numberArray = line.split(" ");
	        	
	        	
	        	char ch[] = line.toCharArray();
	        	//List<Integer> list = new ArrayList<Integer>();
	        	for (String number : numberArray) {
	        		int key = Integer.parseInt(number);
	        	   // list.add(key);
	        	    if(!(itMap.containsKey(key)))
	        	    {
	        	    	itMap.put(key, 1);
	        	    }
	        	    else
	        	    {
	        	    	itMap.put(key, itMap.get(key)+1);
	        	    }
	        	}
	        	//inList.add(list);
	        	//System.out.println(list);
	        }
	        System.out.println(itMap);
	        
	        for(Entry<Integer, Integer> entry : itMap.entrySet())
	        {
	        	if (entry.getValue()%2!=0)
	        	{
	        		out.add(entry.getKey());
	        	}
	        }
	        System.out.println(out);
	        

			bw.write("Case #" + t +": ");
			for(Integer i : out)
			{
				bw.write(i + " ");
			}
	        if(t !=testCases)
	        {
	        	bw.newLine();
	        }

	        
	    }
	    br.close();
	    bw.close();
	    
	    
			
	}

}
