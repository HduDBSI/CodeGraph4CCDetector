package googlejam1.p222;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class exo1 
{
	public static void main(String[] args) 
	{
	
		try{
			File f = new File ("output_exo1_large");
			//File f=new File("output_exo1_small");
			//File f=new File("output_exo1_test");
			
			FileWriter fw = new FileWriter (f);
			
			
			Scanner scan = new Scanner(System.in);
			try
			{
				scan = new Scanner(new FileReader("A-large.in"));
				//scan = new Scanner(new FileReader("A-small-attempt0.in"));
				//scan = new Scanner(new FileReader("A-test.in"));
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
				scan.close();
				return;
			}
			int T=scan.nextInt();
			System.out.println("T="+T);
			int N;
			
			for (int test=1; test<=T; test++)
			{
				N=scan.nextInt();
				int[] tab=new int[N];
				for (int k=0; k<N; k++)
				{
					tab[k]=scan.nextInt();
				}
				
				//methode 1
				int rep1=0;
				int rep2=0;
				int maxdiff=0;
				int aux;
				for (int k=0; k<N-1; k++)
				{
					aux=tab[k]-tab[k+1];
					if (tab[k]>tab[k+1])
					{
						rep1+=(tab[k]-tab[k+1]);
					}
					if (aux>maxdiff)
					{
						maxdiff=aux;
					}
				}
				for (int k=0; k<N-1; k++)
				{
					if (tab[k]<maxdiff)
					{
						rep2+=tab[k];
					}
					else
					{
						rep2+=maxdiff;
					}
				}
				fw.write("Case #"+test+": "+rep1+" "+rep2+"\n");
			}
			
			fw.close();
			System.out.println("FINI!! exo1");
			
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("erreur écriture solution");
			}

	}

}
