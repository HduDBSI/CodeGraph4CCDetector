package googlejam6.p568;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class RankFile {

	public static void main(String[] args) throws IOException {
		File inFile = new File("yearOf2016/B-large.in");
		File outFile = new File("yearOf2016/testOutput.txt");
		if (!outFile.exists()) {
		     outFile.createNewFile();
		  }
		
		Scanner reader = new Scanner(inFile);
		PrintWriter writer = new PrintWriter(outFile);
		
		int cases = reader.nextInt();
		int caseIdx = 1;
		
		while(caseIdx <= cases){
			int N = reader.nextInt();
			HashMap<Integer, Integer> numList = new HashMap<>();
			for(int n = 0; n < (2*N - 1)*N; n++){
				int s = reader.nextInt();
				if(!numList.containsKey(s)){
					numList.put(s, 1);
				}
				else{
					int temp = numList.get(s);
					numList.put(s, temp+1);
				}
			}
			
			ArrayList<Integer> result = new ArrayList<>();
			
			for(int key : numList.keySet()){
				if(numList.get(key) % 2 != 0){
					result.add(key);
				}
			}
			
			Collections.sort(result);
			writer.print("Case #" + caseIdx + ":");
			
			for(int r : result){
				writer.print(" "+ r);
			}
			writer.println(" ");
			
			caseIdx += 1;
		}
		
		reader.close();
		writer.close();

	}

}