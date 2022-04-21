package googlejam6.p288;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class q2 {

	public static void main(String[] args) {
		BufferedReader reader = null;
		File file = new File("C:\\Users\\vincent\\workspace\\code jam\\src\\r1a\\B-large.txt");
		File answer = new File("C:\\Users\\vincent\\workspace\\code jam\\src\\r1a\\output.txt");
	    Writer writer = null;
		try{
			reader = new BufferedReader(new FileReader(file));
			writer = new BufferedWriter(new OutputStreamWriter(
		    		new FileOutputStream(answer), "utf-8"));
		    String text = null;
		    
		    text = reader.readLine();
		    int numberOfTestCases = Integer.parseInt(text);
		    int index = 1;

		    while (numberOfTestCases > 0) {
			    text = reader.readLine();
			    int N = Integer.parseInt(text);
				List<Integer> digits = new ArrayList<Integer>();
				for (int i = 0; i < 2*N-1; i++) {
					String entry = reader.readLine();
					String[] entries = entry.split(" ");
					for (int j = 0; j < entries.length; j++) {
						int number = Integer.valueOf(entries[j]);
						if (digits.contains(number)) {
							digits.remove((Integer) number);
						} else {
							digits.add(number);
						}
					}
				}
				Collections.sort(digits);
				String answer2 = ""; 
				for (int digit : digits) {
					answer2 = answer2 + digit + " ";
				}
		    	String answer1 = answer2.substring(0, answer2.length()-1);
				writer.write("Case #" + String.valueOf(index) + ": " + answer1 + "\n");
		    	numberOfTestCases--;
		        index++;
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		        if (writer != null) {
		        	writer.close();
		        }
		    } catch (IOException e) {
		    }
		}
		System.out.println("done");
	}

}
