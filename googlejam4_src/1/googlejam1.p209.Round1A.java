package googlejam1.p209;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;


public class Round1A {

	public static void main(String[] args)
	{
		
		Scanner s = new Scanner(System.in);
		try {
			s = new Scanner(new FileReader("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			s.close();
			return;
		}
		
		Writer out = null;
		
		try {
			out = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("output.txt"), "utf-8"));
		}
		
		catch ( IOException e ) {
            e.printStackTrace();
        }
		
		
		
		int t = s.nextInt();
		

		
		int n, res1, res2;
		
		for(int i = 0; i < t; i++)
		{ 	
			System.out.println("Case #" + (i+1));
			
			n = s.nextInt();
			
			int[] a = new int[n];
			
			for(int j = 0; j < n; j++)
				a[j] = s.nextInt();
			int n1 = a.length, res = 0;
			for(int i1 = 0; i1 < n1-1; i1++)
				if(a[i1] > a[i1+1])
					res += a[i1] - a[i1+1];
			
			res1 = res;
			int rate = 0;
			
			int n2 = a.length, res3 = 0;
			for(int i1 = 0; i1 < n2-1; i1++)
				if(rate < (a[i1] - a[i1+1]))
					rate = a[i1] - a[i1+1];
			
			for(int i2 = 0; i2 < n2-1; i2++)
				res3 += Math.min(a[i2], rate);
			res2 = res3;
			
			try {
				out.write("Case #"+(i+1)+": "+ res1 +" "+ res2 + "\n");
			}
			catch ( IOException e ) {
	            e.printStackTrace();
	        }
		}
		
		
		
		try {
		out.close();
		}
		catch ( IOException e ) {
            e.printStackTrace();
        }
		
		s.close();
		
	}

}
