package googlejam6.p348;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

/** https://code.google.com/codejam/contest/4304486/dashboard#s=p1 */

public class RankFile {
	
	public static void main(String[] args) {
		
		if(args.length == 0) {
			
			System.out.println("No arguments provided");
			return;
			
		}
		
		try {
			
			File file = new File(args[0]);
			Scanner input = new Scanner(file);
			FileWriter fileOut = new FileWriter("output.txt");
			BufferedWriter writer = new BufferedWriter(fileOut);
						
			//Simple. Find the numbers which appear an odd number of times in the given lists then order them.
			
			int numTests = input.nextInt();
			
			int i;
			
			for(i = 0; i < numTests; i++) {
				
				int lineLength = input.nextInt();
				
				//Read in the 2*n - 1 lines. Storing the heights in a hashtable
				//key =  height, value =  num occurances
				Hashtable<Integer, Integer> heights = new Hashtable<Integer, Integer>();
				int j;
				
				for(j = 0; j < (2*lineLength - 1)*lineLength; j++) {
					
					Integer nextHeight = input.nextInt();
					
					if(heights.containsKey(nextHeight)) {
						heights.put(nextHeight, new Integer(heights.get(nextHeight)+1));
					} else {
						heights.put(nextHeight, 1);
					}
					
				}
				
				//Put all odd occurance heights in an arrayList
				ArrayList<Integer> oddHeights = new ArrayList<Integer>();
				
				for(Integer height : heights.keySet()) {
					
					if(heights.get(height)%2 == 1) {
						
						oddHeights.add(height);
						
					}
					
				}
				
				//Sort the arrayList
				Collections.sort(oddHeights);
				
				//Print it
				writer.write("Case #" + (i+1) +  ":");
				for(j = 0; j < oddHeights.size(); j++) {
					
					writer.write(" " + oddHeights.get(j));
					
				}
				writer.write("\n");
				
			}
			
			writer.close();
			fileOut.close();
			input.close();
			
		} catch(FileNotFoundException e) {
			
			System.out.println("Error reading input file");
			
		} catch(IOException e) {
			
			System.out.println("Error writing output");
			
		}
		
	}

}
