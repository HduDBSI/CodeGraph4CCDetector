package googlejam1.p316;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
public class q1 {
	public static void main(String[] args) throws Exception {

		String inputLine;
		try{
			// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/vincent/Desktop/A-large.txt"));
			FileWriter fw = new FileWriter("C:/Users/vincent/Desktop/output.txt");
			inputLine = br.readLine();

			int testCaseNumber = 0;

			int[] inputData;

			while ((inputLine = br.readLine()) != null) {
				double maxDiff = 0;
				int currentInPlate = 0;
				int timesWeCheck = 0;

				testCaseNumber++;

				timesWeCheck = Integer.parseInt(inputLine);
				inputData = new int[timesWeCheck];

				inputLine = br.readLine();
				String[] inputParts = inputLine.split(" ");
				currentInPlate = Integer.parseInt(inputParts[0]);
				inputData[0] = currentInPlate;

				for (int i = 1; i < timesWeCheck; i++) {
					int newInPlate = Integer.parseInt(inputParts[i]);
					int currentDiff = currentInPlate - newInPlate;
					if (currentDiff >= 0 && currentDiff > maxDiff) {
						maxDiff = currentDiff;
					}
					currentInPlate = newInPlate;
					inputData[i] = newInPlate;
				}
				int answer1 = 0;
				
				for (int i = 0; i < inputData.length-1; i++) {
					int currentOnPlate = inputData[i];
					int nextOnPlate = inputData[i+1];
					int diff = currentOnPlate - nextOnPlate;
					if (diff > 0) {
						answer1 += diff;
					}
				}

				int answer = answer1;
				double rate = maxDiff/10;
				int answer3 = 0;
				
				for (int i = 0; i < inputData.length-1; i++) {
					int currentOnPlate = inputData[i];
					if (currentOnPlate - inputData[i+1] >= 0) {
						if (currentOnPlate >= rate*10) {
							answer3 += rate*10;
						} else {
							answer3 += currentOnPlate;
						}
					} else {
						if (currentOnPlate < rate*10) {
							answer3 += currentOnPlate;
						} else {
							answer3 += rate*10;
						}
					}
				}
				int answer2 = answer3;
				String output = "Case #" + testCaseNumber + ": " + answer + " " + answer2 + "\n";
				fw.write(output);
			}
			fw.close();
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}