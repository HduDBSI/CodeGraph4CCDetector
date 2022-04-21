package googlejam6.p710;
import java.util.*;
import java.util.Set;
import java.io.*;

public class B
{

    public static void main(String[] args) throws Exception
    {
    	File file = new File("B-large.in");
        Scanner input = new Scanner(file);
        int numCases = input.nextInt();
        boolean[] digits = new boolean[2501];
        for (int n = 0; n < numCases; n++)
        {
            String s = "";
            for(int j=0;j<2501;j++)
                digits[j]=false;
            int r = input.nextInt();
            int nums = 2*r*r-r;
            for(int i=0;i<nums;i++){
                int a = input.nextInt();
                digits[a] = digits[a] ? false : true;
            }
            for(int i=0;i<2501;i++)
                if(digits[i])
                    s = s + i + " ";
            s = s.trim();
            System.out.println("Case #"+(n+1)+": "+s);
        }
    }
}
