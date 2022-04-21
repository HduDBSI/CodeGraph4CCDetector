package googlejam1.p579;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Mushrooms{
	public static void main(String args[]) throws IOException{
		String outFileName = "C:\\1A\\mushroom_large_out.out";
		File file = new File(outFileName);
		if(!file.exists()){
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\1A\\A-large.in"));
		String testCasesNumber;
		try {
			testCasesNumber = br.readLine();
			int testCases = Integer.parseInt(testCasesNumber);
			int caseNumber = 1;
			while(caseNumber<=testCases){
				
				int n = Integer.parseInt(br.readLine());
				String tokens[] = br.readLine().split(" ");
				int size = tokens.length;
				if(size != n){
					throw new IOException();
				}
				int mushrooms1[] = new int[size];
				int i1=0;
				for(String token : tokens){
					mushrooms1[i1++] = Integer.parseInt(token);
				}
				int mushrooms[] = mushrooms1;
				
				//	int size = a.length;
				int maxDiff = 0;
				int y = 0;
				
				for(int i = 1 ; i<n;i++){
					int diff = mushrooms[i-1] -mushrooms[i];
					if((diff > 0 )){
						y = y + diff;
					}
					if(diff > maxDiff){
						maxDiff = diff;
					}
				}
				
				int z= 0 ;
				for(int i=0 ; i< n-1; i++){
					int toAdd = (mushrooms[i] < maxDiff)?mushrooms[i]:maxDiff;
					z=z+toAdd;
				}
				
				bw.write("Case #"+caseNumber+": "+y+" "+z);
				bw.write("\n");
				
				caseNumber++;
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		bw.close();
		System.exit(0);

	}

}