package googlejam6.p523;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class B {

	public static void main(String[] args) {

//		String in = "/Users/Moshin/Code Jam//small.in";
//		String out = "/Users/Moshin/Code Jam/small.out";
		String in = "/Users/Moshin/Code Jam/large.in";
		String out = "/Users/Moshin/Code Jam/large.out";
	
		try {

			BufferedReader bufferedReader = new BufferedReader(new FileReader(in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(out));

			// Total number of test cases
			int noOfTestCases = Integer.valueOf(bufferedReader.readLine());
			
			
		
			for (int t = 0; t < noOfTestCases; t++){
                
                List<Integer> distinctHeights = new ArrayList<>();
                Map<Integer,Integer> heightCounts = new HashMap<>();
                List<Integer> resultArray = new ArrayList<>();
                
                int n = Integer.parseInt(bufferedReader.readLine());
                int l = 2*n-1;
                for(int i=0; i<l; i++){
                	
                    String line = bufferedReader.readLine();
                    String[] heights = line.split(" ");
                    
                    for(String tempHeight:heights) {
                    	
                        int height = Integer.valueOf(tempHeight);
                        
                        if(distinctHeights.contains(height)) heightCounts.put(height,heightCounts.get(height)+1);

                        else {
                        
                        	distinctHeights.add(height);
                            heightCounts.put(height, 1);
                        
                        }
                    }
                    
                }
                
                for(Integer tempHeight:distinctHeights)
                	if(heightCounts.get(tempHeight)%2==1)
                		resultArray.add(tempHeight);
                
                Collections.sort(resultArray);
                
                
                bufferedWriter.write("Case #" + (t + 1) + ": " + resultArray.toString().replace("[", "").replace("]", "").replaceAll(",","") + "\n");

                

            }
                
            bufferedReader.close();
            bufferedWriter.close();

		}catch (Exception exception) {
			
			exception.printStackTrace();
		
		}

	}



}
