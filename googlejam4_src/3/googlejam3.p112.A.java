package googlejam3.p112;
import java.io.*;
import java.util.*;
import java.math.*;

public class A
{  
	public static void main(String[] args) throws Exception
	{
    int T;	
		RandomAccessFile in = new RandomAccessFile(args[0],"r");
		T=Integer.parseInt(in.readLine());
		

		for (int i=1; i<=T; i++)
		{
		  String[] temp=in.readLine().split("[ ]+");		  
		  int R=Integer.parseInt(temp[0]);
		  int C=Integer.parseInt(temp[1]);
		  int W=Integer.parseInt(temp[2]);
		int ans1=(R-1)*(C/W)+(C/W)+(W-1);
		if (C%W>=1) ans1++;		  		  

      String ans=""+ans1;
      System.out.println("Case #"+i+": "+ans);
    }

		in.close();
	}
}