package googlejam8.p824;


import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloWorld {
	private static String inputFileName = "/Users/Combo/Downloads/A-large.in.txt";
	private static String outputFileName = "/Users/Combo/Downloads/output1C1large.txt";
	private static Charset charset = Charset.forName("UTF-8");

	public static void main(String[] args) {
		List<String> fileContent = null;
		try {
			fileContent = Files.readAllLines(Paths.get(inputFileName), charset);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int noOfCase = Integer.parseInt(fileContent.get(0));

		List<String> outputLines = new ArrayList<String>();
		Path outputFiles = Paths.get(outputFileName);

		int currentReadingLine = 0;
		
		for (int i = 0; i < noOfCase; i++) {
			currentReadingLine++;
			int noOfParties = Integer.parseInt(fileContent.get(currentReadingLine));
			currentReadingLine++;
			String partiesSize[] = ((String) fileContent.get(currentReadingLine)).split(" ");
			
			int totalNoOfSenator = 0;
			
			int partiesSizeInt[] = new int[noOfParties];
			for (int j=0;j<noOfParties;j++) {
				int partySize = Integer.parseInt(partiesSize[j]);
				partiesSizeInt[j] = partySize;
				totalNoOfSenator += partySize;
			}
			
			int counter=0;
			StringBuffer evacuationFlow = new StringBuffer(); 

			while (totalNoOfSenator >0) {
				int maxParty = -1;
				int maxPartyPerson =0;
				for (int j=0;j<noOfParties;j++) {
					if (partiesSizeInt[j]> maxPartyPerson) {
						maxParty=j;
						maxPartyPerson = partiesSizeInt[j];
					}
				}
				if (maxParty!=-1) {
					char senator = (char) (maxParty+65);
					partiesSizeInt[maxParty]= partiesSizeInt[maxParty]-1;
					totalNoOfSenator--;
					boolean overRatio = false;
					if (totalNoOfSenator>=1) {
						for (int j=0;j<noOfParties;j++) {
							if ((partiesSizeInt[j]/totalNoOfSenator)>0.5) {
								overRatio = true;
							} 
						}
					} 
					
					if (overRatio) {
						if (counter%2!=0) {
							evacuationFlow.append(' ');
						}
						evacuationFlow.append(senator);
						counter=0;
					} else {
						evacuationFlow.append(senator);
					}
					
					counter++;
					if (counter%2==0) {
						evacuationFlow.append(' ');
					}
					
				}
			}
 			
			String answer = "Case #"+(i+1)+": "+ evacuationFlow.toString().trim();
			System.out.println(answer);
			outputLines.add(answer);
		}
		try {
			Files.write(outputFiles, outputLines, charset);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
