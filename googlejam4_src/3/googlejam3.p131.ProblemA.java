package googlejam3.p131;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.ReverbType;

public class ProblemA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		String filenameInput = "A-sample.in";
//		String filenameOutput = "A-sample.out";
		
//		String filenameInput = "A-sample-b.in";
//		String filenameOutput = "A-sample-b.out";

//		 String filenameInput = "A-small-attempt0.in";
//		 String filenameOutput = "A-small-attempt0.out";
		 
//		 String filenameInput = "A-large-practice.in";
//		 String filenameOutput = "A-large-practice.out";
		 
		//
		 String filenameInput = "A-large.in";
		 String filenameOutput = "A-large.out";

		Class currentClass = ProblemA.class;
		try {

			String path = "src/"
					+ currentClass.getPackage().getName().replace(".", "/");
			BufferedReader input = new BufferedReader(new FileReader(new File(
					path + "/" + filenameInput)));
			BufferedWriter output = new BufferedWriter(new FileWriter(new File(
					path + "/" + filenameOutput)));
			int numOfTestcases = Integer.parseInt(input.readLine());
			// System.out.println("Number of Testcases: " + numOfTestcases);
			for (int i = 0; i < numOfTestcases; i++) {
				System.out.println("Testnumber : " + i);

				
				String[] inputStringArray = input.readLine().split(" ");
				int R = Integer.parseInt(inputStringArray[0]);
				int C = Integer.parseInt(inputStringArray[1]);
				int W = Integer.parseInt(inputStringArray[2]);
				
				int cOverW = C/W;
				int maxNumber = cOverW * (R-1);
				maxNumber += (cOverW-1);
				maxNumber += W;
				if(C%W!=0){
					maxNumber++;
				}
				


				String outputString = "Case #" + (i + 1) + ": " + maxNumber;
				System.out.println(outputString);

				if (i + 1 != numOfTestcases) {
					outputString += "\n";
				}
				output.write(outputString);

			}

			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
