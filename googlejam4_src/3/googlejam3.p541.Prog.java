package googlejam3.p541;
import java.io.*;

public class Prog
{
	public static void main(String [] args)throws Exception
	{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		int i=1;
		while(i<=t)
		{
			String str = read.readLine();
			String [] arr = str.split(" ");
			int r,c,w,ans=0;
			r = Integer.parseInt(arr[0]);
			c = Integer.parseInt(arr[1]);
			w = Integer.parseInt(arr[2]);
			
			if(c == w)
			{
				ans = c;
			}
			else if(w==1)
			{
				ans = c;
			}
			else
			{
				ans += c/w;
				if ( ans*w == c)
				{
					ans--;
				}
				ans += w;
			}
			ans = ans * r;
			
			System.out.println("Case #"+i+": "+ans);
			i++;
		}
	}
}
