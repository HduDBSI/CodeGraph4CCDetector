package googlejam1.p484;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class App {
	public static final String INPUT_FILE_NAME = "input.txt";
	public static final String OUTPUT_FILE_NAME = "output.txt";
	
	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();
		
		try {
			String inputName = INPUT_FILE_NAME;
			String outputName = OUTPUT_FILE_NAME;
		
			if (args.length > 0)
				inputName = args[0];
		
			if (args.length > 1)
				outputName = args[1];
		
			try (BufferedReader reader = new BufferedReader(new FileReader(new File(inputName)))) {
				try (PrintWriter writer = new PrintWriter(outputName)) {
					int nCases = Integer.parseInt(reader.readLine());
				
					for (int nCase = 0; nCase < nCases; ++nCase) {
						int n = Integer.parseInt(reader.readLine());
						String[] data = reader.readLine().split(" ");
						
						int counter1= 0;
						int counter2= 0;
						int prev = 0;
						int pace = 0;
						
						for (int i = 0; i < n; ++i) {
							int mushrums = Integer.parseInt(data[i]);
							
							if (prev > mushrums) {
								counter1 += prev - mushrums;
							
								if (pace < (prev - mushrums)) 
									pace = prev - mushrums;
							}
							prev = mushrums;
						}
							
						for (int i = 0; i < n-1; ++i) {
							int mushrums = Integer.parseInt(data[i]);
							if (mushrums > pace)
								counter2 += pace;
							else
								counter2 += mushrums;
						}

						String out = "Case #" + (nCase + 1) + ": " + counter1 + " " + counter2;
						System.out.println(out);
						writer.println(out);
						//writer.println("Case #" + (nCase + 1) + ": " + (richardWon ? "RICHARD" : "GABRIEL"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(String.format("Done. Spend %d ms", endTime - beginTime));
	}
}
