package googlejam1.p479;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CodeJam2015Round1A {
	
	
	public static void main(String[] args) throws IOException {
		File f = new File("input.txt");
		FileInputStream fis = new FileInputStream(f);
		
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		ArrayList<String> stringRows = new ArrayList<>();
		String line;
		while ((line = br.readLine()) != null) {
			stringRows.add(line);
		}
		br.close();
		rows = stringRows;
		int totProblems = Integer.parseInt(rows.get(curRow++));
		for (int curProblem = 1; curProblem <= totProblems; curProblem++) {
			int numTimes = Integer.parseInt(rows.get(curRow++));
			String[] mushroomCountsStrs = rows.get(curRow++).split(" ");
			List<Integer> mushCounts = new ArrayList<>();
			for (String count : mushroomCountsStrs) {
				mushCounts.add(Integer.parseInt(count));
			}
			int totEaten = 0;
			Integer lastCount = null;
			for (Integer mushCount : mushCounts) {
				if (lastCount != null) {
					if (lastCount > mushCount) {
						totEaten += lastCount - mushCount;
					}
				}
				lastCount = mushCount;
			}
			int anyRateSol = totEaten;
			int minRate = 0;
			Integer lastCount1 = null;
			for (Integer mushCount2 : mushCounts) {
				if (lastCount1 != null) {
					if (lastCount1 > mushCount2) {
						minRate = Math.max(minRate, lastCount1 - mushCount2) ;
					}
				}
				lastCount1 = mushCount2;
			}
			
			int totEaten1 = 0;
			lastCount1 = null;
			for (Integer mushCount1 : mushCounts) {
				if (lastCount1 != null) {
					totEaten1 += Math.min(lastCount1, minRate);
				}
				lastCount1 = mushCount1;
			}
			int constRateSol = totEaten1;
			
        	System.out.println("Case #" + curProblem +": " + anyRateSol + " " + constRateSol);
		}
	}
	
	private static int curRow = 0;
	private static ArrayList<String> rows;

}
