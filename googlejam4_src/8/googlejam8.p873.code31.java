package googlejam8.p873;



import java.io.IOException;
import java.util.Scanner;

public class code31 {

	public static void main(String[] args) throws NumberFormatException, IOException  {
		
		int t,c=1,n,i,j,a[][],sum=0;
		String out="";
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t!=0)
		{ 
		   out="";
		   sum=0;
		   n=sc.nextInt();
		   a=new int[n][2];
		   for(i=0;i<n;i++)
		   {
		   	   a[i][0]=sc.nextInt();
		  	   sum=sum+a[i][0];
		   	   a[i][1]=i+65;
		    }
		   while(sum>0)
		   {
		 	   int l=a.length,temp;
		    	for(i=0;i<l;i++)
		    	{
		    		for(j=0;j<l-1;j++)
		    		{
		    		   if(a[j][0]<a[j+1][0])
		    			{
		    				temp=a[j][0];
		    				a[j][0]=a[j+1][0];
		    				a[j+1][0]=temp;
		    			
		    				temp=a[j][1];
		    				a[j][1]=a[j+1][1];
		    				a[j+1][1]=temp;
		    			}
		    		  }
		    		}
		   		if(a[0][0]>a[1][0] && a[1][0]!=0)
			    {
			 	   out=out+(char)(a[0][1])+(char)(a[0][1])+" ";
				   a[0][0]--;
			       a[0][0]--;
				   sum=sum-2;
			     }
			     else
			    	 if(a[0][0]==a[1][0] && a[0][0]==1 && sum==2)
				      {
				         out=out+(char)(a[0][1])+(char)(a[1][1])+" ";
					     a[0][0]--;
					     a[1][0]--;
					     sum=sum-2;
					    }else
		    		 if(a[0][0]==a[1][0] && a[0][0]==1)
			    	   {
		    			   out=out+(char)(a[0][1])+" ";
			    		   a[0][0]--;
			    		   sum=sum-1;
			       	   }
		    		 else
		    	      {
		    		   out=out+(char)(a[0][1])+""+(char)(a[1][1])+" ";
		    		   a[0][0]--;
		    		   a[1][0]--;
		    		   sum=sum-2;
		    	       }
		    	     }
		    	   System.out.println("Case #"+c+": "+out);
		        c++;
	            t--;
		}
	}
}

		       