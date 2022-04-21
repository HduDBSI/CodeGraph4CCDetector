package googlejam6.p674;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RankFile {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferReader = new BufferedReader(new FileReader("C:\\Users\\anaka\\Desktop\\trial.in"));
		int noOfTestCases = Integer.parseInt(bufferReader.readLine());
		List resultList = new ArrayList();
		for (int count = 0; count < noOfTestCases; count++) {
			int number =  Integer.parseInt(bufferReader.readLine());
			int[] heights = new int[2501];
			for(int i=1; i<=2*number-1; i++){
				String line = bufferReader.readLine();
				String[] splitLine = line.split("\\s+");
				for(int j=0; j<splitLine.length; j++){
					int parsedInt = Integer.parseInt(splitLine[j]);
					if(heights[parsedInt] == 0){
						heights[parsedInt] = 1;
					}else{
						heights[parsedInt] = heights[parsedInt] + 1;
					}
				}
			}
			resultList.add(heights);
		}
		bufferReader.close();
		File file = new File("C:\\Users\\anaka\\Desktop\\output.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for (int count = 0; count < resultList.size(); count++) {
			int testCaseNumber = count + 1;
			bufferedWriter.write("Case #" + testCaseNumber + ": ");
			int[] result = (int[]) resultList.get(count);
			for(int i=0; i<result.length; i++){
				if (result[i] % 2 != 0) {
					bufferedWriter.write(i + " ");
			    }
			}
			bufferedWriter.write(System.lineSeparator());
		}
		bufferedWriter.close();
	}

}
