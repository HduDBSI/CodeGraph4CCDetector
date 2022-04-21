package googlejam1.p457;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemA {
  
  public static void main(String[] args) {
    try {
      File input = new File(System.getProperty("inputFile"));

      FileReader fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);
			StringBuilder output1 = new StringBuilder();
			Integer cases = Integer.valueOf(br.readLine());
			for(int i = 1; i <= cases; i++) {
					int n = Integer.parseInt(br.readLine());
			  String caseInput = br.readLine();
			  String[] split = caseInput.split(" ");
					int[] mushrooms = new int[split.length];
					for (int j = 0; j < mushrooms.length; j++) {
						mushrooms[j] = Integer.parseInt(split[j]);
					}
			
					int method1 = 0;
					int maxDiff = 0;
					for (int j = 1; j < mushrooms.length; j++) {
						if (mushrooms[j] < mushrooms[j-1]) {
							int diff = mushrooms[j-1] - mushrooms[j];
							method1 += diff;
							if (diff > maxDiff) {
								maxDiff = diff;
							}
						}
					}
			
					int method2 = 0;
					for (int j = 1; j < mushrooms.length; j++) {
						if (mushrooms[j-1] < maxDiff) {
							method2 += mushrooms[j-1];
						} else {
							method2 += maxDiff;
						}
					}
			
			  output1.append(String.format("Case #%d: %d %d", i, method1, method2));
			  if (i != cases) {
			    output1.append("\n");
			  }
			}

      String result = output1.toString();
    
      File output = new File(System.getProperty("outputFile"));
      FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
      bw.write(result);
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
