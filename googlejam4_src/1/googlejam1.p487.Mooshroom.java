package googlejam1.p487;
import java.io.*;
import java.util.*;

public class Mooshroom
{
  public static void main (String [] args) throws IOException
  {
    BufferedReader input = new BufferedReader (new FileReader ("A-large.in"));
    PrintWriter output = new PrintWriter (new FileWriter ("output.txt"));
    int count = Integer.parseInt (input.readLine ());
    for (int counter = 1; counter <= count; counter ++)
    {
      int numberOfVars = Integer.parseInt (input.readLine ());
      String [] vars = input.readLine ().split (" ");
      int [] variables = new int [numberOfVars];
      for (int x = 0; x < numberOfVars; x ++)
        variables [x] = Integer.parseInt (vars [x]);
      int totalFirst = 0;
      for (int x = 1; x < numberOfVars; x ++)
      {
        if (variables [x - 1] > variables [x])
          totalFirst += variables [x-1] - variables [x]; //prev minus current
      }
      
      int totalSecond = 0;
      int largestDiff = 0;
      for (int x = 1; x < numberOfVars; x ++)
      {
        if (variables [x - 1] > variables [x])
        {
          if (largestDiff < variables [x - 1] - variables [x])
            largestDiff = variables [x - 1] - variables [x];
        }
      }
      int firstVal = variables [0];
      for (int x = 1; x < numberOfVars; x ++) //largest diff = 10
      {
        if (variables [x-1] - largestDiff < 0)
        {
          totalSecond += variables [x-1];
        }
        else
          totalSecond += largestDiff;
        
      }
      
      
      
      output.println ("Case #" + counter + ": "+totalFirst + " " + totalSecond);
    }
    output.close ();
  }
}