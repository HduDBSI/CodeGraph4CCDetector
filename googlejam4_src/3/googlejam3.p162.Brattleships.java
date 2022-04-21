package googlejam3.p162;
import java.io.*;
import java.util.*;
//May 10, 2015
public class Brattleships 
{
  public static void main (String [] args) throws IOException
  {
    BufferedReader input = new BufferedReader (new FileReader ("A-large (1).in"));
    PrintWriter output = new PrintWriter (new FileWriter ("output.txt"));
    int count = Integer.parseInt(input.readLine ());
    
    for (int counter = 1; counter <= count; counter ++)
    {
      String [] variables = input.readLine ().split (" ");
      
      int rows = Integer.parseInt (variables [0]);
      int columns = Integer.parseInt (variables [1]);
      int width = Integer.parseInt (variables [2]);
      
      int answer = rows*((int)Math.floor ((columns*1.0)/(width*1.0))) + width;
      if (columns % width == 0)
        answer --;
      
      
      
      
      
      output.println ("Case #" + counter + ": " + answer);
    }
    output.close ();
  }
}