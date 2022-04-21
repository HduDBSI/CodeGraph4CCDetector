package googlejam6.p640;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Scanner;

import qualificationround.CountingSheep;

public class TheLastWord {

	private File file = null;
	private Scanner in = null;
	private Writer out = null;
	private Integer testCases = null;
	private String sequence = null;
	private String result = null;

	private int sizeLimit = 10;
	private boolean solution;
	private int count;
	private static Charset UTF8 = Charset.forName("UTF-8");

	public static void main(String args[]) throws IOException {

		try {
			TheLastWord word = new TheLastWord();
			word.file = new File("input.txt");
			word.in = new Scanner(word.file);
			word.out = new FileWriter("output.txt");
			int c;
			c = word.in.nextInt();
			word.testCases = new Integer(c);
			for (int i = 1; i <= word.testCases; i++) {
				word.sequence = word.in.next();
				word.result = "Case #" + i + ": ";
				
				String sequenceSol="";
				sequenceSol+=word.sequence.charAt(0);
				for(int i1=1; i1<word.sequence.length(); i1++)
				{
					if(Integer.valueOf(word.sequence.charAt(i1))>=Integer.valueOf(sequenceSol.charAt(0)))
					{
						sequenceSol=word.sequence.charAt(i1)+sequenceSol;
					}
					else
					{
						sequenceSol=sequenceSol+word.sequence.charAt(i1);
					}
				}
				
				
				
				
				word.result +=sequenceSol;
			
				word.result = word.result + "\n";
				word.out.write(word.result);
			
			}
			word.in.close();
			word.out.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
