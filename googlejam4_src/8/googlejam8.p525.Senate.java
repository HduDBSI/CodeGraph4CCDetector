package googlejam8.p525;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* Solution to codejame 1C question 1 2016 */


public class Senate {
	
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
						
			int numTests = input.nextInt();
			
			int i;
			
			for(i = 0; i < numTests; i++) {
				
				System.out.println("\nTest #" + i);
				
				int numParties = input.nextInt();
				
				//We will add the members to the room and then reverse the order.
				
				//An array to hold the remaining party members to be added.
				int[] partyMembersOutside = new int[numParties];
				int totalMembers = 0;
				
				int j;
				
				for(j=0; j<numParties; j++) {
					
					partyMembersOutside[j] = input.nextInt();
					totalMembers += partyMembersOutside[j];
					
				}
				
				//An array to hold how many members are in the room already
				int membersInside = 0;
				
				//Also create an arraylist of strings to store the members going in
				//This will need to be reversed at the end
				ArrayList<String> entries = new ArrayList<String>();
				
				//Add from the start of the alphabet ensuring that people always go in in twos s.t. the two being added are different
				int k;
				for(k = 0; k < numParties; k++) {
					System.out.println(k);
					while(partyMembersOutside[k] > 0) {
						//Add members from party k with any other members
						int m;
						boolean added = false;
						
						for(m = k+1; m < numParties && !added; m++) {
							
							if(partyMembersOutside[m] > 0) {
								//Add k and m
								partyMembersOutside[m]--;
								partyMembersOutside[k]--;
								
								char charM = (char) (65 + m);
								char charK = (char) (65 + k);
								String entry = " " + charM + charK;
								
								System.out.println(entry);
								
								entries.add(entry);
								
								added = true;
							}
							
						}
						
						while(!added && partyMembersOutside[k] > 0) {
							char charK = (char) (65 + k);
							partyMembersOutside[k]--;
							
							String entry = " " + charK;
							entries.add(entry);
							
						}
						
					}
					
				}
				
				Collections.reverse(entries);
				writer.write("Case #" + (i+1) + ":");
				for(String string: entries) {
					writer.write(string);
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
