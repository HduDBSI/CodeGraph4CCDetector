package googlejam3.p479;
import java.util.*;
public class gcjround1C_1
{
	static Scanner sc=new Scanner (System.in);
	public static void main (String[]args)
	{
		//String newLine=""+(char)13;
		//sc.useDelimiter(newLine);

		long T=sc.nextLong();
		for (long i=0;i<T;i++)
		{
			int R=sc.nextInt();
			int C=sc.nextInt();
			int W=sc.nextInt();
			int perRow=(int)Math.ceil(C/(double)W);
			System.out.println("Case #"+(i+1)+": "+(perRow*R+ (W-1)));
		}
	}
}