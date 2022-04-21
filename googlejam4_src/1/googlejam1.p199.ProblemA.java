package googlejam1.p199;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ProblemA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//String filenameInput = "A-sample.in";
		//String filenameOutput = "A-sample.out";
		
		//String filenameInput = "A-small-attempt0.in";
		//String filenameOutput = "A-small-attempt0.out";
		
		
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
				int minimum = 0;
				int constantSpeedMinimum = 0;
				int numberOfIntervals = Integer.parseInt(input.readLine());
				String[] inputStringArray = input.readLine().split(" ");
				int[] numOfMushrooms = new int[numberOfIntervals];
				for (int j=0;j<numberOfIntervals;j++) {
					numOfMushrooms[j] = Integer.parseInt(inputStringArray[j]);
				}
				int speed = 0;
				for(int j=0;j<numberOfIntervals-1;j++) {
					minimum += Math.max(0, numOfMushrooms[j]-numOfMushrooms[j+1]);
					speed  = Math.max(speed, numOfMushrooms[j]-numOfMushrooms[j+1]);
				}
				System.out.println(speed);
				for(int j=0;j<numberOfIntervals-1;j++) {
					constantSpeedMinimum += Math.min(speed, numOfMushrooms[j]);
					System.out.println(constantSpeedMinimum +" before " + j);
				}
				
				String outputString = "Case #"
						+ (i + 1)
						+ ": "
						+ minimum + " " + constantSpeedMinimum;
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
