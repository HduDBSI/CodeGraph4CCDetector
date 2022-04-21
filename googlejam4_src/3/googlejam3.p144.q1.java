package googlejam3.p144;
import java.io.*;
import java.util.Scanner;
public class q1{
	public static void main(String[]args) throws UnsupportedEncodingException,FileNotFoundException{
		FileInputStream fis = new FileInputStream("A-large.in") ;
		Scanner sc = new Scanner(fis);
		PrintWriter writer = new PrintWriter("out2.txt", "UTF-8");
		long w,r,c,res;
		int i,j;
		int test = sc.nextInt();
		for(i=1;i<=test;i++){
			r=sc.nextLong();
			c=sc.nextLong();
			w=sc.nextLong();
			res=r*(c/w)+(w-1);
			if(c%w!=0)
			res=res+1;
			writer.println("Case #"+i+": "+res);
			System.out.println("Case #"+i+": "+res);
		}
		writer.close();
	}
}