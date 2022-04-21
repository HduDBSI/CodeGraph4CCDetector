package googlejam3.p213;
import java.io.*;
import java.util.*;
public class A {
	public static void main(String[]args) throws Exception
	{
		Scanner scan=new Scanner(new File("A-large.in"));
		PrintWriter o=new PrintWriter(new File("Aoutl0.txt"));
		int n=Integer.parseInt(scan.nextLine());
		for(int i=1;i<=n;i++)
		{
			String[]cs=scan.nextLine().split(" ");
			int r=Integer.parseInt(cs[0]);
			int c=Integer.parseInt(cs[1]);
			int w=Integer.parseInt(cs[2]);
			int ans=(int)(Math.floor(1.0*c/w))*r;
			if(c%w==0)
				ans+=w-1;
			else
				ans+=w;


			o.println("Case #"+i+": "+ans);	
		}
		scan.close();
		o.close();
	}
}

