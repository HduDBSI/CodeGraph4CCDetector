package googlejam8.p893;
import java.io.*;
import java.util.*;

public class Senate{
 
	 public static void main(String args[])throws Exception{
	 
	 BufferedReader br=new BufferedReader(new FileReader("E:/gcj16/senate.txt"));
	 PrintWriter pw=new PrintWriter("E:/gcj16/senate_out.txt");

	 int tc=Integer.parseInt(br.readLine())+1;
	 int i=0,j=0,k=0,l=0,min=0,max=1001,i1=0,n=0;
	 int []ax=null;
	 int count=0;
	 StringTokenizer st=null;
	 String temp="",op="";
	 for(i1=1;i1<tc;i1++)
		  {
                    ax=new int[26];
		    count=0;
		    n=Integer.parseInt(br.readLine());
		    st=new StringTokenizer(br.readLine());
		    for(i=0;i<n;i++){
			    ax[i]=Integer.parseInt(st.nextToken());
			    count+=ax[i];
		    }
                    op="";
		    while(count>0)
		    {       max=-1;
			    for(i=0;i<n;i++)
                             if(ax[i]>max)
				     max=ax[i];

                            j=count!=3?2:1;
			    for(i=0;i<n&&j>0;i++)
				    if(ax[i]==max)
				    {
					    j--;
					    count--;
					    ax[i]--;
					    op+=(""+((char)(65+i)));
				    }
			    op+=" ";

		    }
		    System.out.println("Case #"+i1+": "+op.trim());
		    pw.println("Case #"+i1+": "+op.trim());


		  }

	  pw.close();
	 
	 
	 }



}

