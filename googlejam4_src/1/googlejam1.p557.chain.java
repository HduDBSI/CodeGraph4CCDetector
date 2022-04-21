package googlejam1.p557;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class chain {
   static String s1;
	 public static void main(String[] args) throws IOException {
   	 File infile=new File("small.txt");
	 FileInputStream fis=new FileInputStream(infile);
	 DataInputStream inp=new DataInputStream(fis);

	 PrintWriter out=new PrintWriter("output.txt");
        int t = Integer.parseInt(inp.readLine().trim());
         int i=0;
         long sum1=0,sum2=0;
         for(i=1;i<=t;i++){
        	 int max=0;
        	 sum1=0;
        	 sum2=0;
        	int y= Integer.parseInt(inp.readLine().trim());
        String  s[]=inp.readLine().split(" ");
       int a[]=new int[y];
       int j=0;
       for(j=0;j<y;j++){
    	   a[j]=Integer.parseInt(s[j]);
       }
      for(j=0;j<y-1;j++){
    	  if(a[j]>a[j+1]){
    		  sum1=sum1+(a[j]-a[j+1]);
    	  }
    	  if(a[j]-a[j+1]>max)
    		  max=a[j]-a[j+1];
      }
      for(j=0;j<y-1;j++){
    	  if(a[j]>max)
    		  sum2=sum2+max;
    	  else
    		  sum2=sum2+a[j];
      }
        out.print("Case #"+i+": "+sum1+" "+sum2);
        out.println("");
     
    }
         inp.close();
         out.close();}
 

    static BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
    private static String s[], w, q;

}