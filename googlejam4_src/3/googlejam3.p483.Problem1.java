package googlejam3.p483;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Problem1 {
    public static void main(String[] args) {
	try {
	    BufferedReader reader = new BufferedReader(new FileReader("A-small-attempt1.in"));
		String line1 = null;
		List<String> lines1 = new ArrayList<String>();
		while((line1 = reader.readLine()) != null) {
		    lines1.add(line1);
		}
		reader.close();
		List<String> lines = lines1;
		List<String> outputLines = new ArrayList<String>();
		int index = 0;
		int testCases = Integer.parseInt(lines.get(index++));
		for(int t = 0; t < testCases; t++) {
		    String line = lines.get(index++);
		    String tokens[] = line.split(" ");
		    int R = Integer.parseInt(tokens[0]);
		    int C = Integer.parseInt(tokens[1]);
		    int W = Integer.parseInt(tokens[2]);
		    int count = 0;
		    if(C%W ==0) {
			count = C/W-1;
			int x = W;
			count = count + x;
		    }else {
			count = C/W-1;
			int x = W+1;
			count = count + x;
		    }
		    Object result = R * count;
		    String testCaseOutput = "Case #" + (t+1) + ": " + result;
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
		FileWriter writer = new FileWriter("A-small-attempt1.in".replace(".in", ".out"));
		writer.write(output);
		writer.close();
	}catch(Exception ex) {
	    ex.printStackTrace();
	}
    }


}
