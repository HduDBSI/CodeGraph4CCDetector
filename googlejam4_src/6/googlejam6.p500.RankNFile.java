package googlejam6.p500;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;

public class RankNFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName = "B-large.in"; 
        String line = null;
        int tempInt= 0;
        Writer writer = null;
        boolean[] boolArr= new boolean[2501];
        try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("B-large.out"), "utf-8"));
	        try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = new FileReader(fileName);
	
	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader =  new BufferedReader(fileReader);
	            
	            int a = Integer.parseInt(bufferedReader.readLine());
	            System.out.println("There are " + a +" entries.");
		            for (int e=0; e<a;e++) {
		            	Arrays.fill(boolArr, false);
			            int b = Integer.parseInt(bufferedReader.readLine());
			            System.out.println("N :" +b);			    		
			            for (int i = 0; i<(2*b-1); i++) { //for number of stacks of pancakes
			            	line=bufferedReader.readLine();
			            	String[] nums = line.split(" ");
			            	for (int j = 0; j < nums.length; j++) { 
			            		tempInt = Integer.parseInt(nums[j]);
			            		if (boolArr[tempInt]) {
			            			boolArr[tempInt]=false;
			            		} else {
			            			boolArr[tempInt]=true;
			            		}; 
			            	}
			            }
		            	//System.out.println(line);
						writer.write("Case #" + (e+1) + ":");
		        		for (int k=0; k<2500;k++) {
		        			if (boolArr[k]) {
								writer.write(" "+k);
		        			}
		        		}
		        		writer.append(System.lineSeparator());	            	
		    		}   
		            // Always close files.
		            bufferedReader.close();         
		        }
		        catch(FileNotFoundException ex) {
	            System.out.println("Unable to open file '" +  fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println("Error reading file '" + fileName + "'");                  
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }    
		} catch (IOException ex) {
			  // report
		} finally {
			try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	}
}
