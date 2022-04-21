package googlejam8.p972;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Arrays;

public class GameA {
	public final static String inpath = "//Users/simon/Downloads/B-small-attempt0.in";
	public final static String outpath = "//Users/simon/Downloads/A-small-result.txt";
	public static PrintWriter writer = null;
	public static Integer testint = null;

	public static void main(String[] args) throws IOException {
		int noOfCase = 0;
		
		writer = new PrintWriter(new File(outpath));

		try (BufferedReader br = new BufferedReader(new FileReader(inpath))) {

			String line =br.readLine();
			noOfCase = Integer.parseInt(line);
			//System.out.println("NoOfCase: " + noOfCase);
			String result = "";

			for (int caseNo = 0; caseNo < noOfCase; caseNo++) {
				int noOfParty =Integer.parseInt(br.readLine());	
				line = br.readLine();
				String[] lineSplit = line.split(" ");
				int[] senors = new int[noOfParty];
				String[] senParty = new String[noOfParty];
				result ="";
				int total = 0; 
				for (byte i=0; i<noOfParty; i++){
					senors[i] = Integer.parseInt(lineSplit[i]);
					total += senors[i];
					
					char c = 'A' ;
					c += i;
					senParty[i] = lineSplit[i] + c;
					//System.out.println(senParty[i] + " ");
				}
				
				
				while  (total>0){
					Arrays.sort(senParty);
					String maxParty = senParty[noOfParty-1];
					String maxPartyMinux = senParty[noOfParty-2];
					
					//System.out.println ("Test: " + maxParty + " , " + maxPartyMinux);
					
					if (total!=3){
							result = result + maxParty.charAt(1) + "";
							char c = maxParty.charAt(0);
							c = (char)( c - 1) ;
							senParty[noOfParty-1] = c + "" +  maxParty.charAt(1);
							
							if ( (maxPartyMinux.charAt(0) - '0') !=0){
								result = result + maxPartyMinux.charAt(1) ;
								c = maxPartyMinux.charAt(0);
								c = (char) (c- 1) ;
								senParty[noOfParty-2] = c + "" +  maxPartyMinux.charAt(1);								
							}								
							
							
							total = total -2;
					}else{
						result = result + maxParty.charAt(1) + "";
						char c = maxParty.charAt(0);
						c = (char)( c - 1) ;
						senParty[noOfParty-1] = c + "" +  maxParty.charAt(1);
						
						
						total = total -	1;						
						
					}
					if (total>0)
						result = result + " ";
				}
				String msg = String.format("Case #%d: %S ", caseNo+1, result);
				
				
				writer.println(msg);
				System.out.println(msg);

			}
			br.close();

		}
		writer.close();
		
	}	
	

}