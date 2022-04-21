package googlejam2.p346;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Cup2 {
	static boolean flag=false;
 
	static HashSet<String> foodlib ;

	
	public static void main (String [] args) throws IOException {
			Scanner sc = new Scanner(new File("A-small-attempt0.in"));
		 	PrintWriter out = new PrintWriter("r1.txt");
			 int T;
			 int [] dist = new int[1000001];
		     int pt=1;
		
		    dist[1]=1;
		     while (pt<1000000)
		     {
		    	 if (dist[pt+1]==0 || dist[pt+1]>dist[pt]+1) {
		    		 dist[pt+1] =dist[pt]+1;
		    		// System.out.println("case1:pt="+pt+" dist="+dist[pt+1]);
		    	 
		    	 }
				char[] nchar=String.valueOf(pt).toCharArray();
				int val=0;
				for (int i=0;i<nchar.length;i++){
					int cval=nchar[i]-'0';
					for (int j=1;j<=i;j++)
						cval *=10;
					val+=cval;
				}
		    	 
		    	 int y = val;
		    	 if (dist[y]==0 || dist[y]>dist[pt]+1)
		    	 {
		    		 dist[y]=dist[pt]+1;
		    	 }
		   // 	 System.out.println("case2:pt="+pt+" dist="+dist[pt+1]);
		    	 pt++;
		     }
		  
			  T=Integer.parseInt(sc.nextLine());
			  int count=1;

		
			  while (count<=T)
			  {     	 
				  int N = sc.nextInt();
	
			//	   out.print("Case #"+count+": ");
				  out.println("Case #"+count+": "+dist[N]);
				   
				   count++;
			  } //end one case
			out.flush();
		} // end main

}
