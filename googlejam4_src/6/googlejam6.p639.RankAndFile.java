package googlejam6.p639;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RankAndFile {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
		
		int totalCases = Integer.parseInt(br.readLine());
		
		for(int i=0;i<totalCases;i++){
			int n = Integer.parseInt(br.readLine());
			int[] counter = new int[2501];
			int linesGiven = 2*n-1;
			String missingLine1 ="";
			for(int i1=0;i1<linesGiven;i1++){
				String temp = br.readLine();
			
				String[] tempArray = temp.split(" ");
				
				for(int i2=0; i2<tempArray.length;i2++){
					int index = Integer.parseInt(tempArray[i2]);
					counter[index]++;
				}
			}
			String line = "";
			for(int i1=0;i1<counter.length;i1++){
				if(counter[i1]!=0){
					if(counter[i1]%2!=0){
						line=line + " " + i1;
					}
				}
			}
			missingLine1 = line;
			String missingLine = missingLine1;
			String result = "Case #" + (i+1) + ": " + missingLine;
			bw.write(result);
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
