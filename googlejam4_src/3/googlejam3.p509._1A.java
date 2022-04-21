package googlejam3.p509;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class _1A {

	public static void main(String[] args) throws IOException {
		
			BufferedReader br = null;
			PrintWriter pw = new PrintWriter("output.txt");

			String line;
			int maxCaseNum = 0;
 
			br = new BufferedReader(new FileReader("input.txt"));
			maxCaseNum = Integer.valueOf(br.readLine());
 
			for (int caseIdx = 1; caseIdx <= maxCaseNum; caseIdx++) {
				//String N = br.readLine();
				line = br.readLine();
				String[] array = line.split(" ");
				int row = Integer.valueOf(array[0]);
				int col = Integer.valueOf(array[1]);
				int shipW = Integer.valueOf(array[2]);
				int ans = 0;
				
				if (col == shipW)
					ans = row*col;
				else if (shipW == 1)
					ans = row*col;
				else {
					if (col % shipW == 0) {
						ans = ((col/shipW) + (shipW-1)) * row;
					}
					else {
						ans = ((col/shipW) + (shipW-1) + 1) * row;
					}
				}

				
				
				System.out.println("Case #" + caseIdx + ": " + ans);
				
				pw.println("Case #" + caseIdx + ": " + ans  );

			}
			
			br.close();
			pw.close();
			
			System.out.println("Done");
			
			

	}

}
