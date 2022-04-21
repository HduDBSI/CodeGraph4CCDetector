package googlejam6.p470;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class B_Ranks {
	
	public static void main(String[] args) throws IOException{
		// 0. My Small Practice
		//FileReader reader = new FileReader("test_case_gcj2016Round1A/B-mysmall-practice.in");
		//FileWriter writer = new FileWriter("test_case_gcj2016Round1A/B-mysmall-practice.out");

		// 1. Small Practice
		// Judged response for input A-small: Correct!
		//FileReader reader = new FileReader("test_case_gcj2016Round1A/B-small-attempt0.in");
		//FileWriter writer = new FileWriter("test_case_gcj2016Round1A/B-small-attempt0.out");

		// 2. Large Practice
		FileReader reader = new FileReader("test_case_gcj2016Round1A/B-large.in");
		FileWriter writer = new FileWriter("test_case_gcj2016Round1A/B-large.out");
		
		
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
        int noOfCases = Integer.parseInt(line);
        System.out.println(noOfCases);
		        
        for (int i = 1; i <= noOfCases; i++){
			// 1. read data
        	line = bufferedReader.readLine();
        	int n = Integer.parseInt(line);
        	int[][] mat = new int[2*n-1][n];
        	for (int j = 0; j < 2*n-1; j++){
			    line = bufferedReader.readLine();
			    String[] nos = line.split(" ");
			    int[] array = Arrays.asList(nos).stream().mapToInt(Integer::parseInt).toArray();
			    mat[j] = array;
        	}
			int[] res1 = new int[n];
			
			HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
			
			for (int i1 = 0; i1 < 2*n-1; i1++){
				for (int j = 0; j < n; j++){
					if (!count.containsKey(mat[i1][j])){
						count.put(mat[i1][j], 1);
					}
					else{
						int c = count.get(mat[i1][j]);
						count.replace(mat[i1][j], c+1);
					}
				}
			}
			
			int i2 = 0;
			
			Iterator it = count.entrySet().iterator();
			while (it.hasNext()) {
			    Map.Entry pair = (Map.Entry)it.next();
			    //HashMap.Entry pair = (Map.Entry)it.next();
			    if (((int) pair.getValue()) % 2 == 1){
			    	res1[i2] = (int) pair.getKey();
			    	i2++;
			    }
			    //System.out.println(pair.getKey() + " = " + pair.getValue());
			    it.remove(); // avoids a ConcurrentModificationException
			}
			
			Arrays.sort(res1);
        	
		    //System.out.println(line);
        	int[] res = res1;
		    
		    String outputLine = "Case #" + i + ": ";
		    //System.out.print(outputLine);
		    //writer.write(outputLine);
		    for (int idx = 0; idx < res.length; idx++){
			    outputLine += res[idx] + " ";
		    }
		    outputLine += "\n";
		    System.out.print(outputLine);
		    writer.write(outputLine);
		}
		   
		reader.close();
	    writer.close();	
	}
	
}
