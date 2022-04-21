package googlejam8.p985;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class senateevac {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int T,i,j,N,ptotal,evac=0,k,kcount=0,check=0;
		int [] P = new int[26];
		char [] alphabet = new char[26];
		String [] result = new String[1000];
		Scanner filein = new Scanner(new File("C:/codejamdata/A-small-attempt0.in"));
		PrintStream fileout = new PrintStream(new FileOutputStream("C:/codejamdata/gcj1casoutput.txt"));
		alphabet[0] = 'A';
		for(i=1;i<26;i++)
		{
			alphabet[i] = (char) ((int) alphabet[i-1] +1);
		}
		T = filein.nextInt();
		for(i=0;i<T;i++)
		{
			N = filein.nextInt();
			ptotal=0;
			for(j=0;j<N;j++)
			{
				P[j] = filein.nextInt();
				//System.out.println(P[j]);
				ptotal = ptotal + P[j];
			}
			//System.out.println("ptotal is " + ptotal);
			evac=0;
			k=0;
			kcount=0;
			if(ptotal%2>0)
				check = (ptotal+1)/2;
			else
				check = ptotal/2;
			while(evac==0)
			{
				if(ptotal<=0)
					break;
				result[k] = "";
				for(j=0;j<N;j++)
				{
					if(P[j] >= check)
					{
						result[k] = result[k] + alphabet[j];
						kcount++;
						P[j]--;
						//System.out.println(result[k] + " " + ptotal);
						if(kcount==2)
						{
							break;
						}
					}
				}
				ptotal = ptotal -kcount;
				kcount=0;
				if(result[k]=="")
				{
					for(j=0;j<N;j++)
					{
						if(P[j]>0)
						{
							result[k] = result[k] + alphabet[j];
							ptotal--;
							kcount++;
							P[j]--;
							//System.out.println(result[k] + " first  " + ptotal);
						}
						if(ptotal != 1 )
						{
							kcount=0;
							break;
						}
								
					}
				}
				k++;
				if(ptotal%2>0)
					check = (ptotal+1)/2;
				else
					check = ptotal/2;
			}
			fileout.print("Case #" + (i+1) + ": ");
			for(j=0;j<k;j++)
			{
				fileout.print(" " + result[j]);
			}
			fileout.println();

		}
		filein.close();
		fileout.close();
	}

}
