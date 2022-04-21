package googlejam1.p639;
import java.util.*;
import java.io.*;

import static java.lang.System.*;
public class MushMonster {

	public static void main(String[] args) throws IOException{
		FileReader fr=new FileReader("in.txt");
		BufferedReader textReader =new BufferedReader(fr);
		int num = Integer.parseInt(textReader.readLine());
		for(int k=0;k<num;k++)
		{
//keep	
		int	count=Integer.parseInt(textReader.readLine());
		String read = textReader.readLine();
		int meth1;
		int meth2;
		int shroom1=0;
		int shroom2=0;
		String[] str=read.split(" ");
		int[] intr=new int[str.length];
		for(int l=0;l<str.length;l++)
		{
			intr[l]=Integer.parseInt(str[l]);
		}
		int[] intrd=new int[str.length-1];
		for(int m=0;m<str.length-1;m++)
		{
			intrd[m]=intr[m]-intr[m+1];
		}
		Arrays.sort(intrd);
		int max=intrd[intrd.length-1];
		//out.println(max);
		for(int j=0; j<count; j++)
		{	
			//out.println(count);
			if(j<count-1&&intr[j]>intr[j+1])
				shroom1+=intr[j]-intr[j+1];
			if(intr[j]>max&&j<count-1)
				shroom2+=max;
			else if(j<count-1)
				shroom2+=intr[j];
			//out.println(shroom2);
			
		}
		
		out.println("Case #"+(k+1)+": "+shroom1+" "+shroom2);
//keep	    
		}
		textReader.close();
	}

}
