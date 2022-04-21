package googlejam6.p118;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {
	
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("b-large.in"));
		PrintWriter out = new PrintWriter(new FileWriter(new File("out.txt")));
		int zz = file.nextInt();
		for(int i = 1;i<=zz;i++)
		{
			int[] n = new int[2501];
			int N = file.nextInt();
			for(int j = 0;j<N*N*2-N;j++)
			{
				int next = file.nextInt();
				//System.out.println(next);
				n[next]++;
			}
			String ans = "";
			for(int j = 0;j<2501;j++)
			{
				if(n[j]%2==1)
					ans+=j+" ";
			}
			out.printf("Case #%d: %s%n",i,ans);
		}
		out.close();
	}
	
}
