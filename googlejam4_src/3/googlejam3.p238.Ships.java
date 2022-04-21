package googlejam3.p238;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Ships {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Long> TestCases;
		
		TestCases = new ArrayList<Long>();
		
		String fileName = "C:\\dev\\projects\\R3_1Ships\\src\\Example.txt";
		
		try 
		{
			InputStream in = new FileInputStream(new File(fileName));
			Scanner reader = new Scanner(in);
	        

	        int cntTests = reader.nextInt();
	        
	        for (int i = 0; i<cntTests; i++) 
	        {
	        	System.out.println("TEST NUMBER " + i);
	        	long R = reader.nextInt();
	        	long C = reader.nextInt();
	        	long W = reader.nextInt();
	        	
	        	System.out.println(R+" "+C+" "+W);
	        	
	        	long result = 0;
	        	
	        	result = C / W;
	        	result = result * R;
	        	
	        	if (C % W !=0) {
	        		result = result + 1;
	        	}
	        	

		        result = result + ( W - 1); 
		        
	        	TestCases.add(result);
	        	System.out.println(result);
	        
	        }
	        reader.close();
		} catch (Exception ex)	{
			ex.printStackTrace();
		}
		
		String outFileName = "C:\\dev\\projects\\R3_1Ships\\src\\output.txt";
		try { 
		File file = new File(outFileName);
		BufferedWriter output = new BufferedWriter(new FileWriter(file));
		for (int i =0; i < TestCases.size(); i++) {
			output.write("Case #" + (i+1) + ": " + TestCases.get(i));
			output.newLine();
		}
		
		output.close();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		System.out.println("Done");

	}


}
