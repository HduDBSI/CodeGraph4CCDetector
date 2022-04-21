package googlejam1.p448;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian
 */
public class A
{

    private BufferedReader reader;
    private BufferedWriter writer;

    public static void main(String[] args)
    {
        A a = new A(args[0]);
        int numberOfTests = 0;
		
		try
		{
		    numberOfTests = Integer.parseInt(a.reader.readLine());
		}
		catch (NumberFormatException | IOException e)
		{
		    System.err.println("Failed to read line");
		    e.printStackTrace();
		    System.exit(-1);
		}
		
		for (int testCase = 1; testCase <= numberOfTests; testCase++)
		{
		    try
		    {
		        a.reader.readLine();
		
		        List<Integer> mushrooms = new ArrayList<>();
		        int maxRate = 0;
		        int lastMush = 0;
		
		        for (String mushroom : a.reader.readLine().split("\\s"))
		        {
		            int mush = Integer.parseInt(mushroom);
		
		            mushrooms.add(mush);
		
		            if (lastMush - mush > maxRate)
		            {
		                maxRate = lastMush - mush;
		            }
		
		            lastMush = mush;
		        }
				int methodA = 0;
				int methodB = 0;
				
				for (int i = 1; i < mushrooms.size(); i++)
				{
				    if (mushrooms.get(i) < mushrooms.get(i - 1))
				    {
				        methodA += mushrooms.get(i - 1) - mushrooms.get(i);
				    }
				
				    methodB += Math.min(maxRate, mushrooms.get(i - 1));
				}
		
		        String response = methodA + " " + methodB;
		
		        a.writer.write("Case #" + testCase + ": " + response + "\n");
		    }
		    catch (IOException e)
		    {
		        e.printStackTrace();
		        System.exit(-1);
		    }
		}
		
		try
		{
		    a.reader.close();
		    a.writer.flush();
		    a.writer.close();
		}
		catch (IOException e)
		{
		    e.printStackTrace();
		}
    }

    public A(String filename)
    {
        File file = new File(filename);
        try
        {
            reader = new BufferedReader(new FileReader(file));
            writer = new BufferedWriter(new FileWriter(file + ".out"));
        }
        catch (IOException e)
        {
            System.err.println("Failed to open FileReader");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
