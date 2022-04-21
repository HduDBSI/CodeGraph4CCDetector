package googlejam3.p477;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Battleship
{
    public static void main(String[] args) throws NumberFormatException, IOException
    {
        BufferedReader input = new BufferedReader(new FileReader(args[0]));
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(args[0].contains("in") ?
                args[0].replace("in", "out") : args[0] + ".out"));
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++)
        {
            String[] tokens = input.readLine().split(" ");
			int r = Integer.parseInt(tokens[0]), c = Integer.parseInt(tokens[1]), w = Integer.parseInt(tokens[2]);
			int rc = c / w +  w - 1;
			if( c % w != 0) 
			    rc++;
			String solution = (rc * r) + "";
            out.write("Case #" + (i + 1) + ": " + solution + "\n");
        }
        input.close();
        out.close();
    } 
}