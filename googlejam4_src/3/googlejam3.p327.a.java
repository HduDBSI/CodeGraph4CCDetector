package googlejam3.p327;
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
public class a {
	public static void main(String[] args) {


		File fileout=new File("C:/Users/Nikhil Gupta/Desktop/A-ans.out");
		File file=null;
		PrintWriter writer=null;
		Scanner in=null;
		int r,c,w;
		try{
		 file = new File("C:/Users/Nikhil Gupta/Desktop/A-small.in");
		 in = new Scanner(file);
		 writer = new PrintWriter(fileout, "UTF-8");
		}
		catch(Exception e){}
		int T=in.nextInt();
		for(int j=1;j<=T;j++)
			{r=in.nextInt();
			c=in.nextInt();
			w=in.nextInt();
			if(r==1)
			{if(c%w==0)
				writer.println("Case #"+j+": "+((c/w)+(w-1)));
			 else
			writer.println("Case #"+j+": "+((c/w)+w));
				}
				else
				{
					if(c%w==0)
						writer.println("Case #"+j+": "+((c/w)+(w-1)+((c/w)*(r-1))));
					 else
					writer.println("Case #"+j+": "+((c/w)+w+((c/w)*(r-1))));
				}
			}
		writer.close();
	}
}
