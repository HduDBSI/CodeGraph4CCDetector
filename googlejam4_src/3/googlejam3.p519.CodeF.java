package googlejam3.p519;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CodeF
{
	public static void main (String[] args) throws java.lang.Exception, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int val = Integer.parseInt(str);
		int cnum = 1;
		while((str=br.readLine()) != null)
		{
			String[] temp = str.split(" ");
			int r = Integer.parseInt(temp[0]);
			int c = Integer.parseInt(temp[1]);
			int w = Integer.parseInt(temp[2]);
			int ans = 0;
			if (c%w == 0){ ans = ((c/w) + w - 1)*r; }
			else { ans = ((c/w) + w)*r; }
			System.out.println("Case #"+cnum +": "+ans);
			cnum++;
		}
	}
}