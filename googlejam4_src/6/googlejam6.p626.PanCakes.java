package googlejam6.p626;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PanCakes
{
	HashMap<Integer, Integer> result;
	private Scanner scan;
	private int length, cases=0;
	private String inS;
	private char lastSeen; 
	private FileWriter fw;
	private ArrayList<Integer> output;
	
	public PanCakes() throws IOException
	{
		File outputFile = new File("/home/devil/java/testjava/src/Result.txt");
		this.fw = new FileWriter(outputFile);
		this.scan = new Scanner(new BufferedReader(new FileReader(new File("/home/devil/java/testjava/src/B-large.in"))));
		this.length = this.scan.nextInt();
		this.output= new ArrayList<Integer>();
		this.result = new HashMap<Integer, Integer>();
	}
	
	public static void main(String args[])
	{
		
		PanCakes flip;
		try {
			flip = new PanCakes();
			for(int i=0;i<flip.length;i++)
			{
				flip.cases++;
				Integer input = flip.scan.nextInt();
				int read = 0;
				for(int i1=0;i1<input*((2*input)-1);i1++)
				{
					read = flip.scan.nextInt();
					if(flip.result.containsKey(read))
						flip.result.put(read, flip.result.get(read)+1);
					else
						flip.result.put(read, 1);
				}
				for (Map.Entry<Integer, Integer> entry : flip.result.entrySet())
				{
					if(entry.getValue()%2==1)
						flip.output.add(entry.getKey());
				}
				Collections.sort(flip.output);
				StringBuilder builder = new StringBuilder();
				for(Integer fi: flip.output)
				{
					builder.append(fi);
					builder.append(" ");
				}
				flip.fw.write("Case #" + flip.cases + ": "+builder+ "\n");
				flip.output.clear();
				flip.result.clear();
			}
			flip.fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
