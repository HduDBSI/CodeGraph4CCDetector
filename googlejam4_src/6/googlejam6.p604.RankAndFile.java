package googlejam6.p604;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class RankAndFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		try(BufferedReader br = new BufferedReader(new FileReader("B-large.in"))) {
			Writer writer = new BufferedWriter(new OutputStreamWriter(
		            new FileOutputStream("outputRaFLARGE.txt"), "utf-8"));
			

			int cases = Integer.parseInt(br.readLine());

			for (int i=1; i<=cases; i++) {
				if (i>1) 
					writer.write(System.getProperty("line.separator"));
				writer.write("Case #" + i + ": ");
				int N = Integer.parseInt(br.readLine());
				int rows = (N*2)-1;
				ArrayList<Integer> allNumbers = new ArrayList<Integer>();

				for (int j=1; j<=rows; j++) {
					String singleRow = br.readLine();
					
					StringTokenizer tokens = new StringTokenizer(singleRow, " ");
					while(tokens.hasMoreTokens()){
						String singleNumberString = tokens.nextToken();
						int thisNumber = Integer.parseInt(singleNumberString);
						if (allNumbers.contains(thisNumber)) { 
							allNumbers.remove(new Integer(thisNumber));
						}
						else {	
							allNumbers.add(thisNumber); 
						}
					}


				}

				Collections.sort(allNumbers);
				
				for (Integer number : allNumbers) {
				writer.write(number.toString());
				writer.write(" ");
				}


			}
			
			writer.close();








		}

	}

}
