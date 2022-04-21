package googlejam8.p776;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Av2 {

	public static void main(String args[]) throws IOException{
		// 0. My Small Practice
		//FileReader reader = new FileReader("test_case_gcj2016Round1c/A-mysmall-practice.in");
		//FileWriter writer = new FileWriter("test_case_gcj2016Round1c/A-mysmall-practice.out");

		// 1. Small Practice
		// Judged response for input A-small: Correct!
		//FileReader reader = new FileReader("test_case_gcj2016Round1c/A-small-attempt0.in");
		//FileWriter writer = new FileWriter("test_case_gcj2016Round1c/A-small-attempt0.out");

		// 2. Large Practice
		FileReader reader = new FileReader("test_case_gcj2016Round1C/A-large.in");
		FileWriter writer = new FileWriter("test_case_gcj2016Round1C/A-large.out");
		
		
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
        int noOfCases = Integer.parseInt(line);
        System.out.println(noOfCases);
		        
        for (int i = 1; i <= noOfCases; i++){
			// 1. read data
        	line = bufferedReader.readLine();
        	int n = Integer.parseInt(line);
        	line = bufferedReader.readLine();
        	
        	String[] nos = line.split(" ");
		    int[] arr = Arrays.asList(nos).stream().mapToInt(Integer::parseInt).toArray();
			String res1 = "";
			
			int sum = IntStream.of(arr).sum();
			
			while (sum > 0){
				int res3 = -1;
				int max1 = -1;
				
				for (int i2 = 0; i2 < arr.length; i2++){
					if (arr[i2] > max1){
						max1 = arr[i2];
						res3 = i2;
					}
				}
				int maxPos1 = res3;
				int res2 = -1;
				int max = -1;
				
				for (int i1 = 0; i1 < arr.length; i1++){
					if (arr[i1] > max && arr[i1] <= arr[maxPos1] && i1 != maxPos1){
						max = arr[i1];
						res2 = i1;
					}
				}
				int maxPos2 = res2;
				sum--;
				res1 += String.valueOf(Character.toChars(65 + maxPos1));
				arr[maxPos1]--;
				if (sum != 2){
					// take 2
					sum--;
					res1 += String.valueOf(Character.toChars(65 + maxPos2));//Character.toString ((char) 65 + maxPos[0]);
					arr[maxPos2]--;
				}
				res1 += " ";
			}
        	
		    String res = res1;
		    String outputLine = "Case #" + i + ": " + res + "\n";
		    System.out.print(outputLine);
		    writer.write(outputLine);
		}
		   
		reader.close();
	    writer.close();	
	}

}
