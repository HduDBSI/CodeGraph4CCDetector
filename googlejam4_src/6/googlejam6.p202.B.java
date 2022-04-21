package googlejam6.p202;
import java.util.*;
import java.io.*;

class B
{
	private static final String FILE = "B-large";
	private static final String FILEIN = FILE + ".in";
	private static final String FILEOUT = FILE + ".out";
	private static Scanner in;
	private static PrintWriter out;
	
	public static void main(String[] args) throws Exception
	{	
		in = new Scanner(new File(FILEIN));
		out = new PrintWriter(FILEOUT);
		int tests = in.nextInt();
		in.nextLine();
		for (int i=1;i<=tests;i++)
		{
			out.print( "Case #"+i+":");
			int n = in.nextInt();
			boolean[] a = new boolean[2501];
			for (int i3=0;i3<2*n*n-n;i3++)
			{
				int h = in.nextInt();
				a[h] = !a[h];
			}
			List<Integer> l = new ArrayList<Integer>();
			for (int i1=1;i1<=2500;i1++)
			{
				if (a[i1])
				{
					l.add(i1);
				}
			}
			Collections.sort(l);
			for (int i2:l)
			{
				out.print(" "+i2);
			}
			out.println();
			in.nextLine();
		}
		out.close();
	}
}