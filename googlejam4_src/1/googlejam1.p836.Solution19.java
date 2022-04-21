package googlejam1.p836;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


class Solution19 {

    public static void main(String[] args)
    {
        try{
            PrintWriter out=new PrintWriter(new File("G://codejam//A-large.out"));
            Scanner sc=new Scanner(new File("G://codejam//A-large.in"));
            int t=sc.nextInt();
           for(int k=1;k<=t;k++)
            {
						int n=sc.nextInt();
						int[] m=new int[n];

						long sumx=0,sumy=0;
int factor=0;
						for(int i=0;i<n;i++)
						{
							m[i]=sc.nextInt();
							if(i>=1)
							{
								if(m[i]<m[i-1])
								{int newfactor=m[i-1]-m[i];
									if(newfactor>factor)
									{
										factor=newfactor;
									}

								}

							}

						}


						for(int i=0;i<n;i++)
						{
							if(i<=n-2 && m[i]>m[i+1])
							{
								sumx=sumx+m[i]-m[i+1];
							}

						if(i<n-1)
						{	if(m[i]<=factor )
							{
								sumy=sumy+m[i];
							}
							else
							{
								sumy=sumy+factor;
							}
						}
						}

						out.println("Case #"+k+": "+sumx+" "+sumy);


            }




             out.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

}