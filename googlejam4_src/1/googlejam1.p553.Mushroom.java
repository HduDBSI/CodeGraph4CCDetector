package googlejam1.p553;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Mushroom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<String> TestCases;
		
		TestCases = new ArrayList<String>();
		
		String fileName = "C:\\dev\\projects\\R1_Mushroom\\src\\gcj\\Example.txt";
		
		try 
		{
			InputStream in = new FileInputStream(new File(fileName));
			Scanner reader = new Scanner(in);
	        

	        int cntTests = reader.nextInt();
	        
	        for (int i = 0; i<cntTests; i++) 
	        {
	        	int n = reader.nextInt();
	        	ArrayList<Integer> moments = new ArrayList<Integer> ();
	        	int max = -1;
	        	for (int j = 0; j < n; j++) {
	        		moments.add(reader.nextInt());
	        		
	        	}
	        	
	        	long total_eaten1 = 0;
	        	int max_max = moments.get(0);
	        	
	        	for (int j = 0; j < n-1; j++) {
	        		int eaten_at_moment = moments.get(j) - moments.get(j+1);
	        		
	        		if (eaten_at_moment > 0) {
	        			total_eaten1 = total_eaten1 + eaten_at_moment;
	        		}
	        		
	        		if (eaten_at_moment > max) {
	        			max = eaten_at_moment;
	        		}
	        		
	        	}
		        
	        	
	        	long total_eaten2 = 0;
	        	
	        	//if (max > max_max) max = max_max;
	        	
	        	for (int j = 0; j < n-1; j++) {
	        		
	        		
	        		if (moments.get(j) < max) {
	        			total_eaten2 = total_eaten2 + moments.get(j);
	        		} else {
	        			total_eaten2 = total_eaten2 + max;
	        		}
	        		
	        		
	        	}
	        	
	        	TestCases.add(total_eaten1 + " " + total_eaten2);
	        }
	         
	        reader.close();
		} catch (Exception ex)	{
			System.out.print(ex.getMessage());
		}
		
		String outFileName = "C:\\dev\\projects\\R1_Mushroom\\src\\gcj\\output.txt";
		try { 
		File file = new File(outFileName);
		BufferedWriter output = new BufferedWriter(new FileWriter(file));
		for (int i =0; i < TestCases.size(); i++) {
			output.write("Case #" + (i+1) + ": " + TestCases.get(i) + "\r\n");
		}
		
		output.close();
		} catch ( Exception e ) {
			e.printStackTrace();
		}

	}

}
