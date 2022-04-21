package googlejam6.p390;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("input.in"));
		PrintWriter pw = new PrintWriter("output.out");
		int n_case = sc.nextInt();
		for(int i=1;i<=n_case;i++)
		{
			int[] count = new int[2501];
			int n = sc.nextInt();

			for(int r=0;r<2*n-1;r++)
			{
				for(int k=0;k<n;k++)
				{
					int v = sc.nextInt();
					count[v]++;
					count[v] = count[v]%2;
				}
			}
			
			String ris ="";
			for(int el=1;el<=2500;el++)
			{
				if(count[el]!=0)
				{
					ris+=el+" ";
				}
			}
			pw.println("Case #"+i+": "+ris);
		}
		sc.close();
		pw.close();
	}

}
