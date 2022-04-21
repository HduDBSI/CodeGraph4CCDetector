package googlejam8.p981;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class A {

	public static void main(String args[])
	{
		Scanner sc;
		try 
		{
			//sc = new Scanner(new File("A.in"));
			sc = new Scanner(new File("A-small-attempt0.in"));
			//sc = new Scanner(new File("A-large-attempt0.in"));
			//PrintWriter out = new PrintWriter("A.out");
			PrintWriter out = new PrintWriter("A-small-attempt0.out");
			//PrintWriter out = new PrintWriter("A-large-attempt0.out");
			int T = Integer.parseInt(sc.nextLine());
			int testcase = 1;
			char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			while(T-- > 0)
			{
				out.print("Case #" + testcase + ": ");
				int N = Integer.parseInt(sc.nextLine());
				String line = sc.nextLine();
				String[] arr = line.split(" ");
				int[] p = new int[N];
				int sump = 0;
				for(int i=0; i<N; i++)
					{	p[i] = Integer.parseInt(arr[i]);
						sump += p[i];
					}
				int large=-1,seclarge=-1;
				int lar,seclar;
				double tempsum,tempsum1,tempsum2,tempsum3;
				while(sump>0)
				{
					
					//find largest & secondlargest
					lar = Integer.MIN_VALUE;
					seclar = Integer.MIN_VALUE;
					for(int i=0; i<N; i++)
					{
						if(p[i] >= lar)
						{
						seclar = lar;
						seclarge = large;
						lar = p[i];
						large = i;
						}
						else if(p[i] >= seclar)
						{
							seclar = p[i];
							seclarge = i;
						}
					}
					//out.println();
					
					if(sump <=2)
					{
						while(p[large]>0)
						{
							p[large] = p[large] - 1;
							out.print(alphabet[large]);
							sump = sump-1;
						}
						while(p[seclarge]>0)
						{
							p[seclarge] = p[seclarge] - 1;
							out.print(alphabet[seclarge]);
							sump = sump - 1;
						}
						break;
					}
					
					boolean flag = true;
					for(int i=0; i<N; i++)
					{
						if(p[i] > 1)
						{
							flag = false;
							break;
						}
					}
					if(flag)
					{
						if(N%2 == 0)
						{
							out.print(alphabet[large]);
							out.print(alphabet[seclarge]);
							out.print(" ");
							p[large] = p[large] - 1;
							p[seclarge] = p[seclarge] -1;
							sump = sump - 2;
							continue;
						}
						else
						{
							out.print(alphabet[large]);
							out.print(" ");
							p[large] = p[large] - 1;
							sump = sump - 1;
						}
						continue;
					}
					
					
					//out.print(alphabet[large] + " " + alphabet[seclarge]+" " + p[large] + " " + p[seclarge]+" "+sump);
					if(p[large] > 1)
					{
						double val = sump-2;
						//out.print(" ... " +p[seclarge] + " " + val);
						tempsum1 = (p[seclarge]/val)*100;  //2 largest removed
						if(tempsum1 <= 50)
						{
							//out.print("loop 1 "+ tempsum1);
							p[large] = p[large] - 2;
							out.print(alphabet[large]);
							out.print(alphabet[large]);
							out.print(" ");
							sump = sump - 2;
							continue;
						}
					}
					if(p[seclarge] > 0)
					{
						tempsum2 = ((p[seclarge] - 1)/(sump-2))*100; //1 largest & 1 second largest
						if(tempsum2 <= 50)
						{
							//out.write("loop2 + " + tempsum2);
							out.print(alphabet[large]);
							out.print(alphabet[seclarge]);
							out.print(" ");
							p[large] = p[large] - 1;
							p[seclarge] = p[seclarge] -1;
							sump = sump - 2;
							continue;
						}
					}
					tempsum = ((p[large]-1)/(sump-1))*100;	//1 largest removed
					tempsum3 = ((p[seclarge])/(sump-1)) * 100; //1 largest removed
					if(tempsum <= 50 && tempsum3<=50)   //1 largest removed
					{
						//out.write("loop3 " + tempsum + " " + tempsum3 + " ");
						out.print(alphabet[large]);
						out.print(" ");
						p[large] = p[large] - 1;
						sump = sump - 1;
					}
				}
			testcase++;
			out.println();
		} 
			out.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
