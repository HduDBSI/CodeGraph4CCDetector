package googlejam6.p365;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	
	public static void main(String[] args){
		// Construct BufferedReader from FileReader
		String fileName = "C://GoogleCodeJam/input.in";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fileName));
		
		String line1 = null;
		int nLine = 0;
		int nCases = 0;
		
		int currentCase = 0;
		int currentN = 0;
		int N = 0;
		boolean readN = false;
		
		while ((line1 = br.readLine()) != null) {
			if(nLine > 0){
				if(currentCase < nCases){
				//System.out.println(line);
				if(!readN){
					N = Integer.valueOf(line1);
					InputUtils.inputs[currentCase] = new String[2*N-1];
					readN = true;
				}else{
					InputUtils.inputs[currentCase][currentN] = line1;
					currentN++;
					if(currentN >= 2*N-1){
						currentN = 0;
						readN = false;
						N = 0;
						currentCase++;
					}
				}
				}else{
					break;
				}
			}else{
				nCases = Integer.valueOf(line1);
				InputUtils.inputs = new String[nCases][];
			}
			nLine++;
		}
		
		br.close();
		
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		List<String> solutionList = new ArrayList<String>();
		int T = InputUtils.inputs.length;

		System.out.println("COMPUTING...");
		for (int nCase = 1; nCase <= T; nCase ++) {
			// CODE STARTS HERE //
			  int NumMax = InputUtils.inputs[nCase-1].length;
			  boolean[] numbers = new boolean[2501];
			  Arrays.fill(numbers, false);
			  List<Integer> solution = new ArrayList<Integer>();
			  
			  for(int i = 0; i < NumMax; i++){
				  String[] line = InputUtils.inputs[nCase-1][i].split(" ");
				  for(int j = 0; j < line.length; j++){
					  if(numbers[Integer.valueOf(line[j])]){
						  numbers[Integer.valueOf(line[j])] = false;
					  }else{
						  numbers[Integer.valueOf(line[j])] = true;
					  }
				  }
			  }
			  
			  for(int k = 0; k < numbers.length; k++){
				  if(numbers[k]) solution.add(k);
			  }
			  
			  Collections.sort(solution);
		      
			  String caseString = "";

			  for (int s : solution)
			  {
				  caseString += s + " ";
			  }
			  
			  caseString = caseString.trim();
			   
		      System.out.println("Case #"+nCase+": "+caseString);
		      solutionList.add("Case #"+nCase+": "+caseString);
		      // CODE ENDS HERE //
		}
		
		System.out.println("DONE!");
		
		FileWriter writer;
		try {
			writer = new FileWriter("C://GoogleCodeJam/output.in");
			for(String str: solutionList) {
				  writer.write(str + System.getProperty("line.separator"));
				}
				writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
}

