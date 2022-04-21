package googlejam1.p359;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Mushroom {
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
	    int test_no = Integer.parseInt(br.readLine());
	    
	    BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));	
	
	    for(int i = 1; i <= test_no; i++)
	    {
	    	int stringlength = Integer.parseInt(br.readLine());
	    	
	    	String[] data = br.readLine().split(" ");
	    	
	    	int count_second = 0;
	    	int largest_diff = 0;
	    	for(int j = 0; j < stringlength -1; j++)
	    	{
	    		int left = Integer.parseInt(data[j]);
	    		int right = Integer.parseInt(data[j+1]);
	    		int difference = right - left;
	    		if(difference <= 0)
	    			count_second -= difference;
	    		if(-difference >= largest_diff)
	    			largest_diff = -difference;
	    		
	    	}
	    	
	    	int count_second2 = 0;
	    	for(int j = 0; j < stringlength -1; j++)
	    	{
	    		int left = Integer.parseInt(data[j]);
	    		int right = Integer.parseInt(data[j+1]);
	    		if(left <= largest_diff)
	    			count_second2 += left;
	    		else
	    			count_second2 += largest_diff;
	    		
	    		
	    	}
	    	System.out.println(count_second);
	    	System.out.println(count_second2);
	    	out.write("Case #");
	    	out.write(String.valueOf(i));
	    	out.write(": ");
	    	out.write(String.valueOf(count_second));
	    	out.write(String.valueOf(" "));
	    	out.write(String.valueOf(count_second2));
	    	out.write("\n");
	    }
	    br.close();
	    out.close();
	    
	    
	}


}
