package googlejam1.p292;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Problem1 {
    public static void main(String[] args) {
	try {
	    BufferedReader reader = new BufferedReader(new FileReader("A-large.in"));
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
		for(int t = 0; t < testCases; t++) {
		    String[] tokens = lines.get(index++).split(" ");
		    int intervals = Integer.parseInt(tokens[0]);
		    String[] strs = lines.get(index++).split(" ");
		    int[] pieces = new int[intervals];
		    for(int i = 0; i < strs.length; i++) {
			pieces[i] = Integer.parseInt(strs[i]);
		    }
		    int method1 = 0;
		    int max = 0;
		    int[] decays = new int[intervals]; 
		    for(int i = 1; i < intervals; i++) {
			if(pieces[i] < pieces[i-1]) {
			    int decay = pieces[i-1] - pieces[i];
			    method1 += decay;
			    max = Math.max(max, decay);
			    decays[i] = decay;
			}
		    }
		    int method2 = 0;
		    for(int i = 1; i < intervals; i++) {
			int decay = Math.min(pieces[i-1], max);
			method2 += decay;
		    }
		    String testCaseOutput = "Case #" + (t+1) + ": " + method1 + " " + method2;
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
		FileWriter writer = new FileWriter("A-large.in".replace(".in", ".out"));
		writer.write(output);
		writer.close();
	}catch(Exception ex) {
	    ex.printStackTrace();
	}
    }


}
