package googlejam3.p345;
import java.util.*;
import java.io.*;

public class A
{
    public static void main(String [] args) throws Exception
    {
        Scanner input = new Scanner(new File("in"));
        FileWriter output = new FileWriter(new File("out"));
        int numCases = input.nextInt();
        for (int n = 1; n <= numCases; n++)
        {
            int R = input.nextInt();
            int C = input.nextInt();
            int W = input.nextInt();
            
            int result=C/W;
            result=result*R;
            result=result+W;
            if(C%W==0)
            	result--;
            
            System.out.print("Case #"+ n +": " + result + "\n");
            output.write("Case #"+ n +": " + result + "\n");
        }
        output.flush();
        output.close();
    }
}
