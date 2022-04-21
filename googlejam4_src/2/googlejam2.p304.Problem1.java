package googlejam2.p304;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Problem1 {
    public static void main(String[] args) {
	try {
	    BufferedReader reader = new BufferedReader(new FileReader("A-small-attempt0.in"));
		String line = null;
		List<String> lines1 = new ArrayList<String>();
		while((line = reader.readLine()) != null) {
		    lines1.add(line);
		}
		reader.close();
		List<String> lines = lines1;
		List<String> outputLines = new ArrayList<String>();
		int index = 0;
		int testCases = Integer.parseInt(lines.get(index++));
		int max = 1000000;
		int[] counts = new int[max+1]; 
		Arrays.fill(counts, max);
		counts[1] = 1;
		for(int i=1;i<max;i++) {
		    counts[i+1] = Math.min(counts[i]+1, counts[i+1]);
			int num = i;
			long rev = 0;
			while (num != 0)
			{
			    rev = rev*10 + num % 10;
			    num /= 10;
			}
		    long r = rev;
		    if(r > max) {
			continue;
		    }
		    counts[(int)r] = Math.min(counts[i]+1, counts[(int)r]);
		}
		for(int t = 0; t < testCases; t++) {
		    int N = Integer.parseInt(lines.get(index++));
		    String testCaseOutput = "Case #" + (t+1) + ": " +counts[N];
		    System.out.println(testCaseOutput);
		    outputLines.add(testCaseOutput);
		}
		StringBuilder strValue = new StringBuilder("");
		if (outputLines != null) {
		    int i = 0;
		    for (Object v : outputLines) {
			String value = v.toString();
			if (i == 0) {
			    strValue.append(value);
			} else {
			    strValue.append("\n");
			    strValue.append(value);
			}
			i++;
		    }
		}
		String output = strValue.toString();
		FileWriter writer = new FileWriter("A-small-attempt0.in".replace(".in", ".out"));
		writer.write(output);
		writer.close();
	}catch(Exception ex) {
	    ex.printStackTrace();
	}
    }


}
